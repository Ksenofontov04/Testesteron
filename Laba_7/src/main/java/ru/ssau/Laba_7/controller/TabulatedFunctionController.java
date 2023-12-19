package ru.ssau.Laba_7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ssau.Laba_7.components.TabulatedFunctionComponent;
import ru.ssau.Laba_7.functions.Point;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/createTabulatedFunction")
@SessionAttributes({"mathFunction","tabulatedFunctionComponent","component"})
public class TabulatedFunctionController {
    private Integer size;

    @RequestMapping(method = RequestMethod.GET)
    public String amountOfPointsForm(Model model){

        size = 0;
        model.addAttribute("point",new Point());

        return "createTabulatedFunction";
    }

    @RequestMapping(params = "submit", method = RequestMethod.POST)
    public String amountOfPointsSubmit(@ModelAttribute("tabulatedFunctionComponent") TabulatedFunctionComponent tabulatedFunctionComponent,
                                       @ModelAttribute("point")Point pt,
                                       Model model){
        model.addAttribute("tabulatedFunctionComponent", tabulatedFunctionComponent);
        return "createTabulatedFunction";

    }
    @RequestMapping(params = "add", method = RequestMethod.POST)
    public String pointAdd(@ModelAttribute("tabulatedFunctionComponent") TabulatedFunctionComponent tabulatedFunctionComponent,
                           @ModelAttribute("point")Point point,
                           Model model){
        Integer amountOfPoints = tabulatedFunctionComponent.getAmount();
        List<Point> pointList= tabulatedFunctionComponent.getPointList();
        if(size < amountOfPoints) {
            if( pointList.size() < 1
                    ||
                    point.getX() >= pointList.get(pointList.size()-1).getX()
                            &&
                            point.getY() >= pointList.get(pointList.size()-1).getY() ) {

                pointList.add(point);
                tabulatedFunctionComponent.setPointList(pointList);
                size++;
            }
            else{
                model.addAttribute("message", "Wrong values, the list of points should be sorted");
            }
        }else if(!pointList.isEmpty()) model.addAttribute("message", "Your List is full");

        model.addAttribute("tabulatedFunctionComponent", tabulatedFunctionComponent);
        return "createTabulatedFunction";
    }
    @RequestMapping(params = "reset",method = RequestMethod.POST)
    public String valuesReset(@ModelAttribute("tabulatedFunctionComponent") TabulatedFunctionComponent tabulatedFunctionComponent,
                              @ModelAttribute("point") Point point,
                              Model model){
        tabulatedFunctionComponent.setPointList(new ArrayList<>());
        tabulatedFunctionComponent.setAmount(0);
        size = 0;
        model.addAttribute("tabulatedFunctionComponent", tabulatedFunctionComponent);
        return "createTabulatedFunction";
    }
    @RequestMapping(params = "create",method = RequestMethod.POST)
    public String createTabulatedFunction(@ModelAttribute("tabulatedFunctionComponent") TabulatedFunctionComponent tabulatedFunctionComponent,
                                          @ModelAttribute Point point,
                                          Model model){
        List<Point> pointList = tabulatedFunctionComponent.getPointList();
        Integer amountOfPoints = tabulatedFunctionComponent.getAmount();
        if(!pointList.isEmpty()) {
            tabulatedFunctionComponent.createTabulatedFunction();

            System.out.println(tabulatedFunctionComponent.getFunc());

            model.addAttribute("message", "Tabulated function created");
        } else if (amountOfPoints != 0){
            model.addAttribute("tabulatedFunctionComponent", tabulatedFunctionComponent);
            model.addAttribute("notification", "Your list is empty");
        }
        return "main";
    }

}