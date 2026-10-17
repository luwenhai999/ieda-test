package com.juzi.month202603.day20260307;

/**
 * 尝试在finally中return
 *
 * @author wenhai.lu
 * Create at 2026-03-07 下午 8:23
 */
public class TryFinallyReturn {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int i = tryTest();
        System.out.println(i);
    }

    /**
     * finally中的return
     * 1. 是最终值,会覆盖掉主流中的真实值
     * 2. 会覆盖掉主流程中的异常
     * <p>
     * finall中的throw
     * 1. 会覆盖掉主流程中的异常
     *
     * @return
     */
    private static int tryTest() {
        try {
            int a = 1 / 0;
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            throw new RuntimeException("好的");
        }
    }
}
