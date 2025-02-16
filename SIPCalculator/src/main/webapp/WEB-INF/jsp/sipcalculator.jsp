<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIP Calculator</title>
    <link rel="stylesheet" href="/css/SIPCalcStyles.css">
</head>
<body>
    <div class="calculator-container">
        <h1>SIP Calculator</h1>
        
        <div class="toggle-container">
            <button class="toggle-btn active">SIP</button>
            <!-- <button class="toggle-btn">Lumpsum</button> -->
        </div>

        <div class="input-group">
            <label>Monthly investment</label>
            <div class="input-wrapper">
                <span class="currency-symbol">₹</span>
                <input type="text" value="25000" id="monthlyInvestment">
            </div>
            <input type="range" min="500" max="100000" value="25000" class="range-slider" id="monthlyInvestmentRange">
            <div class="range-track" style="width: 25%;"></div>
        </div>

        <div class="input-group">
            <label>Expected return rate (p.a)</label>
            <div class="input-wrapper">
                <input type="text" value="12" id="returnRate">
                <span class="percentage-symbol">%</span>
            </div>
            <input type="range" min="1" max="30" value="12" class="range-slider" id="returnRateRange">
            <div class="range-track" style="width: 40%;"></div>
        </div>

        <div class="input-group">
            <label>Time period</label>
            <div class="input-wrapper">
                <input type="text" value="10" id="timePeriod">
                <span class="percentage-symbol">Yr</span>
            </div>
            <input type="range" min="1" max="30" value="10" class="range-slider" id="timePeriodRange">
            <div class="range-track" style="width: 33%;"></div>
        </div>

        <div class="chart"></div>

        <div class="results">
            <div class="result-row">
                <span class="result-label">Invested amount</span>
                <span id="investedAmount" class="result-value">₹0</span>
            </div>
            <div class="result-row">
                <span class="result-label">Est. returns</span>
                <span id="estimatedReturs" class="result-value">₹0</span>
            </div>
            <div class="result-row">
                <span class="result-label">Total value</span>
                <span id="totalValue" class="result-value">₹0</span>
            </div>
        </div>

        <button class="invest-btn">CALCULATE</button>
    </div>
	<script src="/js/SIPCalcScript.js"></script>
</body>
</body>
</html>