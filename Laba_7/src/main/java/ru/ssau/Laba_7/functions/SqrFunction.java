package ru.ssau.Laba_7.functions;

import static java.lang.Math.pow;

public class SqrFunction implements MathFunction {
    double x;
    public double apply(double x) {return pow(x, 2);}   //Возводим в квадрат
}
