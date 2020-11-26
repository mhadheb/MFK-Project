package com.mfk.models;

public class ModelDim {
	public String model;
	public float width;
	public float length;
	public ModelDim(String model,float width,float length) {
		this.model=model;
		this.width=width;
		this.length=length;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public float getDim() {
		return this.width*this.length;
	}
	@Override
	public String toString() {
		return "ModelDim [model=" + model + ", width=" + width + ", length=" + length + "]";
	}
	
	
	
	
}