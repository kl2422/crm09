package com.shsxt.crm.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.shsxt.crm.service.CustomerLossService;

@Component
public class CustomerLossJob {
	
	@Autowired
	private CustomerLossService customerLossService;
	
	@Scheduled(cron="0 5 15 * * ?")
	public void runLossCustomer() {
		customerLossService.runLossCustomer();
	}

}
