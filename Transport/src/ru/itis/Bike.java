package ru.itis;

/**
 * Created by KFU-user on 29.09.2016.
 */
class Bike extends Transport {

    public Bike (int wheelsCount){
        super(wheelsCount);
    }

    public void go(){
        System.out.println("I'm Bike");
    }
}
