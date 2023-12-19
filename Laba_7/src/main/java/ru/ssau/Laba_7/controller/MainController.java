package ru.ssau.Laba_7.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.ssau.Laba_7.components.CalculatorComponent;
import ru.ssau.Laba_7.components.MathFunctionComponent;
import ru.ssau.Laba_7.components.TabulatedFunctionComponent;

@Controller
@RequestMapping("/main")
@SessionAttributes({"mathFunction","tabulatedFunctionComponent","component"})
public class MainController {
    @RequestMapping(method = RequestMethod.GET)
    public String mainGEt(Model model){
        System.out.println(111);
        model.addAttribute("mathFunction", new MathFunctionComponent());
        model.addAttribute("tabulatedFunctionComponent",new TabulatedFunctionComponent());
        model.addAttribute("component",new CalculatorComponent());
        return"main";
    }

}