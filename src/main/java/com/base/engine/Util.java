package com.base.engine;

import static org.lwjgl.BufferUtils.*;

import java.nio.FloatBuffer;

public class Util {

    public static FloatBuffer createFlippedBuffer(Vertex[] vertices) {
        FloatBuffer buffer = createFloatBuffer(vertices.length * Vertex.SIZE);
        for (int i = 0; i < vertices.length; i++) {
            buffer.put(vertices[i].getPosition().getX());
            buffer.put(vertices[i].getPosition().getY());
            buffer.put(vertices[i].getPosition().getZ());
        }
        buffer.flip();
        return buffer;
    }
    
    public static FloatBuffer createFlippedFloatBuffer(Matrix4f matrix) {
        FloatBuffer buffer = createFloatBuffer(Matrix4f.DIMENSION * Matrix4f.DIMENSION);
        for (int i = 0; i < Matrix4f.DIMENSION; i++) {
            for (int j = 0; j < Matrix4f.DIMENSION; j++) {
                buffer.put(matrix.get(i, j));
            }
        }
        
        buffer.flip();
        return buffer;
    }
}
