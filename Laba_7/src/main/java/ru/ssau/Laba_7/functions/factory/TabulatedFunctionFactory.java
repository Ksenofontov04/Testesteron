package ru.ssau.Laba_7.functions.factory;

import ru.ssau.Laba_7.functions.MathFunction;
import ru.ssau.Laba_7.functions.TabulatedFunction;

public interface TabulatedFunctionFactory  {
    TabulatedFunction create(double[] xValues, double[] yValues);
    TabulatedFunction create(MathFunction func, double xFrom, double xTo, int size);
}
