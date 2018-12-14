package com.raka.myapp2.model;

public class Employee {
    private int NIK;
    private String name;
    private String birthPlace;
    private String birthDate;
    private String address;
    private String hobby;
    private String gender;

    public Employee(int NIK, String name, String birthPlace, String birthDate, String address, String hobby, String gender) {
        this.NIK = NIK;
        this.name = name;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
        this.address = address;
        this.hobby = hobby;
        this.gender = gender;
    }

    public int getNIK() {
        return NIK;
    }

    public void setNIK(int NIK) {
        this.NIK = NIK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
