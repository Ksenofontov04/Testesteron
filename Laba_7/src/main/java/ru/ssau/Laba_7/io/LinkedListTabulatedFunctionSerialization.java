package ru.ssau.Laba_7.io;

import ru.ssau.Laba_7.functions.TabulatedFunction;

import java.io.*;

public class LinkedListTabulatedFunctionSerialization {
    public static void serialize(String dir, TabulatedFunction func) {
        try{
            try(BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(dir))){
                FunctionsIO.serialize(fileOutputStream, func);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static TabulatedFunction deserialize(String dir) {
        TabulatedFunction func = null;
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(dir))) {
            func = FunctionsIO.deserialize(input);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return func;
    }
}
