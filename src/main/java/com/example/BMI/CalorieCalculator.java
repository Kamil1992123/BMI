package com.example.BMI;

public class CalorieCalculator {

    private double weight;
    private double height;
    private double age;
    private String sex;
    private String condition;

    public CalorieCalculator(String sex,double weight, double height, double age,String condition ) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = sex;
        this.condition = condition;
    }

    public double woman(double weight, double height, double age){
//        Dla kobiet: 655 + [9,6 x masa ciała (kg)] + [1,8 x wzrost (cm)] - [4,7 x wiek (lata)]
        double result = (655 + (9.6 * weight) + (1.8 * height) - (4.7 * age)) *100;
        return result;
    }

    public double man(double weight, double height, double age){
//        Dla mężczyzn: 66 + [13,7 x masa ciała (kg)] + [5 x wzrost (cm)] – [6,76 x wiek (lata)]
        double result= (66 +(13.7 * weight) +(5 * height) - (6.76 * age)) *100;
        return result;
    }



    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
