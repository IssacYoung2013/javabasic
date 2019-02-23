package com.interview.javabasic.collection;

import java.util.*;

/**
 *
 * author:  ywy
 * date:    2019-02-20
 * desc:
 */
public class Customer implements Comparable {

    private String name;

    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return age == customer.age &&
                Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        int result;
        result = (name == null ? 0: name.hashCode());
        result = 29 * result + age;

        return result;
    }

    @Override
    public int compareTo(Object o) {
        Customer other = (Customer) o;

        if(this.name.compareTo(other.getName()) > 0) {
            return 1;
        }
        if(this.name.compareTo(other.getName()) < 0) {
            return -1;
        }

        if(this.age > other.age) {
            return 1;
        }
        if(this.age < other.age) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
//        Set<Customer> set = new TreeSet<>();
//        Customer customer1 = new Customer("Tom",16);
//        Customer customer2 = new Customer("Tom",15);
//        set.add(customer1);
//        set.add(customer2);
//        for (Customer c :
//                set) {
//            System.out.println(c.name + " " + c.age);
//        }

        Map<String,Customer> map = new HashMap<>();
        map.put("aaa",new Customer("Tom",12));
        map.put("bbb",new Customer("Tom",12));
        map.put("ccc",new Customer("Tom",12));
        map.put("ddd",new Customer("Tom",12));
        map.put("eee",new Customer("Tom",12));
        map.put("fff",new Customer("Tom",12));
        map.put("ggg",new Customer("Tom",12));
        map.put("hhh",new Customer("Tom",12));
        map.put("iii",new Customer("Tom",12));

        map.put("aaa1",new Customer("Tom",12));
        map.put("bbb2",new Customer("Tom",12));
        map.put("ccc3",new Customer("Tom",12));
        map.put("ddd4",new Customer("Tom",12));
        map.put("eee5",new Customer("Tom",12));

        map.put("jjj",new Customer("Tom",12));




    }
}
