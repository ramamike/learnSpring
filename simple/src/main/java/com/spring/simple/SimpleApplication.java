package com.spring.simple;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

@SpringBootApplication
@Slf4j
public class SimpleApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SimpleApplication.class, args);

		String BSC_RPC_ENDPOINT="https://data-seed-prebsc-1-s1.binance.org:8545/";

		Web3j web3j = Web3j.build(new HttpService(BSC_RPC_ENDPOINT));

		log.info(web3j.web3ClientVersion().send().getWeb3ClientVersion());
		log.info("end");

	}

}
