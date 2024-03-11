package com.dell;

import java.util.*;

public class TestApp6 {

    public static void main (String args[]){

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("app");
        list.add("appetitie");

        Collections.sort(list, (x,y) -> x.length()-y.length());

        list.forEach(x -> System.out.println(x));

        System.out.println("------------------------------------");

        String small = list.get(0);
        while(small.length() > 0){
            Boolean flag = false;
            for(int i = 1 ; i < list.size(); i++){
                if(list.get(i).contains(small)){
                    flag = true;
                }else{
                    flag = false;
                    break;
                }
            }
            if(!flag){
                small = small.substring(0,small.length()-1);
            }else{
                System.out.println(small);
                break;
            }
        }


    }
}
