package ru.itis.models;

public class CarUser {
    private int idCar;
    private int idUser;

    public CarUser(int idCar, int idUser) {
        this.idCar = idCar;
        this.idUser = idUser;
    }

    public int getIdCar() {
        return idCar;
    }

    public int getIdUser() {
        return idUser;
    }
}
