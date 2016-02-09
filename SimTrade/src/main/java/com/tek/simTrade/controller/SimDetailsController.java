package com.tek.simTrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tek.simTrade.models.SimDetails;
import com.tek.simTrade.service.SimDetailsService;

@RestController
@RequestMapping(value="/sim-details/")
public class SimDetailsController
{
	@Autowired
	private SimDetailsService simDetailsService;
	
	SimDetails getSimDetails = new SimDetails();
	
	@RequestMapping(value = "/create-sim-trade", method = RequestMethod.GET)
	@ResponseBody
	String createSimTrade()
	{
		simDetailsService.createSimTradeTable();
		return "true";
	}
	
	@RequestMapping(value = "/display-sim-trade", method = RequestMethod.GET)
	@ResponseBody
	Object displaySimDetails()
	{
		return simDetailsService.displayDetails();
	}
	
	@RequestMapping(value = "/display-table", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView hello() {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("hello");
	return mav;
	}

	
}
