/**
 * 
 */
package com.div.SIPCalculator.Controller;

import org.springframework.web.servlet.ModelAndView;

import Model.CalculatedSIP;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * SIPController
 * This class is a controller which serves the requests
 */
@RestController
public class SIPController {

	/**
	 * method - SIPCalculator
     * Handles HTTP GET requests for the SIP Calculator page.
     * @return ModelAndView object containing the view "sipcalculator.jsp".
     */
	@GetMapping("/SIPCalculator")
	public ModelAndView SIPCalculator() {
		System.out.println("In SIPCalculator");
		return new ModelAndView("sipcalculator");
	}
	
	@GetMapping(value = "/CalculateSIP", produces = {"application/json"})
	public CalculatedSIP CalculateSIP(@RequestParam double monthlyInvestment,
			@RequestParam double returnRate,
			@RequestParam double timePeriod) {
		
		System.out.println("In CalculateSIP monthlyInvestment - "+monthlyInvestment + ", returnRate - "+returnRate+ ", timePeriod - "+timePeriod);
		
		// Lets calculate the things
		double InvestedAmnt = timePeriod*12*monthlyInvestment;
		double monthlyRate = returnRate / (12 * 100); // Convert annual rate to monthly
	    
	    /* SIP Future Value Formula:
	     * FV = P × [((1 + r)^n - 1) / r] × (1 + r)
	     * Where:
	     * P = Monthly Investment Amount
	     * r = Monthly Interest Rate (Annual Rate ÷ 12 ÷ 100)
	     * n = Total Number of Months
	     */
	    
		double months = timePeriod * 12; // Convert years to months
	    int TotalValue = (int) (monthlyInvestment * ((Math.pow(1 + monthlyRate, months) - 1) / monthlyRate) * (1 + monthlyRate));
		
	    double EstimatedReturns = TotalValue - InvestedAmnt;
		
		CalculatedSIP cs = new CalculatedSIP(InvestedAmnt, TotalValue, EstimatedReturns);
		System.out.println("calculated SIP - "+cs.toString());
		return cs;
	}
}
