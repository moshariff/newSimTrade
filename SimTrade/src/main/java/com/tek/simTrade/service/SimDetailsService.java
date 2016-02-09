package com.tek.simTrade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.tek.simTrade.models.SimDetails;

@Service
public class SimDetailsService
{
	@Autowired
	private DynamoDBMapper mapper;

	@Autowired
	private AmazonDynamoDBClient amazonDynamoDBClient;
	
	SimDetails sim = new SimDetails();
	private SimDetails getSimDetails = new SimDetails();
	
	public void createSimTradeTable()
	{

		CreateTableRequest createTableRequest = mapper
				.generateCreateTableRequest(SimDetails.class);
		// Table provision throughput is still required since it cannot be
		// specified in your POJO
		createTableRequest
				.setProvisionedThroughput(new ProvisionedThroughput(5L, 5L));
		// Fire off the CreateTableRequest using the low-level client
		amazonDynamoDBClient.createTable(createTableRequest);
	}
	
	public SimDetails displayDetails()
	{
		sim.setUserName("Pratheeth");
		sim.setCountry("US");
		sim.setExpiryDate("01/05/2016");
		sim.setSimType("Prepaid");
		
		mapper.save(sim);
		
		getSimDetails= mapper.load(SimDetails.class, "US", "Prasoon" );
		
		return getSimDetails;
		
		
	}
	
}
