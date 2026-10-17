package com.juzi.month202602.day20260201;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 针对对象进行排序
 *
 * @author wenhai.lu
 * Create at 2026-02-01 21:45
 */
public class UserSort {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User(32, "文海"));
        list.add(new User(30, "卢刚"));
        list.add(new User(31, "红良"));
//        list.sort(Comparator.comparingInt(User::getAge));
        Collections.sort(list, (first, second) -> first.getAge() - second.getAge());
        System.out.println(JSONObject.toJSONString(list));
    }

    public static class User {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
