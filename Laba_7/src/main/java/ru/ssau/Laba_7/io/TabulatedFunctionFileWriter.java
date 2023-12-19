package ru.ssau.Laba_7.io;


import ru.ssau.Laba_7.functions.ArrayTabulatedFunction;
import ru.ssau.Laba_7.functions.LinkedListTabulatedFunction;
import ru.ssau.Laba_7.functions.TabulatedFunction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

    public class TabulatedFunctionFileWriter {
        public static void main(String[] args) {
            try {
                try (BufferedWriter writerArray = new BufferedWriter(new FileWriter("output/array function.txt"));
                     BufferedWriter writerLinked = new BufferedWriter(new FileWriter("output/linked list function.txt"))) {

                    double[] xValue = {1, 2, 3, 4, 5};
                    double[] yValue = {1, 4, 8, 16, 32};
                    TabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xValue, yValue);
                    TabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(xValue,yValue);

                    FunctionsIO.writeTabulatedFunction(writerArray,arrayTabulatedFunction);
                    FunctionsIO.writeTabulatedFunction(writerLinked,linkedListTabulatedFunction);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
