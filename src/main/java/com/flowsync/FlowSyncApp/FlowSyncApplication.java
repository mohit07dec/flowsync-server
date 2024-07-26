package com.flowsync.FlowSyncApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.flowsync.FlowSyncApp")
public class FlowSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowSyncApplication.class, args);
	}

}
