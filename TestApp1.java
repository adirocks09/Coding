package com.dell;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestApp1 {

    public static void main (String args[]){
        filterData();
    }

    private static void filterData() {
        List<Employee> empList=new ArrayList<Employee>();
        //find filter 2nd highest salary department wise.
        empList.add(new Employee(100,"Abc","IT",1000, "Bangalore"));
        empList.add(new Employee(101,"Bcd","IT",4000, "Bangalore"));
        empList.add(new Employee(102,"Begcd","IT",2500, "Pune"));
        empList.add(new Employee(103,"Cdeef","HR",1500, "Bangalore"));
        empList.add(new Employee(104,"Abcxyz","HR",1000, "Hyderabad"));
        empList.add(new Employee(105,"Abcmno","HR",2000, "Hyderabad"));
        empList.add(new Employee(106,"Abcefg","Admin",1200, "Noida"));
        empList.add(new Employee(107,"Abchij","Admin",1500, "Bangalore"));

        //Collections.sort(empList,(a,b) -> a.getName().compareToIgnoreCase(b.getName()));
        Collections.sort(empList,(a,b) -> a.getSalary()-b.getSalary());
        empList.sort((a,b) -> a.getSalary()-b.getSalary());

        Map<String,List<Employee>> map = new LinkedHashMap<>();
        empList.forEach(x -> {
            if(map.get(x.getDept())==null){
                map.put(x.getDept(),new ArrayList<>());
            }
            if(map.get(x.getDept())!=null){
                map.get(x.getDept()).add(x);
            }
        });

        for(Map.Entry<String,List<Employee>> data : map.entrySet()){
            System.out.println(data.getKey() + " : " + data.getValue().get(1).toString());
        }

        Map<String,List<Employee>> map2 = empList.stream().collect(Collectors.groupingBy(Employee::getDept));
        map2.values().forEach(x-> Collections.sort(x, (a,b) -> a.getSalary()-b.getSalary()));

        Map<String,Employee> map3 = empList.stream().collect(Collectors.toMap(Employee::getName, Function.identity()));
        System.out.println("Aditya");

    }

}

