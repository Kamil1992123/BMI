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
                                          ModelMap map) {
        CalorieCalculator person = new CalorieCalculator(sex,weight,height,age);

        double valueW = Math.round(person.woman(weight,height,age));
        valueW /= 100;
        double valueM = Math.round(person.man(weight,height,age));
        valueM /= 100;

        if (sex.equals("Kobieta")){
            map.put("person",valueW);
        }else if (sex.equals("Mężczyzna")){
            map.put("person",valueM);  }
    return "calorieCalculatorResult"; }


        @GetMapping("/result")
    public String bmiResult(@RequestParam int weight,
                            @RequestParam int height,
                            ModelMap map){
        Bmi bmi = new Bmi(weight,height);

        double resultBmi= Math.round(bmi.result(weight,height));
        resultBmi /= 100;

        if (resultBmi > 25 && resultBmi < 30){
             map.put("bmi", resultBmi);}
        return "bmiResult";  }

}
