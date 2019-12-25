package com.hejie.demo1st.test;

import org.junit.jupiter.api.Test;

public class Test03 {
    @Test
    public static void main(String[] args) {
        for(int n=1;n<=11;n++){
        int method = method(n);
        System.out.println(method);
    }}

    public static int method(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int i = method(n - 1) + method(n - 2);
        return i;
    }
}
