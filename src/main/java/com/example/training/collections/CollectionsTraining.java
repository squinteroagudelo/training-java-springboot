package com.example.training.collections;

import java.util.*;

public class CollectionsTraining {
    public static void main(String[] args) {
        Set myset = new HashSet();
        myset.add(2);
        myset.add("Ricardo");
        myset.add("Agudelo");
        myset.add(31);
//        Omits repeated items
        myset.add(31);

        printCollection(myset);

        List myList = new ArrayList();
        myList.add(1);
        myList.add("Samuel");
        myList.add("Quintero");
        myList.add(31);
//        Allows repeated items
        myList.add(31);

        printCollection(myList);

        Map myMap = new HashMap();
        myMap.put("id", 3);
        myMap.put("name", "Samuel");
        myMap.put("lastname", "Quintero");
        myMap.put("edad", 21);
//        Replaces repeated items
        myMap.put("edad", 31);

        printCollection(myMap.keySet());
        printCollection(myMap.values());
    }

    private static void printCollection(Collection collection) {
        System.out.println("\n---- " + collection.getClass().getSimpleName() + "----");
        for (Object element : collection) {
            System.out.println("element = " + element);
        }
    }
}
