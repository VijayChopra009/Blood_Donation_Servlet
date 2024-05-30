
var config = {
	cUrl: 'https://api.countrystatecity.in/v1/countries',
	ckey: 'UGU1UlhRV1VFczJDanFFZ3UyVk05dDNnbDU2Rmd5QVUwVjYxd0N0Nw=='
}


var countrySelect = document.querySelector('.country'),
	stateSelect = document.querySelector('.state'),
	citySelect = document.querySelector('.city')


function loadCountries() {

	let apiEndPoint = config.cUrl

	fetch(apiEndPoint, { headers: { "X-CSCAPI-KEY": config.ckey } })
		.then(Response => Response.json())
		.then(data => {
			//   console.log(data);

			data.forEach(country => {
				const option = document.createElement('option')
				option.value = country.iso2
				option.textContent = country.name
				countrySelect.appendChild(option)


			})
			const indiaOption = countrySelect.querySelector('option[value="IN"]');
			indiaOption.selected = true;
			countrySelect.disabled = true;
			loadStates()

		}).catch(error => console.error('Error loading countries:', error))
}


function loadStates() {
	stateSelect.disabled = false
	citySelect.disabled = true
	stateSelect.style.pointerEvents = 'auto'
	citySelect.style.pointerEvents = 'none'

	const selectedCountryCode = countrySelect.value
	// console.log(selectedCountryCode);
	stateSelect.innerHTML = '<option value="">Select State</option>' // for clearing the existing states
	citySelect.innerHTML = '<option value="">Select City</option>' // Clear existing city options

	fetch(`${config.cUrl}/IN/states`, { headers: { "X-CSCAPI-KEY": config.ckey } })
		.then(response => response.json())
		.then(data => {
			//   console.log(data);

			data.forEach(state => {
				const option = document.createElement('option')
				option.value = state.iso2
				option.textContent = state.name
				stateSelect.appendChild(option)
			})
		})
		.catch(error => console.error('Error loading countries:', error))
}


function loadCities() {
	citySelect.disabled = false
	citySelect.style.pointerEvents = 'auto'

	const selectedCountryCode = countrySelect.value
	const selectedStateCode = stateSelect.value
	// console.log(selectedCountryCode, selectedStateCode);

	citySelect.innerHTML = '<option value="">Select City</option>' // Clear existing city options

	fetch(`${config.cUrl}/${selectedCountryCode}/states/${selectedStateCode}/cities`, { headers: { "X-CSCAPI-KEY": config.ckey } })
		.then(response => response.json())
		.then(data => {
			//   console.log(data);

			data.forEach(city => {
				const option = document.createElement('option')
				option.value = city.name
				option.textContent = city.name
				citySelect.appendChild(option)

			})
		})
}

window.onload = loadCountries()



let submit = document.getElementById("submit");
var form = document.getElementById('form');

form.addEventListener('submit', function(event) {
	event.preventDefault(); // Prevent default form submission
	var country = document.querySelector(".country");
	var stateSelect = document.querySelector('.state');
	var citySelect = document.querySelector('.city');


	var selectcountry = country.value;
	var selectedState = stateSelect.value;
	var selectedCity = citySelect.value;

	console.log("selected country: ", selectcountry)
	console.log('Selected State:', selectedState);
	console.log('Selected City:', selectedCity);

	// You can further process or use the selected state and city here
});
