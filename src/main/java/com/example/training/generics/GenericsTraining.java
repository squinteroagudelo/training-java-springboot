package com.example.training.generics;

import com.example.training.generics.managment.GenericClass;

public class GenericsTraining {
    public static void main(String[] args) {
        GenericClass<Integer> integerObj = new GenericClass(18);
        integerObj.getType();

        GenericClass<String> stringObj = new GenericClass("Samuel");
        stringObj.getType();

        GenericClass<Boolean> booleanObj = new GenericClass(true);
        booleanObj.getType();
    }
}
