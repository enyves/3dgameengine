package com.base.engine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

public class Mesh {

    private int vertexBufferObject;
    private int size;
    private int indexBufferObject;

    public Mesh() {
        vertexBufferObject = glGenBuffers();
        indexBufferObject = glGenBuffers();
        size = 0;
    }

    public void addVertices(Vertex[] vertices, int[] indices) {
        size = indices.length;
        glBindBuffer(GL_ARRAY_BUFFER, vertexBufferObject);
        glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexBufferObject);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Util.createFlippedBuffer(indices), GL_STATIC_DRAW);
    }

    public void draw() {
        glEnableVertexAttribArray(0);
        
        glBindBuffer(GL_ARRAY_BUFFER, vertexBufferObject);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);
        
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexBufferObject);
        glDrawElements(GL_TRIANGLES, size, GL_UNSIGNED_INT, 0);
        
        glDisableVertexAttribArray(0);
    }

}
