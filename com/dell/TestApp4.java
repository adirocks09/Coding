package com.dell;
import java.util.*;
public class TestApp4 {
    public static void main(String[] args) {
        String s1 = "abaa";
        String s2 = "aaab";
        System.out.println(checkAnagram2(s1,s2));

        String data[] = {"eat","tea","eta","tan","ate","nat","bat"};


        // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        List<String> dataList = new ArrayList<>(Arrays.asList(data));
        List<List<String>> finalList = new ArrayList<>();

        for(int i = 0; i < dataList.size(); i++){
            String s3 = dataList.get(i);
            List<String> datList = new ArrayList<>();
            datList.add(s3);
            int j = i+1;
            while(j < dataList.size()){
                String s4 = dataList.get(j);
                if(checkAnagram2(s3, s4)){
                    datList.add(s4);
                    dataList.remove(s4);
                }else{
                    j++;
                }
            }
            finalList.add(datList);
        }

        finalList.forEach(x -> System.out.println(x.toString()));

    }

    public static boolean checkAnagram2(String s1, String s2){

        if(s1==null || s2 == null){
            return false;
        }

        if (s1.length()!=s2.length()){
            return false;
        }

        char ch1[] = s1.toCharArray();
        Arrays.sort(ch1);

        char ch2[] = s2.toCharArray();
        Arrays.sort(ch2);

        if(String.valueOf(ch1).equals(String.valueOf(ch2))){
            return true;
        }else{
            return false;
        }

    }

    public static boolean checkAnagram(String s1, String s2){
        Boolean ret = false;

        if(s1==null || s2 == null){
            return false;
        }

        if (s1.length()!=s2.length()){
            return false;
        }


        Map<Character,Integer> countMap1 = createCountMap(s1);
        Map<Character,Integer> countMap2 = createCountMap(s2);

        int count = 0;
        for(Map.Entry<Character, Integer> map : countMap1.entrySet()){
            Character key = map.getKey();
            if(countMap1.get(key) == countMap2.get(key)){
                countMap2.remove(key);
                count++;
            }
        }

        if(countMap2.size()==0 && count == countMap1.size()){
            return true;
        }

        return ret;

    }

    public static Map<Character,Integer> createCountMap(String s){
        Map<Character,Integer> countMap = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            Character ch = s.charAt(i);
            if(countMap.get(ch) == null){
                countMap.put(ch,1);
            }else{
                countMap.put(ch,countMap.get(ch)+1);
            }
        }
        return countMap;
    }
}
