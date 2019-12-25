package com.hejie.demo1st.test;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import org.junit.jupiter.api.Test;

public class Test04 {
    @Test
    public static void main(String[] args) {
        int n = 1;
        int k = 1;
        int m ;
        int j = 10;
        for(int  i =0 ;i<10;i++){
            m=n+k;
            n=k;
            k=m;
            System.out.println(k);
        }

        System.out.println(k);

    }


    }


