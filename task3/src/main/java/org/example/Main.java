package org.example;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2){
            throw new IllegalArgumentException("Must be 2 path file arguments");
        }
        File tests = new File(args[0]);
        File values = new File(args[1]);

        Gson gson = new Gson();
        TestsPOJO testsPOJO = gson.fromJson(readFile(tests), TestsPOJO.class);
        ValuesPOJO valuesPOJO = gson.fromJson(readFile(values), ValuesPOJO.class);

        valuesPOJO.getValues().forEach(testsPOJO::findAndSet);

        File output = new File("./report.json");
        try {
            output.createNewFile();
            FileWriter fileWriter = new FileWriter(output);
            fileWriter.write(gson.toJson(testsPOJO));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String readFile(File file){
        String str = "";
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            str = new String(fileInputStream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }
}