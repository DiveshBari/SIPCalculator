package Model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Component
@JsonPropertyOrder
public class CalculatedSIP {
	private double InvestedAmnt;
	private double TotalValue;
	private double EstimatedReturns;
	public CalculatedSIP(double investedAmnt, double totalValue, double estimatedReturns) {
		super();
		InvestedAmnt = investedAmnt;
		TotalValue = totalValue;
		EstimatedReturns = estimatedReturns;
	}
	public double getInvestedAmnt() {
		return InvestedAmnt;
	}
	public void setInvestedAmnt(double investedAmnt) {
		InvestedAmnt = investedAmnt;
	}
	public double getTotalValue() {
		return TotalValue;
	}
	public void setTotalValue(double totalValue) {
		TotalValue = totalValue;
	}
	public double getEstimatedReturns() {
		return EstimatedReturns;
	}
	public void setEstimatedReturns(double estimatedReturns) {
		EstimatedReturns = estimatedReturns;
	}
	@Override
	public String toString() {
		return "CalculatedSIP [InvestedAmnt=" + InvestedAmnt + ", TotalValue=" + TotalValue + ", EstimatedReturns="
				+ EstimatedReturns + "]";
	}		
	
}
