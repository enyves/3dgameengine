package com.base.engine;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.*;

import java.util.HashMap;


public class Shader {
    private int program;
    private HashMap<String, Integer> uniforms = new HashMap<>();
    
    public Shader() {
        program = glCreateProgram();
        if (program == 0) {
            throw new RuntimeException("SHader creation failed: Could not find memory location in constructor.");
        }
    }
    
    public void addVertexShader(String text) {
        addProgram(text, GL_VERTEX_SHADER);
    }
    
    public void addGeometryShader(String text) {
        addProgram(text, GL_GEOMETRY_SHADER);
    }
    
    public void addFragmentShader(String text) {
        addProgram(text, GL_FRAGMENT_SHADER);
    }
    
    private void addProgram(String text, int type) {
        int shader = glCreateShader(type);
        if (shader == 0) {
            throw new RuntimeException("Shader creation failed: Could not find valid memory location when adding shader");
        }
        
        glShaderSource(shader, text);
        glCompileShader(shader);
        
        if (glGetShader(shader, GL_COMPILE_STATUS) == 0) {
            throw new RuntimeException("Shader error: " + glGetShaderInfoLog(shader, 1024) + " in: \n" + text);
        }
        
        glAttachShader(program, shader);
    }
    
    public void compileShader() {
        glLinkProgram(program);
        if (glGetProgram(program, GL_LINK_STATUS) == 0) {
            throw new RuntimeException(glGetProgramInfoLog(program, 1024));
        }
        glValidateProgram(program);
        if (glGetProgram(program, GL_VALIDATE_STATUS) == 0) {
            throw new RuntimeException(glGetProgramInfoLog(program, 1024));
        }
    }
    
    public void bind() {
        glUseProgram(program);
    }
    
    public void addUniform(String name) {
        int uniformLocation = glGetUniformLocation(program, name);
        if (uniformLocation == 0xFFFFFFFF) 
        {
            throw new RuntimeException("Could not find uniform: " + name);
        }
        uniforms.put(name, uniformLocation);
    }
    
    public void setUniform(String name, int value)
    {
        glUniform1i(uniforms.get(name), value);
    }
    
    public void setUniform(String name, float value)
    {
        glUniform1f(uniforms.get(name), value);
    }
    
    public void setUniform(String name, Vector3f value)
    {
        glUniform3f(uniforms.get(name), value.getX(), value.getY(), value.getZ());
    }
    
    public void setUniform(String name, Matrix4f value)
    {
        glUniformMatrix4(uniforms.get(name), true, Util.createFlippedFloatBuffer(value));
    }
} 
