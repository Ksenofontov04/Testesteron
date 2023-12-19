package ru.ssau.Laba_7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.ssau.Laba_7.components.CalculatorComponent;
import ru.ssau.Laba_7.components.MathFunctionComponent;
import ru.ssau.Laba_7.components.SettingsComponent;
import ru.ssau.Laba_7.components.TabulatedFunctionComponent;
import ru.ssau.Laba_7.functions.factory.TabulatedFunctionFactory;
import ru.ssau.Laba_7.serializable.SerializeComponents;



@Controller
@RequestMapping(value = "/calculator")
@SessionAttributes({"mathFunction","tabulatedFunctionComponent","component"})
public class CalculatorController {

    CalculatorComponent component = new CalculatorComponent();
    @RequestMapping(method = RequestMethod.GET)
    public String getFunctions(@ModelAttribute("mathFunction")MathFunctionComponent mathFunctionComponent,
                                @ModelAttribute("tabulatedFunctionComponent")TabulatedFunctionComponent tabulatedFunctionComponent,
                                Model model)
    {
        if(component != null && component.getTypeOfFunction()!= null){
            switch (component.getTypeOfFunction()) {
                case "createFirstFuncTab" -> {
                    tabulatedFunctionComponent.createTabulatedFunction();
                    component.setOper1(tabulatedFunctionComponent.getFunc());
                }
                case "createSecondFuncTab" -> {
                    tabulatedFunctionComponent.createTabulatedFunction();
                    component.setOper2(tabulatedFunctionComponent.getFunc());
                }
                case "createFirstFuncMath" -> {
                    mathFunctionComponent.createTabulatedFunction();
                    component.setOper1(mathFunctionComponent.getFunc());
                }
                case "createSecondFuncMath" -> {
                    mathFunctionComponent.createTabulatedFunction();
                    component.setOper2(mathFunctionComponent.getFunc());
                }
            }
        }
        else {

            SettingsComponent comp = SerializeComponents.deserialize("savedFunctions/settings/settings.bin");
            TabulatedFunctionFactory factory = comp.getFactory();

            component.setOperationService(factory);
        }
        model.addAttribute("component", component);

        return "calculator";
    }
    @RequestMapping(params="submit",method = RequestMethod.POST)
    public String getResult(@ModelAttribute("component") CalculatorComponent comp,
                            @ModelAttribute("mathFunction") MathFunctionComponent component,
                            Model model){

        comp.doOperation();

        model.addAttribute("component",comp);
        return "calculator";
    }
    @RequestMapping(params = "createSecondFuncTab", method = RequestMethod.POST)
    public String createSecondFuncTab(
                                      Model model){
        component.setTypeOfFunction("createSecondFuncTab");
        return "redirect:/createTabulatedFunction";
    }
    @RequestMapping(params = "createSecondFuncMath", method = RequestMethod.POST)
    public String createSecondFuncMath(
                                      Model model){
        component.setTypeOfFunction("createSecondFuncMath");
        return "redirect:/createMathTabulatedFunction";
    }
    @RequestMapping(params = "createFirstFuncTab", method = RequestMethod.POST)
    public String createFirstFuncTab(
                                      Model model){
        component.setTypeOfFunction("createFirstFuncTab");
        return "redirect:/createTabulatedFunction";
    }
    @RequestMapping(params = "createFirstFuncMath", method = RequestMethod.POST)
    public String createFirstFuncMath(
                                       Model model){
        component.setTypeOfFunction("createFirstFuncMath");
        return "redirect:/createMathTabulatedFunction";
    }
    @RequestMapping(params = "saveSecondFunc", method = RequestMethod.POST)
    public String saveSecondFunc(@ModelAttribute("component")CalculatorComponent component,
                                      Model model){
        component.setTypeOfFunction("SecondFunc");
        return "redirect:/saveFunction";
    }
    @RequestMapping(params = "saveFirstFunc", method = RequestMethod.POST)
    public String saveFirstFunc(@ModelAttribute("component")CalculatorComponent component,
                                 Model model){
        component.setTypeOfFunction("FirstFunc");
        return "redirect:/saveFunction";
    }
    @RequestMapping(params = "saveResultFunc", method = RequestMethod.POST)
    public String saveResultFunc(@ModelAttribute("component")CalculatorComponent component,
                                Model model){
        component.setTypeOfFunction("ResultFunc");
        return "redirect:/saveFunction";
    }
}
