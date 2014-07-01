package com.base.engine;

public class Vector2f {
    private float x, y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public float dot(Vector2f point) {
        return x * point.getX() + y * point.getY();
    }

    public Vector2f normalize() {
        float length = length();
        x /= length;
        y /= length;
        return this;
    }

    public Vector2f rotate(float angle) {
        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);
        return new Vector2f((float) (x * cos - y * sin) , (float) (x * sin + y * cos));
    }

    public Vector2f add(Vector2f vector) {
        return new Vector2f(x + vector.getX(), y + vector.getY());
    }

    public Vector2f add(float amount) {
        return new Vector2f(x + amount, y + amount);
    }

    public Vector2f subtract(Vector2f vector) {
        return new Vector2f(x - vector.getX(), y - vector.getY());
    }

    public Vector2f subtract(float amount) {
        return new Vector2f(x - amount, y - amount);
    }

    public Vector2f multiply(Vector2f vector) {
        return new Vector2f(x * vector.getX(), y * vector.getY());
    }

    public Vector2f multiply(float amount) {
        return new Vector2f(x * amount, y * amount);
    }

    public Vector2f divide(Vector2f vector) {
        return new Vector2f(x / vector.getX(), y / vector.getY());
    }

    public Vector2f divide(float amount) {
        return new Vector2f(x / amount, y / amount);
    }

    @Override
    public String toString() {
        return "Vector2f{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
