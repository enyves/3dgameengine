package com.base.engine;

import org.lwjgl.input.Keyboard;

public class Game {
    private Mesh mesh = new Mesh();


    public Game() {
        Vertex[] vertices = new Vertex[] {new Vertex(new Vector3f(-1, -1, 0)),
                                      new Vertex(new Vector3f(-1, 1, 0)),
                                      new Vertex(new Vector3f(0, 1, 0))};
        mesh.addVertices(vertices);
    }

    public void input() {
        if (Input.getKeyDown(Input.KEY_UP)) {
            System.out.println("We've just pressed up!");
        }
        if (Input.getKeyUp(Input.KEY_UP)) {
            System.out.println("We've just released up!");
        }

        if (Input.getMouseDown(1)) {
            System.out.println("We've just right clicked at " + Input.getMousePosition());
        }
        if (Input.getMouseUp(1)) {
            System.out.println("We've just released right mouse button!");
        }
    }

    public void update() {}

    public void render() {
        mesh.draw();
    }
}