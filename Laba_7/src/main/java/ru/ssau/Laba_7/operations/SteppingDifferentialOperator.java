package ru.ssau.Laba_7.operations;

import ru.ssau.Laba_7.functions.MathFunction;

abstract public class SteppingDifferentialOperator implements DifferentialOperator<MathFunction> {
    protected double step;

    public SteppingDifferentialOperator(double step) {
        if (Double.isNaN(step) || Double.isInfinite(step) || step <= 0)
            throw new IllegalArgumentException("Step must be a positive finite number.");

        this.step = step;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        if (Double.isNaN(step) || Double.isInfinite(step) || step <= 0)
            throw new IllegalArgumentException("Step must be a positive finite number.");

        this.step = step;
    }
}
