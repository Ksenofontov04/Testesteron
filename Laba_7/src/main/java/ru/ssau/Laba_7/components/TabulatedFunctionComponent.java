package ru.ssau.Laba_7.components;

import ru.ssau.Laba_7.functions.Point;
import ru.ssau.Laba_7.functions.TabulatedFunction;
import ru.ssau.Laba_7.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.Laba_7.functions.factory.TabulatedFunctionFactory;
import ru.ssau.Laba_7.operations.TabulatedFunctionOperationService;
import ru.ssau.Laba_7.serializable.SerializeComponents;

import java.util.ArrayList;
import java.util.List;

public class TabulatedFunctionComponent implements Components {
    private Integer amount = 0;
    private TabulatedFunction func;
    private List<Point> pointList = new ArrayList<>();




    public TabulatedFunction getFunc() {
        return func;
    }

    public void setFunc(TabulatedFunction func) {
        this.func = func;
    }

    public void createTabulatedFunction(){
        TabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
        try{
            SettingsComponent comp = SerializeComponents.deserialize("savedFunctions/settings/settings.bin");
            factory = comp.getFactory();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        double[][] values = TabulatedFunctionOperationService.listOfPointsAsMassive(pointList);
        this.func = factory.create(values[0],values[1]);

    }
    public List<Point> getPointList() {
        return pointList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;


    }
}
