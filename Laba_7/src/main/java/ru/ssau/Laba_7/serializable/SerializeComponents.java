package ru.ssau.Laba_7.serializable;

import ru.ssau.Laba_7.components.Components;
import ru.ssau.Laba_7.components.SettingsComponent;

import java.io.*;

public class SerializeComponents {
    public static void serialize(String dir, Components components) {
        try{
            try(BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(dir))){
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(components);
                objectOutputStream.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static SettingsComponent deserialize(String dir) {
        SettingsComponent component = null;
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(dir))) {
            ObjectInputStream objectInputStream = new ObjectInputStream(input);
            component = (SettingsComponent) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return component;
    }
}
