package com.product.cron;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SFTPProcessHandler {

	@Async
	public void processSFTP() {
		System.out.println("It is async job");
	}
	
}
