package com.dell;
import java.util.*;

public class TestApp2 {
    public static void main(String args[]){
        String s = "aab";
        System.out.println(getString(s));
    }

    public static String getString(String s){
        String word = "";
        int j = 0;
        int k = 1;
        while(j < s.length() && k <s.length()){
            Character ch1 = s.charAt(j);
            Character ch2 = s.charAt(k);
            if(ch1 == ch2){
                k++;
            }else{
                word = swap(s,ch1,ch2,j,k);
                j++;
            }
        }
        return word;
    }

    private static String swap(String s, char ch1, char ch2, int j, int k) {
        char ch[] = s.toCharArray();
        ch[j] = ch2;
        ch[k] = ch1;
        return String.valueOf(ch);
    }
}
