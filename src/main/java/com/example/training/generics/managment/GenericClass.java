package com.example.training.generics.managment;

public class GenericClass<T> {
    T object;

    public GenericClass(T object){
        this.object = object;
    }

    public void getType(){
        System.out.println("Generic type: " + this.object.getClass().getSimpleName());
    }
}
