package com.zemoso.assignment.SpringAssignment;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {

	 String carId;

	    String carName;

	    //Autowired Field
	    @Autowired
	    Brand carBrand;
	    
	/*
	 * 1) Dependency injection using constructor public Car(String carId, String
	 * carName, Brand carBrand) { this.carId = carId; this.carName = carName;
	 * this.carBrand = carBrand; }
	 */

	/*
	 * 2) Autowired setter method
	 * 
	 * public void setCarBrand(Brand carBrand) { this.carBrand = carBrand; }
	 */


	    public Car() {
	    }

	    public String getCarId() {
	        return carId;
	    }

	    public void setCarId(String carId) {
	        this.carId = carId;
	    }

	    public String getCarName() {
	        return carName;
	    }

	    public void setCarName(String carName) {
	        this.carName = carName;
	    }

	    public Brand getCarBrand() {
	        return carBrand;
	    }

	    public void setCarBrand(Brand carBrand) {
	        this.carBrand = carBrand;
	    }

	    @Override
	    public String toString() {
	        return "Car{" +
	                "id=" + carId +
	                ", name='" + carName + '\'' +
	                ", brand=" + carBrand+
	                '}';
	    }
}
