package com.base.engine;

public class Transform {
    private Vector3f translation = new Vector3f(0, 0, 0);
    private Vector3f rotation = new Vector3f(0, 0, 0);
    private Vector3f scale = new Vector3f(1, 1, 1);

    public Vector3f getTranslation() {
        return translation;
    }

    public void setTranslation(Vector3f translation) {
        this.translation = translation;
    }
    
    public void setTranslation(float x, float y, float z) {
        this.translation = new Vector3f(x, y, z);
    }
    
    public Matrix4f getTransformation() {
        Matrix4f translationMatrix = new Matrix4f().initTranslation(translation);
        Matrix4f rotationMatrix = new Matrix4f().initRotation(rotation);
        Matrix4f scaleMatrix = new Matrix4f().initScale(scale);
        return translationMatrix.mul(rotationMatrix.mul(scaleMatrix));
    }
    
    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }
    
    public void setScale(Vector3f scale) {
        this.scale = scale;
    }
}
