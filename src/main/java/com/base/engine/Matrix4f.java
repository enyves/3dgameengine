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

    public Matrix4f initRotation(Vector3f rotation) {
        
        Matrix4f rotationX = new Matrix4f();
        Matrix4f rotationY = new Matrix4f();
        Matrix4f rotationZ = new Matrix4f();
        
        float x = (float) Math.toRadians(rotation.getX());
        float y = (float) Math.toRadians(rotation.getY());
        float z = (float) Math.toRadians(rotation.getZ());
         
        rotationZ.data[0][0] = (float) Math.cos(z); rotationZ.data[0][1] = -(float) Math.sin(z); rotationZ.data[0][2] = 0; rotationZ.data[0][3] = 0;
        rotationZ.data[1][0] = (float) Math.sin(z); rotationZ.data[1][1] = (float) Math.cos(z); rotationZ.data[1][2] = 0; rotationZ.data[1][3] = 0;
        rotationZ.data[2][0] = 0; rotationZ.data[2][1] = 0; rotationZ.data[2][2] = 1; rotationZ.data[2][3] = 0;
        rotationZ.data[3][0] = 0; rotationZ.data[3][1] = 0; rotationZ.data[3][2] = 0; rotationZ.data[3][3] = 1;
        
        rotationX.data[0][0] = 1; rotationX.data[0][1] = 0; rotationX.data[0][2] = 0; rotationX.data[0][3] = 0;
        rotationX.data[1][0] = 0; rotationX.data[1][1] = (float) Math.cos(x); rotationX.data[1][2] = -(float) Math.sin(x); rotationX.data[1][3] = 0;
        rotationX.data[2][0] = 0; rotationX.data[2][1] = (float) Math.sin(x); rotationX.data[2][2] = (float) Math.cos(x); rotationX.data[2][3] = 0;
        rotationX.data[3][0] = 0; rotationX.data[3][1] = 0; rotationX.data[3][2] = 0; rotationX.data[3][3] = 1;
        
        rotationY.data[0][0] = (float) Math.cos(y); rotationY.data[0][1] = 0; rotationY.data[0][2] = -(float) Math.sin(y); rotationY.data[0][3] = 0;
        rotationY.data[1][0] = 0; rotationY.data[1][1] = 1; rotationY.data[1][2] = 0; rotationY.data[1][3] = 0;
        rotationY.data[2][0] = (float) Math.sin(y); rotationY.data[2][1] = 0; rotationY.data[2][2] = (float) Math.cos(y); rotationY.data[2][3] = 0;
        rotationY.data[3][0] = 0; rotationY.data[3][1] = 0; rotationY.data[3][2] = 0; rotationY.data[3][3] = 1;
        return rotationZ.mul(rotationY.mul(rotationX));
    }

    public Matrix4f initScale(Vector3f scale) {
        data[0][0] = scale.getX(); data[0][1] = 0; data[0][2] = 0; data[0][3] = 0;
        data[1][0] = 0; data[1][1] = scale.getY(); data[1][2] = 0; data[1][3] = 0;
        data[2][0] = 0; data[2][1] = 0; data[2][2] = scale.getZ(); data[2][3] = 0;
        data[3][0] = 0; data[3][1] = 0; data[3][2] = 0; data[3][3] = 1;
        return this;
    }
}
