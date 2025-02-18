// Function to sync range input with text input
function syncInputs(rangeId, textId) {
    const range = document.getElementById(rangeId);
    const text = document.getElementById(textId);
    const track = range.nextElementSibling;

    range.addEventListener('input', function() {
        text.value = this.value;
        // Update range track width
        const percent = ((this.value - this.min) / (this.max - this.min)) * 100;
        track.style.width = percent + '%';
    });

    text.addEventListener('input', function() {
        range.value = this.value;
        // Update range track width
        const percent = ((range.value - range.min) / (range.max - range.min)) * 100;
        track.style.width = percent + '%';
    });
}

// Function to calculate SIP
async function calculateSIP(){
	alert("lets calculate");
	// use the CalculateSIP API to do the calculation
	const monthlyInvestment = document.getElementById("monthlyInvestment").value;
	const returnRate = document.getElementById("returnRate").value;
	const timePeriod = document.getElementById("timePeriod").value;
	console.log("monthlyInvestment ", monthlyInvestment);
	console.log("returnRate ", returnRate);
	console.log("timePeriod ", timePeriod);
	
	try{
		// Hit the API and get the response
		const response = await fetch(`/CalculateSIP?monthlyInvestment=${monthlyInvestment}&returnRate=${returnRate}&timePeriod=${timePeriod}`);
		if (!response.ok){
			let errorMes = response.status;
			throw new error(errorMes);
		}
		
		// Handle the OK response
		const result = await response.json();
		console.log("SIP result - ", result);
		
		document.getElementById("investedAmount").innerText = result.investedAmnt.toLocaleString()+" ₹";
		document.getElementById("estimatedReturs").innerText = result.estimatedReturns.toLocaleString()+" ₹";
		document.getElementById("totalValue").innerText = result.totalValue.toLocaleString()+" ₹";
	}
	catch(error){
		console.error(error);
		alert("error ocured - "+error);
	}
	// From the response get the adequate fields and set it to the jsp
}

// Initialize all input syncs
syncInputs('monthlyInvestmentRange', 'monthlyInvestment');
syncInputs('returnRateRange', 'returnRate');
syncInputs('timePeriodRange', 'timePeriod');

// Add click event listener to the calculate button
document.querySelector('.invest-btn').addEventListener('click', calculateSIP);
