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
    
    public Matrix4f initTranslation(float x, float y, float z)
    {
        data[0][0] = 1; data[0][1] = 0; data[0][2] = 0; data[0][3] = x;
        data[1][0] = 0; data[1][1] = 1; data[1][2] = 0; data[1][3] = y;
        data[2][0] = 0; data[2][1] = 0; data[2][2] = 1; data[2][3] = z;
        data[3][0] = 0; data[3][1] = 0; data[3][2] = 0; data[3][3] = 1;
        return this;
    }
    
    public Matrix4f initTranslation(Vector3f vector)
    {
        return initTranslation(vector.getX(), vector.getY(), vector.getZ());
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
