package com.base.engine;


public class Vector3f {
    private float x, y, z;

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public float dot(Vector3f point) {
        return x * point.getX() + y * point.getY() + z * point.getZ();
    }

    public Vector3f normalize() {
        float length = length();
        x /= length;
        y /= length;
        y /= length;
        return this;
    }

    public Vector3f add(Vector3f vector) {
        return new Vector3f(x + vector.getX(), y + vector.getY(), z + vector.getZ());
    }

    public Vector3f add(float amount) {
        return new Vector3f(x + amount, y + amount, z + amount);
    }

    public Vector3f subtract(Vector3f vector) {
        return new Vector3f(x - vector.getX(), y - vector.getY(), z - vector.getZ());
    }

    public Vector3f subtract(float amount) {
        return new Vector3f(x - amount, y - amount, z - amount);
    }

    public Vector3f multiply(Vector3f vector) {
        return new Vector3f(x * vector.getX(), y * vector.getY(), z * vector.getZ());
    }

    public Vector3f multiply(float amount) {
        return new Vector3f(x * amount, y * amount, z * amount);
    }

    public Vector3f divide(Vector3f vector) {
        return new Vector3f(x / vector.getX(), y / vector.getY(), z / vector.getZ());
    }

    public Vector3f divide(float amount) {
        return new Vector3f(x / amount, y / amount, z / amount);
    }

    public Vector3f cross(Vector3f vector) {
        float xx = y  * vector.getZ() - z * vector.getY();
        float yy = z * vector.getX() - x * vector.getZ();
        float zz = x * vector.getY() - y * vector.getX();
        return new Vector3f(xx, yy, zz);
    }

    public Vector3f rotate() {
        return null;
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

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
