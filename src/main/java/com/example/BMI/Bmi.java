package com.example.BMI;

public class Bmi {

    private int weight;
    private int height;


    public Bmi(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double result(double weight,double height){
        return ((weight / (height * height))*1000000);
    }
}
