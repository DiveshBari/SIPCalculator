package Model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Component
@JsonPropertyOrder
public class CalculatedSIP {
	private int InvestedAmnt;
	private int TotalValue;
	private double EstimatedReturns;
	public CalculatedSIP(int investedAmnt, int totalValue, double estimatedReturns) {
		super();
		InvestedAmnt = investedAmnt;
		TotalValue = totalValue;
		EstimatedReturns = estimatedReturns;
	}
	public int getInvestedAmnt() {
		return InvestedAmnt;
	}
	public void setInvestedAmnt(int investedAmnt) {
		InvestedAmnt = investedAmnt;
	}
	public int getTotalValue() {
		return TotalValue;
	}
	public void setTotalValue(int totalValue) {
		TotalValue = totalValue;
	}
	public double getEstimatedReturns() {
		return EstimatedReturns;
	}
	public void setEstimatedReturns(double estimatedReturns) {
		EstimatedReturns = estimatedReturns;
	}		
	
}
