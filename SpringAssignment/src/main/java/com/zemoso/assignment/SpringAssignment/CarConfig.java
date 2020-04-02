package com.zemoso.assignment.SpringAssignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.zemoso.assignment.SpringAssignment")
public class CarConfig {

	
	// no need to create beans manually, @Component.
	
	/**
	 *
	 * @return
//	 */
//	@Bean
//	public Brand brand() {
//		return new Brand();
//		
//	}
//
//
//	/**
//	 * Car id and name are set,
//	 * brand object is not passed to the car object
//	 * brand bean is autowired
//	 * @return
//	 */
//	@Bean
//	public Car car() {
//		
//		Car theCar = new Car();
//		return theCar;
//		
//	}
}
