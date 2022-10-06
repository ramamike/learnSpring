package com.learn.postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;


@SpringBootApplication
public class PostgresqlApplication {

	private static AddressService addressService;

	public PostgresqlApplication(AddressService addressService) {
		this.addressService = addressService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PostgresqlApplication.class, args);
		System.out.println("hi");

		addressService.createAddress(new AddressEntity(1l, new BigInteger("123456789")));

	}

}
