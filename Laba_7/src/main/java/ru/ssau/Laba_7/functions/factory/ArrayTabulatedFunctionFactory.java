package ru.ssau.Laba_7.functions.factory;

import ru.ssau.Laba_7.functions.ArrayTabulatedFunction;
import ru.ssau.Laba_7.functions.MathFunction;

import java.io.Serializable;

public class ArrayTabulatedFunctionFactory implements TabulatedFunctionFactory, Serializable {
    public ArrayTabulatedFunction create(double[] xValues,double[] yValues){
        return new ArrayTabulatedFunction(xValues,yValues);
    }

    @Override
    public ArrayTabulatedFunction create(MathFunction func, double xFrom, double xTo, int size) {
        return new ArrayTabulatedFunction(func, xFrom,xTo,size);
    }

}
