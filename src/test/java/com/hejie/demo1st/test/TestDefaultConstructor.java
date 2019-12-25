package com.hejie.demo1st.test;

public class TestDefaultConstructor {

    public static void main(String[] args) {
        String str = "这是一串字符串";

        Dog dog = new Dog();
        Dog dog1 = new Dog(str);
        dog.barking();
        dog1.howling();
    }


}

class Dog {
    Dog() {
        System.out.println("这是一个默认构造器");
    }

    Dog(String str) {
        System.out.println(str.toString());
        System.out.println("这是重载构造器");
    }

    public void barking(){
        System.out.println("barking");
    }
    public void howling(){
        System.out.println("howling");
    }

}