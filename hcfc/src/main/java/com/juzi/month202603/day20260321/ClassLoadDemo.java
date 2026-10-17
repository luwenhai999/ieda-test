package com.juzi.month202603.day20260321;

/**
 * 类加载尝试
 *
 * @author wenhai.lu
 * Create at 2026-03-21 下午 3:32
 */
public class ClassLoadDemo {
    public static void main(String[] args) throws InterruptedException {
//        List<Long> list = new ArrayList<>(10);
//        Long i = 1L;
//        while (true) {
//            System.out.println(i);
//            Thread.sleep(1L);
//            list.add(i++);
//        }
        Class<ClassLoadDemo> aaClass = ClassLoadDemo.class;
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
        System.out.println(classLoader.getParent().getParent().getParent());
    }
}
