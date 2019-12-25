package com.hejie.demo1st.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test02 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入杨辉三角层数：");
        // 行数
        int row = Integer.parseInt(br.readLine());
        // 创建二维数组
        int[][] arr = new int[row][row];
        // 指定杨辉三角中竖变和斜边的值赋予1
        for (int i = 0; i < row; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
        }
        // 确定除1以外的数
        for (int i = 2; i < row; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }

        // 打印二维数组
        String maxNumLengthSpace = "";
        String maxNum = String.valueOf(arr[row-1][row/2]);;
        // 根据最大数字的长度，确定空格的大小
        for (int m = 0; m < maxNum.length(); m++){
            maxNumLengthSpace += " ";
        }

        for (int i = 0; i < row; i++) {
            // 打印杨辉三角左边的空格
            for (int j = 0; j < row-1-i; j++)
                System.out.print(maxNumLengthSpace + " ");
            // 打印杨辉三角数字间的空格
            for (int j = 0; j <= i; j++) {
                String moreNumLengthSpace = "";
                // 得到当前数字
                String num = String.valueOf(arr[i][j]);
                // 根据相邻两数长度的差值确定空格数，数字长度越长，空格数越少(因为相邻两数的最高位之间的距离相等)
                for (int a = 0; a <= (maxNum.length() - num.length()); a++) {
                    moreNumLengthSpace += " ";
                }
                System.out.print(arr[i][j] + maxNumLengthSpace + moreNumLengthSpace + " ");
            }
            System.out.println();
        }

    }

}

