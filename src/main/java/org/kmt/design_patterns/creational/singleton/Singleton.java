package org.kmt.design_patterns.creational.singleton;

public class Singleton {

    public static Singleton firstInstane = null;

    private Singleton(){}

    public static Singleton getInstance(){
        if(firstInstane == null){
            //lazy initialization
            firstInstane = new Singleton();
        }
        return firstInstane;
    }

}
