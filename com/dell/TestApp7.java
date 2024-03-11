package com.dell;

import java.util.*;

public class TestApp7 {

    public static void main(String args[]){
        String s = "JavaConceptOfTheDay";

        char ch[] = s.toCharArray();

        Map<Character, Integer> map = new LinkedHashMap<>();
        Boolean flag = false;
        for(char x : ch){
            if(map.get(
                    x) == null){
                map.put(x,1);
            }else{
                map.put(x, map.get(x) + 1);
                if(!flag){
                    System.out.println("1st Repeated Char : " + x);
                    flag = true;
                }
            }
        }

        for(Map.Entry<Character,Integer> data : map.entrySet()){
            if(data.getValue()==1){
                System.out.println("1st Non Repeated Char : " + data.getKey());
                break;
            }
        }

    }
}
