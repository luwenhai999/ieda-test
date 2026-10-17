# vibe coding 提效：提示词与规则落点

文档日期：2026-10-11。文件名按约定保留 `20261010`。

本文说明在 Cursor 里做 vibe coding 时，通用约定应该写到哪里。读者是人。不要把全文设成始终生效的规则，否则每次对话都会占用上下文。需要 Agent 每次遵守的短句，从本文摘进对应文件。

依据：

- [Rules](https://cursor.com/docs/rules)
- [Agent Skills](https://cursor.com/docs/skills)
- [Prompting agents](https://cursor.com/docs/agent/prompting)
- [Subagents](https://cursor.com/docs/subagents)
- [Hooks](https://cursor.com/docs/hooks)
- [Ignore files](https://cursor.com/docs/reference/ignore-file)

## 1. 一次对话里，模型实际看到什么

点开输入框旁的上下文环，可以看到 token 按类别拆开。和「写通用规则」相关的类别如下。

| 上下文类别 | 谁写 | 用户能不能在仓库里改 |
|---|---|---|
| System prompt | Cursor 内置，告诉模型如何当 Agent、如何使用工具 | 不能。没有可提交的系统提示词文件 |
| Rules | 团队规则、项目规则、`AGENTS.md`、`CLAUDE.md`、用户规则 | 项目内的可以提交；用户规则在设置里 |
| Skills | 各 `SKILL.md` 的名称和描述先进入上下文；正文在相关或被点名时再加载 | 可以 |
| MCP | 已连接 MCP 服务的说明和工具目录 | 在 MCP 配置里，不在规则文件里 |
| Subagents | 可委派子代理的说明 | 可以，见 `.cursor/agents/` |
| Tools | 当前可用工具的定义 | 由 Cursor 和已启用工具决定 |
| Conversation | 你这条消息、历史回复、工具结果 | 就是聊天本身 |

模型默认不记得上一轮聊天。官方说明是：规则用来在提示词层面提供可复用的持久上下文。所以「通用规则」要落成文件或设置，不能只在某次对话里说过。

## 2. 「系统提示词」对应哪一层

中文讨论里的「系统提示词」常把两层混在一起。落文件时按下面区分。

| 说法 | 实际对应 | 怎么处理 |
|---|---|---|
| Cursor 自带的系统提示词 | 上下文里的 System prompt | 不改。产品升级会变，仓库里写一份副本也会过期 |
| 我希望每次对话都额外遵守的话 | Rules 这一层 | 只属于这个仓库：`.cursor/rules/*.mdc` 或根目录 `AGENTS.md`。属于个人、所有项目：Cursor 的 Customize → Rules |
| 只有做某类事才需要的长流程 | Skills | `SKILL.md`，不要塞进始终生效的规则 |

Rules 在生效时放进模型上下文的开头，和 System prompt 分列，不是去替换 System prompt。规则不影响 Cursor Tab，也不作用于 Inline Edit（Ctrl+K）。User Rules 只给 Agent（Chat）使用。

## 3. 清单

路径里的 `~` 在 Windows 上是 `%USERPROFILE%`，例如 `C:\Users\你的用户名\.cursor\rules`。

### 3.1 每次都可能进上下文的说明

| 文档 | 位置 | 功能 | 实例 |
|---|---|---|---|
| System prompt | 无用户文件。在上下文环的 System prompt 分段里 | Cursor 内置的 Agent 行为说明：如何调用工具、如何组织回复。所有对话都有，占固定上下文 | 不手写。个人偏好写到 User Rules，例如「用中文回复」 |
| Team Rules | Cursor 团队后台，不在仓库里 | 组织统一下发，所有仓库的 Agent 对话都会带上。无 glob 时每次都在；有 glob 时只在匹配文件进入上下文时生效。可强制，成员不能关闭 | 后台正文：「公共模块禁止新增未评审依赖」 |
| 项目规则 `*.mdc` | 仓库 `.cursor/rules/文件名.mdc`，可用子目录归类 | 跟仓库走，可提交。用 frontmatter 决定始终生效、按文件生效、由 Agent 判断，或仅在聊天里 `@` 点名。`.cursor/rules` 里的普通 `.md` 会被忽略 | 见第 4 节 |
| `AGENTS.md` | 仓库根目录；子目录可再放一份 | 纯 Markdown，没有 frontmatter。根目录说明在该项目对话中生效。进入某子目录工作时，该目录的 `AGENTS.md` 与上级合并，更近的一份优先。适合人和多种 Agent 一起读 | 见下方示例 |
| `CLAUDE.md` | 与 `AGENTS.md` 相同：根目录或子目录 | Cursor 按 `AGENTS.md` 的方式读取，并且每次对话都带上，用来兼容 Claude Code。即使写了 `alwaysApply` 之类的 frontmatter，也仍然始终生效 | 内容与项目级 `AGENTS.md` 相同即可 |
| User Rules | Cursor：Customize → Rules | 跟 Cursor 账号走，所有项目的 Agent 对话都生效，换机器登录会同步。适合回复语言、个人表达习惯 | `请用中文回复。改代码前先说明要动哪些文件。` |
| 本机用户规则 | `~/.cursor/rules/*.mdc` | 只在这台电脑的所有项目生效，不随账号同步，也不进某个仓库。格式与项目规则相同 | 一份 `alwaysApply: true` 的个人约束，例如提交说明用中文 |
| `.cursorrules` | 仓库根目录 | 旧式单文件规则。Cursor 仍可能读到，官方已要求迁到 `.cursor/rules` 或 `AGENTS.md` | 新项目不要新建这个文件 |

`AGENTS.md` 示例（仓库根目录）：

```markdown
# ieda-test

本仓库是 Java 练习项目，代码在 `hcfc/`。

- 新题放在 `hcfc/src/main/java/com/juzi/month年月/day日期/`
- 类名表达题目含义，保留 `main` 方便直接运行
- 不新增与当前题目无关的依赖
```

只约束 `hcfc` 模块时，同样一份放在 `hcfc/AGENTS.md`。

### 3.2 按任务加载的说明

| 文档 | 位置 | 功能 | 实例 |
|---|---|---|---|
| `SKILL.md` | 项目：`.cursor/skills/技能名/SKILL.md` 或 `.agents/skills/技能名/SKILL.md`。个人：`~/.cursor/skills/技能名/SKILL.md` 或 `~/.agents/skills/技能名/SKILL.md`。兼容目录：`.claude/skills/`、`.codex/skills/` 及用户主目录下的同名目录 | 教 Agent 做一件具体事。启动时只把名称和描述放进 Skills 分段；正文在 Agent 判断相关，或你输入 `/技能名` 时加载。`disable-model-invocation: true` 时只能手动 `/` 调用。在 `/` 菜单里对技能按 Alt+Enter，可作为 Custom Mode，整段会话都保留该技能 | 见下方示例 |
| 技能附件 | 同一技能目录下的 `scripts/`、`references/`、`assets/` | 脚本、长参考、模板。Agent 需要时再读，避免把长文放进 `SKILL.md` | `references/checklist.md` |
| 子代理文件 | 项目：`.cursor/agents/名称.md`（兼容 `.claude/agents/`、`.codex/agents/`）。个人：`~/.cursor/agents/名称.md` | 一段独立提示词，父代理按 description 把子任务委派出去。子代理有自己的上下文。同名时项目覆盖个人，`.cursor/` 覆盖兼容目录 | 见下方示例 |
| 斜杠命令 | 旧位置已可由 `/migrate-to-skills` 迁走 | 显式点名才执行的短指令。迁移后变成带 `disable-model-invocation: true` 的技能 | 在聊天输入 `/create-rule` 生成一条项目规则 |

`SKILL.md` 示例（`.cursor/skills/run-java-demo/SKILL.md`）：

```markdown
---
name: run-java-demo
description: 在 hcfc 模块编译并运行指定的 Java main 类。用户要求跑题、验证输出或执行某个 Demo 时使用。
---

# 运行 Java 练习

1. 确认类的全限定名和 `main` 方法
2. 在 `hcfc` 目录用 Maven 编译并运行该类
3. 把标准输出和失败原因原样回报
```

子代理示例（`.cursor/agents/verifier.md`）：

```markdown
---
name: verifier
description: 功能做完后检查是否真的可运行。完成实现后主动使用。
---

对照用户要求核对改动。能运行的类要实际跑一遍，并列出已通过项和未完成项。
```

### 3.3 不写「规则正文」，但会改变 Agent 行为

| 文档 | 位置 | 功能 | 实例 |
|---|---|---|---|
| `hooks.json` | 项目：`.cursor/hooks.json`，脚本放 `.cursor/hooks/`。个人：`~/.cursor/hooks.json`。企业分发：Windows 为 `C:\ProgramData\Cursor\hooks.json` | 在读文件、改文件、执行命令、会话开始等节点跑脚本，可以观察、拦截或追加消息。这是执行约束，不是提示词。多个来源的 hook 都会跑，拒绝优先于询问，询问优先于放行 | `afterFileEdit` 调用 `.cursor/hooks/format.sh` |
| `.cursorignore` | 仓库根目录 | 用 gitignore 语法排除文件，使 Agent、Tab、Inline Edit 和 `@` 引用读不到。终端和 MCP 仍可能访问这些路径。已在 `.gitignore` 里的文件默认同样不被索引 | `**/.env`、`**/*.pem` |
| MCP 配置 | Cursor 的 MCP 设置，或项目内 MCP 配置文件 | 接入外部工具。工具说明出现在上下文的 MCP 分段，不是规则正文 | 接入一个只读的文档检索服务 |
| 当次 `@` 引用 | 聊天输入框 | 把指定文件、目录、终端、历史聊天或 diff 附到这一次提问。适合临时上下文，替代不了持久规则 | `@hcfc/pom.xml` |

## 4. 项目规则的四种生效方式

文件必须是 `.cursor/rules/*.mdc`。frontmatter 三个字段一起决定何时进入 Rules 分段。

| 界面类型 | frontmatter | 何时进入上下文 |
|---|---|---|
| Always Apply | `alwaysApply: true` | 每次 Agent 对话。此时 `globs` 和 `description` 不参与判断 |
| Apply to Specific Files | `alwaysApply: false` 且写了 `globs` | 匹配文件进入上下文时自动附上 |
| Apply Intelligently | `alwaysApply: false`，有 `description`，没有 `globs` | Agent 读描述后，认为相关再拉取全文 |
| Apply Manually | `alwaysApply: false`，没有 `description`，也没有 `globs` | 只有聊天里 `@规则名` 时附上 |

始终生效示例（`.cursor/rules/vibe-coding.mdc`）：

```markdown
---
description: vibe coding 时每次都要遵守的工作方式
alwaysApply: true
---

# Vibe coding

- 先用几句话说清要改什么、动哪些文件，再写代码
- 只改当前需求相关的文件
- 改完后给出如何在本仓库验证的命令
```

只在 Java 文件上生效时，改为：

```markdown
---
description: Java 练习代码约定
globs: hcfc/**/*.java
alwaysApply: false
---
```

多个 glob 用逗号分隔，例如 `hcfc/**/*.java, hcfc/**/*.xml`。

规则正文里写 `@某文件` 只是告诉 Agent 去读，文件内容不会自动嵌进提示词。必须每次都看到的句子，直接写在规则正文里。

官方对规则体积的建议：单条尽量短，拆成一件事一条；提供具体例子；少写模型已经会的通用命令和整本风格指南。有的材料写大约 50 行，文档上限是 500 行。始终生效的规则会在每次对话里占 token，只把「反复犯错才需要提醒」的句子放进来。

Apply Intelligently 且没有 glob 的规则，可以用内置的 `/migrate-to-skills` 迁成技能。`alwaysApply: true` 和带 `globs` 的规则不迁，User Rules 也不迁。

## 5. 冲突时谁优先

规则会合并，不是只留一种。内容冲突时，官方顺序是：

**Team Rules → Project Rules → User Rules**

越靠前越优先。

另外几条叠加规则：

- 多层 `AGENTS.md` 会合并，离当前文件更近的那份优先。
- 同名子代理：项目覆盖个人；`.cursor/` 覆盖 `.claude/`、`.codex/`。
- Hook 不是这条优先级。各层 hook 都会执行，`deny` 优先于 `ask`，`ask` 优先于 `allow`。

同一段话不要同时写进 `alwaysApply` 规则和根目录 `AGENTS.md`，否则每次对话会看到两遍。

## 6. 本仓库现状与建议

当前已有一条始终生效的项目规则：`.cursor/rules/coding-standards.mdc`。它约束注释、日志，以及只改当前需求相关代码。本仓库还没有 `AGENTS.md`、`SKILL.md`、子代理或 hooks。

以后新增约定时按这个表放。

| 你要表达的内容 | 放到 |
|---|---|
| 这个仓库每次写代码都要遵守，并且要进 git | `.cursor/rules/*.mdc`，`alwaysApply: true`。和现有编码规范同一类的短句，补进 `coding-standards.mdc`；另一类关注点则新开一个 `.mdc` |
| 只有打开某类文件才需要 | `.cursor/rules/*.mdc`，写 `globs`，`alwaysApply: false` |
| 给人读、也给其他 Agent 读的项目地图（目录怎么放题） | 仓库根目录 `AGENTS.md`。只约束 `hcfc` 时用 `hcfc/AGENTS.md` |
| 跑题、对拍输出、按清单审查这类长流程 | `.cursor/skills/技能名/SKILL.md` |
| 做完后专门派一个角色去验收 | `.cursor/agents/名称.md` |
| 所有项目都一样的个人习惯 | Customize → Rules。只想留在这台电脑时用 `~/.cursor/rules/*.mdc` |
| 公司全员、所有仓库 | 团队后台的 Team Rules |
| 保存后必须格式化、提交前必须拦截某类命令 | `.cursor/hooks.json`，不要写成提示词碰运气 |
| 密钥和本地配置不要被索引 | `.cursorignore` |

System prompt 不作为落点。本文 `20261010-vibeCoding提效-design.md` 放在仓库根目录，只给人查阅。
