package com.efteling.eft;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EftApplication {



		private static Logger LOG = (Logger) LoggerFactory
				.getLogger(EftApplication.class);

		public static void main(String[] args) {
			SpringApplication.run(EftApplication.class, args);
		}





}
