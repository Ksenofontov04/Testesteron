package ru.ssau.Laba_7.components;


import ru.ssau.Laba_7.functions.MathFunction;
import ru.ssau.Laba_7.functions.TabulatedFunction;
import ru.ssau.Laba_7.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.Laba_7.functions.factory.TabulatedFunctionFactory;
import ru.ssau.Laba_7.serializable.SerializeComponents;

import java.util.HashMap;
import java.util.Map;

public class MathFunctionComponent implements Components {
    private String function;


    private TabulatedFunction func;
    public Map<String,MathFunction> map = new HashMap<>();
    private Integer xFrom;
    private Integer xTo;
    private Integer size;
    public void createTabulatedFunction(){
        TabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
        try{
            SettingsComponent comp = SerializeComponents.deserialize("savedFunctions/settings/settings.bin");
            factory = comp.getFactory();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        this.func = factory.create(map.get(function),
                xFrom,
                xTo,
                size);

    }
    public TabulatedFunction getFunc() {
        return func;
    }

    public void setFunc(TabulatedFunction func) {
        this.func = func;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Integer getxFrom() {
        return xFrom;
    }

    public void setxFrom(Integer xFrom) {
        this.xFrom = xFrom;
    }

    public Integer getxTo() {
        return xTo;
    }

    public void setxTo(Integer xTo) {
        this.xTo = xTo;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
