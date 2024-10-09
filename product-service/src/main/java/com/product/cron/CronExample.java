package com.product.cron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronExample {
	
	@Autowired
	private SFTPProcessHandler sftpProcessHandler;

	//@Bean
	private String getCronConfigValue() {
		return "0 */1 * * * ?";
	}
	
	
	//@Scheduled(cron = "#{@getCronConfigValue}")
	public void readFiles() {
		System.out.println("Corn job running....");
		
		sftpProcessHandler.processSFTP();
		
		//Connect with File system/db
		
	}
}
