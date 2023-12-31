package com.project.fp01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.project.fp01.**.mappers"})
@SpringBootApplication
public class Fp01Application {

	public static void main(String[] args) {
		SpringApplication.run(Fp01Application.class, args);
		System.out.println("이주용 비잉신");
		System.out.println("권성준 비잉신");
		System.out.println("git commit Test");
	}

}
