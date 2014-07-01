package com.base.engine;

public class Matrix4f {
    public static final int DIMENSION = 4;

    private float[][] data;

    public Matrix4f() {
        data = new float[DIMENSION][DIMENSION];
    }

    public float get(int x, int y) {
        return data[x][y];
    }

    public void set(int x, int y, float value) {
        data[x][y] = value;
    }

    public Matrix4f initIdentity() {
        for (int x = 0; x < data.length; x++) {
            for (int y = 0; y < data[x].length; y++) {
                data[x][y] = x == y ? 1 : 0;
            }
        }
        return this;
    }

    public Matrix4f mul(Matrix4f matrix) {
        Matrix4f result = new Matrix4f();
        for (int x = 0; x < DIMENSION; x++) {
            for (int y = 0; y < DIMENSION; y++) {
                float resXY = 0;
                for (int i = 0; i < DIMENSION; i++) {
                    resXY += data[x][i] * matrix.get(i, y);
                }
                result.set(x, y, resXY);
            }
        }
        return result;
    }
}
