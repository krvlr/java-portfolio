package models;

public class CarUser {
    private int idCar;
    private int idUser;

    public CarUser(int idCar, int idUser) {
        this.idCar = idCar;
        this.idUser = idUser;
    }

    public CarUser(){
    }

    public int getIdCar() {
        return idCar;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
