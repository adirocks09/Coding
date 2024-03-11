package com.dell;

import java.util.*;

public class TestApp5 {

    public static void main(String args[]){

        HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
        hashmap.put(22,"A");
        hashmap.put(55,"B");
        hashmap.put(33,"Z");
        hashmap.put(44,"M");
        hashmap.put(99,"I");
        hashmap.put(88,"X");

       /* HashMap<String, Integer> reverse = new HashMap();
        for(Map.Entry<Integer,String> data : hashmap.entrySet()){
            reverse.put(data.getValue(), data.getKey());
        }*/

        LinkedHashMap<Integer, String> reverse = new LinkedHashMap();
        List<String> values = new ArrayList<>(hashmap.values().stream().toList());
        Collections.sort(values);

        values.forEach(x -> {
            for(Map.Entry<Integer,String> data : hashmap.entrySet()){
                if(x.equals(data.getValue())){
                    reverse.put(data.getKey(), data.getValue());
                }
            }
        });

        for(Map.Entry<Integer,String> data : reverse.entrySet()){
            System.out.println(data.getKey() +  " :: " + data.getValue());
        }

    }

}
