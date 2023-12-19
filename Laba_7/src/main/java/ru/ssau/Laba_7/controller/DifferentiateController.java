package ru.ssau.Laba_7.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.ssau.Laba_7.components.DifferentialComponent;
import ru.ssau.Laba_7.components.MathFunctionComponent;
import ru.ssau.Laba_7.components.SettingsComponent;
import ru.ssau.Laba_7.components.TabulatedFunctionComponent;
import ru.ssau.Laba_7.functions.factory.TabulatedFunctionFactory;
import ru.ssau.Laba_7.serializable.SerializeComponents;

@Controller
@RequestMapping(value = "/differentiate")
@SessionAttributes({"mathFunction","tabulatedFunctionComponent","differentiateComponent"})
public class DifferentiateController {
    DifferentialComponent differentialComponent = new DifferentialComponent();
    @RequestMapping(method = RequestMethod.GET)
    public String getForm(@ModelAttribute("mathFunction") MathFunctionComponent mathFunctionComponent,
                          @ModelAttribute("tabulatedFunctionComponent") TabulatedFunctionComponent tabulatedFunctionComponent,
                          Model model){
        if(differentialComponent != null && differentialComponent.getTypeOfFunction() != null) {
            switch (differentialComponent.getTypeOfFunction()) {
                case "FirstFuncTab" -> {
                    tabulatedFunctionComponent.createTabulatedFunction();
                    ;
                    differentialComponent.setOper(tabulatedFunctionComponent.getFunc());
                }
                case "FirstFuncMath" -> {
                    mathFunctionComponent.createTabulatedFunction();

                    differentialComponent.setOper(mathFunctionComponent.getFunc());
                }
            }
            differentialComponent.setTypeOfFunction(null);
        }else {
            SettingsComponent comp = SerializeComponents.deserialize("savedFunctions/settings/settings.bin");
            TabulatedFunctionFactory factory = comp.getFactory();

            differentialComponent.setDifferentialOperator(factory);
        }
        model.addAttribute("differentiateComponent", differentialComponent);
        return "/differentiate";
    }
    @RequestMapping(params = "createFirstFuncTab",method = RequestMethod.POST)
    public String createFirstFuncTab (@ModelAttribute("differentiateComponent") DifferentialComponent differentialComponent,
                                    Model model){
        differentialComponent.setTypeOfFunction("FirstFuncTab");
        return "redirect:/createTabulatedFunction";
    }
    @RequestMapping(params = "createFirstFuncMath",method = RequestMethod.POST)
    public String createFirstFuncMath (@ModelAttribute("differentiateComponent") DifferentialComponent differentialComponent,
                                      Model model){
        differentialComponent.setTypeOfFunction("FirstFuncMath");
        return "redirect:/createMathTabulatedFunction";
    }
    @RequestMapping(params = "submit",method = RequestMethod.POST)
    public String submitDifferential(@ModelAttribute("differentiateComponent")DifferentialComponent differentialComponent,
                                     Model model){
        differentialComponent.doDefferentiate();
        model.addAttribute("differentiateComponent", differentialComponent);
        return "differentiate";
    }



}
