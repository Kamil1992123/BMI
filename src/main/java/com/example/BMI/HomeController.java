package com.example.BMI;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home"; }

    @GetMapping("/bmi")
    public String bmi(){
        return "bmi"; }

    @GetMapping("/caloriecalculator")
    public String caloriecalculator() {
        return "calorieCalculator"; }

    @GetMapping("/caloriecalculatorresult")
    public String calorieCalculatorResult(@RequestParam int weight,
                                          @RequestParam int height,
                                          @RequestParam int age,
                                          @RequestParam String sex,
                                          @RequestParam String condition,
                                          ModelMap map) {
        CalorieCalculator person = new CalorieCalculator(sex,weight,height,age,condition);

        double valueW = Math.round(person.woman(weight,height,age));
        valueW /= 100;
        double valueM = Math.round(person.man(weight,height,age));
        valueM /= 100;

        if (sex.equals("Kobieta")){
                   if (condition.equals("0")){
                map.put("bmrDayliNeed",valueW *1.2);
            } else if (condition.equals("1")){
                map.put("bmrDayliNeed",valueW *1.4);
            } else if (condition.equals("2")){
                map.put("bmrDayliNeed",valueW *1.6);
            } else if (condition.equals("3")){
                map.put("bmrDayliNeed",valueW *1.75);
            } else if (condition.equals("4")){
                map.put("bmrDayliNeed",valueW *2.0);
            } else if (condition.equals("5")){
                map.put("bmrDayliNeed",valueW *2.2);
            }
            map.put("bmr",valueW);

        } else if (sex.equals("Mężczyzna")){
                   if (condition.equals("0")){
                map.put("bmrDayliNeed",valueM *1.2);
            } else if (condition.equals("1")){
                map.put("bmrDayliNeed",valueM *1.4);
            } else if (condition.equals("2")){
                map.put("bmrDayliNeed",valueM *1.6);
            } else if (condition.equals("3")){
                map.put("bmrDayliNeed",valueM *1.75);
            } else if (condition.equals("4")){
                map.put("bmrDayliNeed",valueM *2.0);
            } else if (condition.equals("5")){
                map.put("bmrDayliNeed",valueM *2.2);
            }
            map.put("bmr",valueM);
        }

    return "calorieCalculatorResult"; }


        @GetMapping("/result")
    public String bmiResult(@RequestParam int weight,
                            @RequestParam int height,
                            ModelMap map){
        Bmi bmi = new Bmi(weight,height);

        double resultBmi= Math.round(bmi.result(weight,height));
        resultBmi /= 100;
             map.put("bmi", resultBmi);
        return "bmiResult";}
}