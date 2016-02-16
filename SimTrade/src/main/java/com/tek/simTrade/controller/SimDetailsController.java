package com.tek.simTrade.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.tek.simTrade.models.SimDetails;
import com.tek.simTrade.models.User;
import com.tek.simTrade.service.SimDetailsService;

@RestController
@RequestMapping(value = "/sim-details/")
public class SimDetailsController {
	@Autowired
	private SimDetailsService simDetailsService;
	@Autowired
	private DynamoDBMapper mapper;

	SimDetails getSimDetails = new SimDetails();

	@RequestMapping(value = "/create-sim-trade", method = RequestMethod.GET)
	@ResponseBody
	String createSimTrade() {
		simDetailsService.createSimTradeTable(); // have to remove this
		return "true";
	}

	@RequestMapping(value = "/sim-form", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView personPage() {
		ModelAndView mav = new ModelAndView("enter-details");

		Map<String, String> countries = new HashMap<String, String>();
		countries.put("US", "US");
		countries.put("India", "INDIA");
		countries.put("Canada", "CANADA");

		mav.addObject("countriesMap", countries);
		mav.addObject("sim-entity", new SimDetails());

		return mav;

	}

	@RequestMapping(value = "/display-sim-details", method = RequestMethod.POST)
	public String processPerson(@ModelAttribute SimDetails simfulldetails) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display-details");

		modelAndView.addObject("sim", simfulldetails);
		mapper.save(simfulldetails);

		return "Sim Form Succesfully Saved";
	}

	@RequestMapping(value = "/book-a-sim", method = RequestMethod.GET)
	@ResponseBody

	public ModelAndView UserPerson() {

	
	  
		return new ModelAndView("SimBook", "user-entity", new User());

	}

	@RequestMapping(value = "/user-country", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView countryUser(@ModelAttribute User userDetails) {

		ModelAndView mav = new ModelAndView("countrydropdown");

		Map<String, String> countries = new HashMap<String, String>();
		countries.put("US", "US");
		countries.put("India", "INDIA");
		countries.put("Canada", "CANADA");
		mav.addObject("countriesMap", countries);
		mav.addObject("simdetails-entity", new SimDetails());
		mapper.save(userDetails);
	    
		return mav;

	}

	@RequestMapping(value = "/display-table", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView hello(@ModelAttribute SimDetails simfulldetails) {
		List<SimDetails> lsim = simDetailsService.displayDetails(simfulldetails.getCountry());
		ArrayList<Map<String, String>> lofmap = new ArrayList<>();
		for (int i = 0; i < lsim.size(); i++) {
			Map<String, String> str = new HashMap<>();
			str.put("userName", lsim.get(i).getUserName());
			str.put("country", lsim.get(i).getCountry());
			str.put("expiryDate", lsim.get(i).getExpiryDate());
			str.put("simType", lsim.get(i).getSimType());
			str.put("phoneNumber", lsim.get(i).getPhoneNumber());
			str.put("plan", lsim.get(i).getPlan());
			str.put("currentStatus", lsim.get(i).getCurrentStatus());
			str.put("ownerId", lsim.get(i).getOwnerId());
			str.put("expectedDateChange", lsim.get(i).getExpectedDateChange());
			str.put("rechargeDetails", lsim.get(i).getRechargeDetails());
			str.put("currentUser", lsim.get(i).getCurrentUser());
			str.put("timestamp", lsim.get(i).getTimestamp());
			lofmap.add(str);
		}
		return new ModelAndView("hello", "simDetails", lofmap);
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView homes()
	{
		return new ModelAndView("Home");
	}

	 @RequestMapping(value = "/result", method = RequestMethod.POST)
	    public Object env(HttpServletRequest request){

		 String s3=request.getParameter("env");
		
		 SimDetails use=mapper.load(SimDetails.class,"US",s3);
		 use.setCurrentStatus("passive");
		 mapper.save(use);
	        return s3;

	    }
}
