package ru.ssau.Laba_7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.ssau.Laba_7.components.MathFunctionComponent;
import ru.ssau.Laba_7.functions.*;
import ru.ssau.Laba_7.io.TabulatedFunctionSerialization;

@Controller
@RequestMapping(value = "/createMathTabulatedFunction")
@SessionAttributes({"mathFunction"})
public class MathTabulatedFunction {
    @RequestMapping(method = RequestMethod.GET)
    public String getForm(@ModelAttribute("mathFunction")MathFunctionComponent mathFunctionComponent,
                          Model model){


        mathFunctionComponent.map.put("Identity Function",new IdentityFunction());
        mathFunctionComponent.map.put("Sqr Function",new SqrFunction());
        mathFunctionComponent.map.put("Unit Function",new UnitFunction());


        model.addAttribute("mathFunction",mathFunctionComponent);
        model.addAttribute("functions",mathFunctionComponent.map);

        return "createMathTabulatedFunction";
    }
    @RequestMapping(name = "submit", method = RequestMethod.POST)
    public String setForm(@ModelAttribute("mathFunction") MathFunctionComponent component,
                          Model model){
        model.addAttribute("functions",component.map);
        component.createTabulatedFunction();

        TabulatedFunctionSerialization.serialize("savedFunctions/linked list/funcCreatedWithMathFunction.bin",component.getFunc());
        System.out.println(TabulatedFunctionSerialization.deserialize("savedFunctions/linked list/funcCreatedWithMathFunction.bin"));

        return "main";
    }
}
