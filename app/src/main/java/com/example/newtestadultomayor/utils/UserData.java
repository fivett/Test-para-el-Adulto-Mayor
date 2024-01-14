package com.example.newtestadultomayor.utils;

public class UserData {

    private static int age;
    private static boolean sex;

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        UserData.age = age;
    }

    public static boolean isSex() {
        return sex;
    }

    public static void setSex(boolean sex) {
        UserData.sex = sex;
    }
}
