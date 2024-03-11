package com.dell;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstring {

    public static void main (String args[]){
        String s = "forgeeksskeegfor";
        int n = s.length();

        // Print all Substrings
        List<String> dataList = new ArrayList<>();
        for(int i = 0; i < n ; i ++){
            StringBuffer ss = new StringBuffer("");
            for(int j = i; j < n ; j++){
                dataList.add(ss.append(s.charAt(j)).toString());
            }
        }

        dataList.forEach(System.out::println);


        int data[][] = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    data[i][j] = 1;
                }
            }
        }

        System.out.print(" ");

        for(int i = 0 ; i < n ; i ++){
            System.out.print(" " + s.charAt(i) );
        }
        System.out.println();

        for(int i = 0 ; i < n ; i ++){
            System.out.print(s.charAt(i) + " " );
            for(int j = 0; j < n; j++){
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
