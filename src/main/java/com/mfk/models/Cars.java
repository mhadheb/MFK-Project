package com.mfk.models;

import java.util.Calendar;
import java.util.Date;

public class Cars {
	
	
	public String manufacturer;
	public String model;
	public float salesInThounsands;
	public float yearResaleValue;
	public String vehicleType;
	public float priceInThousands;
	public float engineSize;
	public float horsepower;
    public float wheelbase;
    public float width;
    public float lenght;
    public float curbWeight;
    public float fuelCapacity;
    public float fuelEfficiency;
    public Date latestLaunch;
    public float powerPerfFactor;
    
    public Cars(String manufacturer, String model, float salesInThounsands, float yearResaleValue, String vehicleType,
			float priceInThousands, float engineSize, float horsepower, float wheelbase, float width, float lenght,
			float curbWeight, float fuelCapacity, float fuelEfficiency, Date latestLaunch, float powerPerfFactor) {
		super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.salesInThounsands = salesInThounsands;
		this.yearResaleValue = yearResaleValue;
		this.vehicleType = vehicleType;
		this.priceInThousands = priceInThousands;
		this.engineSize = engineSize;
		this.horsepower = horsepower;
		this.wheelbase = wheelbase;
		this.width = width;
		this.lenght = lenght;
		this.curbWeight = curbWeight;
		this.fuelCapacity = fuelCapacity;
		this.fuelEfficiency = fuelEfficiency;
		this.latestLaunch = latestLaunch;
		this.powerPerfFactor = powerPerfFactor;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getSalesInThounsands() {
		return salesInThounsands;
	}

	public void setSalesInThounsands(float salesInThounsands) {
		this.salesInThounsands = salesInThounsands;
	}

	public float getYearResaleValue() {
		return yearResaleValue;
	}

	public void setYearResaleValue(float yearResaleValue) {
		this.yearResaleValue = yearResaleValue;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public float getPriceInThousands() {
		return priceInThousands;
	}

	public void setPriceInThousands(float priceInThousands) {
		this.priceInThousands = priceInThousands;
	}

	public float getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(float engineSize) {
		this.engineSize = engineSize;
	}

	public float getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(float horsepower) {
		this.horsepower = horsepower;
	}

	public float getWheelbase() {
		return wheelbase;
	}

	public void setWheelbase(float wheelbase) {
		this.wheelbase = wheelbase;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getLenght() {
		return lenght;
	}

	public void setLenght(float lenght) {
		this.lenght = lenght;
	}

	public float getCurbWeight() {
		return curbWeight;
	}

	public void setCurbWeight(float curbWeight) {
		this.curbWeight = curbWeight;
	}

	public float getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(float fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public float getFuelEfficiency() {
		return fuelEfficiency;
	}

	public void setFuelEfficiency(float fuelEfficiency) {
		this.fuelEfficiency = fuelEfficiency;
	}

	public Date getLatestLaunch() {
		return latestLaunch;
	}

	public void setLatestLaunch(Date latestLaunch) {
		this.latestLaunch = latestLaunch;
	}

	public float getPowerPerfFactor() {
		return powerPerfFactor;
	}

	public void setPowerPerfFactor(float powerPerfFactor) {
		this.powerPerfFactor = powerPerfFactor;
	}
	
	public int getYear() {
			Calendar calendar = Calendar.getInstance();
	       calendar.setTime(this.latestLaunch);
	       return calendar.get(Calendar.YEAR);
	}

	@Override
	public String toString() {
		return "Cars [manufacturer=" + manufacturer + ", model=" + model + ", salesInThounsands=" + salesInThounsands
				+ ", yearResaleValue=" + yearResaleValue + ", vehicleType=" + vehicleType + ", priceInThousands="
				+ priceInThousands + ", engineSize=" + engineSize + ", horsepower=" + horsepower + ", wheelbase="
				+ wheelbase + ", width=" + width + ", lenght=" + lenght + ", curbWeight=" + curbWeight
				+ ", fuelCapacity=" + fuelCapacity + ", fuelEfficiency=" + fuelEfficiency + ", latestLaunch="
				+ latestLaunch + ", powerPerfFactor=" + powerPerfFactor + "]";
	}
    
    
    
    

}
