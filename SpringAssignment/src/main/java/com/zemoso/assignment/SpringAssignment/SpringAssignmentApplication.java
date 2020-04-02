package com.zemoso.assignment.SpringAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAssignmentApplication.class, args);
		
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(CarConfig.class);

		Brand theBrand= context.getBean("brand",Brand.class);
		theBrand.setId("B1");
		theBrand.setName("Audi");
		
		Car theCar= context.getBean("car",Car.class);
		
		theCar.setCarId("C101");
		theCar.setCarName("R8");

		System.out.println(theCar);

		context.close();
	}

}
