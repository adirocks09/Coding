package com.dell.string;

import java.util.*;

public class StringApp1 {
    public static void main(String args[]){
        // String s = "ababcdddefgfhijijh";  // op = abab c ddd e fgf hijijh
         String s = "ababcdeddefgfhijijh";  // op = abab c ddde fgf hijijh

        //String s = "ababcd";  // op = abab c ddd e fgf hijijh

        Map<Character,Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.get(ch)==null){
                map.put(ch,1);
            }else{
                map.put(ch, map.get(ch)+1);
            }
        }

        System.out.println(map);

        StringBuilder ss = new StringBuilder("");

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int count = map.get(ch);
            Boolean isFirst = checkIfFirst(map,ch);
            //System.out.println(ch + " : " + count + " : " + isFirst + " : " + ss.toString());
            if(isFirst && ss.toString().indexOf(ch) == -1){
                System.out.println("Word is : " + ss.toString());
                ss = new StringBuilder("");
            }
            if(count>0){
                ss.append(ch);
                count--;
                map.put(ch,count);
                if(count==0){
                    map.remove(ch);
                }
            }
            //System.out.println(map);
            //System.out.println("----------------------------------");
        }
        System.out.println("Word is : " + ss.toString());
    }

    private static Boolean checkIfFirst(Map<Character, Integer> map, char ch) {
        for(Map.Entry<Character, Integer> data : map.entrySet()){
            if(data.getKey().equals(ch)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
