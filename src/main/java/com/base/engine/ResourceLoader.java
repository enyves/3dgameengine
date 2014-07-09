package com.base.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResourceLoader {
    public static String loadShader(String fileName) {
        StringBuilder shaderSource = new StringBuilder();
        try (BufferedReader shaderReader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("shaders/" + fileName))))
        {
            String line;
            while ((line = shaderReader.readLine()) != null) {
                shaderSource.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return shaderSource.toString();
    }
}
