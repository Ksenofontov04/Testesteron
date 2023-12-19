package ru.ssau.Laba_7.functions.factory;

import ru.ssau.Laba_7.functions.LinkedListTabulatedFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTabulatedFunctionFactoryTest {

    @Test
    void create() {
        double[] xValues = {1,2,3,4,5};
        double[] yValues = {9,18,27,36,45};
        LinkedListTabulatedFunctionFactory listFunctionFactoryTest = new LinkedListTabulatedFunctionFactory();
        assertEquals(LinkedListTabulatedFunction.class,listFunctionFactoryTest.create(xValues,yValues).getClass());
    }
}