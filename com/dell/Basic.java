package com.dell;

import java.util.*;
import java.util.stream.Collectors;

public class Basic {

    public static void main(String args[]){

        // Array to List
        Integer data[] = {5,3,1,9,10,0,7,10};
        List<Integer> dataList = new ArrayList<>(Arrays.asList(data));
        dataList.add(20);
        System.out.println(dataList.toString());  // Printing List Directly
        dataList.forEach(x -> System.out.println(x));

        System.out.println("-------------------------");

        // List to Array
        Integer copyData[] = dataList.toArray(new Integer[0]);
        Arrays.stream(copyData).forEach(x -> System.out.println(x));

        System.out.println("-------------------------");

        // Sorting Array
        Arrays.sort(copyData);
        System.out.println(String.valueOf(copyData));
        Arrays.stream(copyData).forEach(x -> System.out.println(x));

        // Sorting List
        dataList.sort((x1, x2) -> x1-x2);
        Collections.sort(dataList, (x1, x2) -> x1-x2);
        Collections.sort(dataList, Collections.reverseOrder());  // Collecton.reverseOrder() returns a Comparator

        dataList.stream().sorted((x1, x2) -> x1-x2).collect(Collectors.toList());

        System.out.println("-------------------------");

        //String to Character Array / List
        String s = "aditya";
        char ch[] = s.toCharArray();
        int ascii[] = s.chars().toArray();

        Arrays.stream(ascii).forEach(x -> System.out.println(x));

        System.out.println("-------------------------");

        for(char x: ch){
            System.out.println(x);
        }

        System.out.println("-------------------------");

        //Character Array to String
        String word = String.valueOf(ch);
        System.out.println(word);

        System.out.println("-------------------------");

        // Iterating HashMap
        HashMap<Integer, String> dataMap = new HashMap<Integer, String>();
        dataMap.put(22,"A");
        dataMap.put(55,"B");
        dataMap.put(33,"Z");
        dataMap.put(44,"M");
        dataMap.put(99,"I");
        dataMap.put(88,"X");
        System.out.println(dataMap.toString());
        dataMap.forEach((k,v) -> System.out.println(k +  " : " + v));

        System.out.println("-------------------------");

        List<String> values = dataMap.values().stream().toList();  // Get all Keys
        Set<Integer> keys = dataMap.keySet(); // Get All Values

        for(Map.Entry<Integer,String> map : dataMap.entrySet()){
            System.out.println(map.getKey()+  " : " + map.getValue());
        }

        System.out.println("-------------------------");

        // Sorting HashMap Based On Value
        dataMap.entrySet()
                .stream()
                .sorted((x1, x2) -> x1.getValue().compareTo(x2.getValue()))
                .forEach(x -> System.out.println(x.getKey() + " :: " + x.getValue()));

        System.out.println("-------------------------");
        Map<Integer, String> sortedDataMap = dataMap.entrySet()
                                                         .stream()
                                                              //.sorted(Map.Entry.<Integer, String>comparingByValue())
                                                              .sorted((x1, x2) -> x1.getValue().compareTo(x2.getValue()))
                           .collect(Collectors.toMap(x->x.getKey(), x->x.getValue(), (oldKey, newKey) -> oldKey, LinkedHashMap::new));

        sortedDataMap.forEach((k,v) -> System.out.println(k + " : " + v));

        System.out.println("-------------------------");

        //Find filter 2nd highest salary department wise.
        List<Employee> empList=new ArrayList<Employee>();
        empList.add(new Employee(100,"Abc","IT",1000, "Bangalore"));
        empList.add(new Employee(101,"Bcd","IT",4000, "Bangalore"));
        empList.add(new Employee(102,"Begcd","IT",2500, "Pune"));
        empList.add(new Employee(103,"Cdeef","HR",1500, "Bangalore"));
        empList.add(new Employee(104,"Abcxyz","HR",1000, "Hyderabad"));
        empList.add(new Employee(105,"Abcmno","HR",2000, "Hyderabad"));
        empList.add(new Employee(106,"Abcefg","Admin",1200, "Noida"));
        empList.add(new Employee(107,"Abchij","Admin",1500, "Bangalore"));

        Map<String,List<Employee>> empMap = empList.stream().collect(Collectors.groupingBy(x -> x.getDept() + "_" + x.getLocation()));

        System.out.println(empMap.toString());

        System.out.println("-------------------------");

        empMap.forEach((k,v) -> {
            Optional<Employee> e = v.stream().skip(1).findFirst();
            if(e.isPresent()){
                System.out.println(k + " : " + e.toString());
            }else{
                System.out.println(k + " : " + " No Data");
            }
        });

        // Filtering Duplicates
        List<Integer> list = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
        Set<Integer> dupData = list.stream().filter(x -> Collections.frequency(list, x) > 1).collect(Collectors.toSet());

    }
}
