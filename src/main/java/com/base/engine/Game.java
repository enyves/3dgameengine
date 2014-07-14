package com.base.engine;

public class Game {
    private Mesh mesh = new Mesh();
    private Shader shader = new Shader();
    float temp = 0.0f;
    private Transform transform = new Transform();

    public Game() {
        Vertex[] vertices = new Vertex[] {
                new Vertex(new Vector3f(-1, -1, 0)),
                new Vertex(new Vector3f(0, 1, 0)),
                new Vertex(new Vector3f(1, -1, 0))
            };
        mesh.addVertices(vertices);
        
        shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
        shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));
        shader.compileShader();
        shader.addUniform("transform");
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

    public void update() {
        temp += Time.getDelta();
        float sinTemp = (float) Math.sin(temp);
        
        transform.setRotation(new Vector3f(0, 0, sinTemp * 180));
        transform.setTranslation(sinTemp, 0, 0);
        transform.setScale(new Vector3f(sinTemp, sinTemp, sinTemp));
    }

    public void render() {
        shader.bind();
        shader.setUniform("transform", transform.getTransformation());
        mesh.draw();
    }
}