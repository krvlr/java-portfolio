package ru.itis;

public class Main {

    public static void main(String[] args) {
        Auto auto1 = new Auto(4, 95);
        Auto auto2 = new Auto(4, 92);
        SportAuto sportAuto1 = new SportAuto(4, 96);
        SportAuto sportAuto2 = new SportAuto(4, 98);
        Bike bike1 = new Bike(2);
        Bike bike2 = new Bike(3);

        Transport transports[] = {auto1, auto2, sportAuto1, sportAuto2, bike1, bike2};

        /*for (int i = 0; i < transports.length; i++){
            Transport currentTansport = transports[i];
            currentTansport.go();
        }*/

        for (Transport currentTransport : transports){
            currentTransport.go();
        }

        int indexOfMinElem = 0;
        int numbOfMinWheels = transports[0].getWheelsCount();
        for (int i = 1; i < transports.length; i++){
            if (transports[i].getWheelsCount() <= numbOfMinWheels){
                numbOfMinWheels = transports[i].getWheelsCount();
                indexOfMinElem = i;
            }
        }

        System.out.println("Min wheels: " + numbOfMinWheels + ".Index in array: " + indexOfMinElem);

    }
}
