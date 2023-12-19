package ru.ssau.Laba_7.operations;

import ru.ssau.Laba_7.functions.MathFunction;

public interface DifferentialOperator<T> extends MathFunction {
    T derive( T function);

}
