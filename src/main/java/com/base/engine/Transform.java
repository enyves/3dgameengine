package com.base.engine;

public class Transform {
    private Vector3f translation;
    
    public Transform() {
        translation = new Vector3f(0, 0, 0);
    }

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
        return translationMatrix;
    }
}
