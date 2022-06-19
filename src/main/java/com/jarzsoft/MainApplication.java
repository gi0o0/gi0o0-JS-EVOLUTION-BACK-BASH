package com.jarzsoft;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.jarzsoft.dto.DTOProfile;
import com.jarzsoft.exception.ResponseExceptionHandler;
import com.jarzsoft.service.IProfileService;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class MainApplication {

	private final IProfileService profileService;

	private static final Logger LOGGER = LogManager.getLogger(ResponseExceptionHandler.class);

	@Autowired
	public MainApplication(IProfileService profileService) {
		super();
		this.profileService = profileService;

	}

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Scheduled(cron = "${scheduling.job.cron.consulta}")
	public void scheduleTaskUsingCronExpression() {
		LOGGER.info("Inicio cron envio certifactura");
		List<DTOProfile> out = profileService.listAll();
		for(DTOProfile o:out)
		System.out.println(o.getName());
	}
}