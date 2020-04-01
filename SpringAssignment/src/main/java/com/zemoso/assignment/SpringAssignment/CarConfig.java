package com.zemoso.assignment.SpringAssignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {

	/**
	 *
	 * @return
	 */
	@Bean
	public Brand brand() {
		return new Brand("B1","Audi");
		
	}


	/**
	 * Car id and name are set,
	 * brand object is not passed to the car object
	 * brand bean is autowired
	 * @return
	 */
	@Bean
	public Car car() {
		
		Car theCar = new Car();
		
		theCar.setCarId("C101");
		theCar.setCarName("R8");
		
		return theCar;
		
	}
}
