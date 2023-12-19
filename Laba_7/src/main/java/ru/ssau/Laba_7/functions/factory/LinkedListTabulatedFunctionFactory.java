package ru.ssau.Laba_7.functions.factory;

import ru.ssau.Laba_7.functions.LinkedListTabulatedFunction;
import ru.ssau.Laba_7.functions.MathFunction;

import java.io.Serializable;

public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory, Serializable {
    public LinkedListTabulatedFunction create(double[] xValues, double[] yValues){
        return new LinkedListTabulatedFunction(xValues, yValues);
    }

    @Override
    public LinkedListTabulatedFunction create(MathFunction func, double xFrom, double xTo, int size) {
        return new LinkedListTabulatedFunction(func, xFrom,xTo,size);
    }
}
