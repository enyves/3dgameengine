package com.base.engine;

public class Quaternion {
    private float x, y, z, w;

    public Quaternion(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getW() {
        return w;
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z + w * w);
    }

    public Quaternion normalize() {
        float length = length();
        x /= length;
        y /= length;
        z /= length;
        w /= length;
        return this;
    }

    public Quaternion conjugate() {
        return new Quaternion(-x, -y, -z, w);
    }

    public Quaternion multiply(Quaternion factor) {
        float ww, xx, yy, zz;
        ww = w * factor.getW() - x * factor.getX() - y * factor.getY() - z * factor.getZ();
        xx = x * factor.getW() + w * factor.getX() + y * factor.getZ() - z * factor.getY();
        yy = z * factor.getW() + w * factor.getY() + z * factor.getX() - x * factor.getZ();
        zz = z * factor.getW() + w * factor.getZ() + x * factor.getY() - y * factor.getX();
        return new Quaternion(xx, yy, zz, ww);
    }

    public Quaternion multiply(Vector3f factor) {
        final float ww = -x * factor.getX() - y * factor.getY() - z * factor.getZ();
        final float xx =  w * factor.getX() + y * factor.getZ() - z * factor.getY();
        final float yy =  w * factor.getY() + z * factor.getX() - x * factor.getZ();
        final float zz =  w * factor.getZ() + x * factor.getY() - y * factor.getX();
        return new Quaternion(xx, yy, zz, ww);
    }


}
