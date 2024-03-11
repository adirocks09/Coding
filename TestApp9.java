package com.dell;

import java.util.*;

public class TestApp9 {

    public static void main (String args[]){

        List<String> data = Arrays.asList("Eat","tea","tan","ate","nat","bat");
        Map<String,List<String>> dataMap = new HashMap<>();

        data.forEach(x -> {
            String hash = getHash(x.toUpperCase());
            if(dataMap.get(hash) == null){
                dataMap.put(hash, new ArrayList<>());
            }
            dataMap.get(hash).add(x);
        });

        dataMap.values().forEach(System.out::println);
    }

    private static String getHash(String x) {
        char ch[] = x.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}
