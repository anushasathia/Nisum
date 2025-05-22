document.addEventListener('DOMContentLoaded', () => {
    const countryInput = document.getElementById('countryInput');
    const countryNameDisplay = document.getElementById('countryNameDisplay');
    const temperatureDisplay = document.getElementById('temperature');
    const conditionDisplay = document.getElementById('condition');
    const humidityDisplay = document.getElementById('humidity');
    const windSpeedDisplay = document.getElementById('windSpeed');
    const errorMessageDisplay = document.getElementById('errorMessage');

    const weatherData = {
        "usa": {
            temperature: "25°C",
            condition: "Sunny",
            humidity: "60%",
            windSpeed: "10 km/h"
        },
        "india": {
            temperature: "30°C",
            condition: "Partly Cloudy",
            humidity: "75%",
            windSpeed: "15 km/h"
        },
        "japan": {
            temperature: "20°C",
            condition: "Rainy",
            humidity: "80%",
            windSpeed: "5 km/h"
        },
        "uk": {
            temperature: "15°C",
            condition: "Cloudy",
            humidity: "90%",
            windSpeed: "20 km/h"
        },
        "canada": {
            temperature: "18°C",
            condition: "Cloudy",
            humidity: "70%",
            windSpeed: "12 km/h"
        },
        "australia": {
            temperature: "28°C",
            condition: "Clear Sky",
            humidity: "55%",
            windSpeed: "8 km/h"
        },
        "germany": {
            temperature: "17°C",
            condition: "Overcast",
            humidity: "85%",
            windSpeed: "18 km/h"
        }
    };

    function updateWeatherDetails(country) {
        const lowerCaseCountry = country.toLowerCase();
        const data = weatherData[lowerCaseCountry];

        if (data) {
            countryNameDisplay.textContent = country;
            temperatureDisplay.textContent = data.temperature;
            conditionDisplay.textContent = data.condition;
            humidityDisplay.textContent = data.humidity;
            windSpeedDisplay.textContent = data.windSpeed;
            errorMessageDisplay.textContent = "";
        } else {
            countryNameDisplay.textContent = "N/A";
            temperatureDisplay.textContent = "N/A";
            conditionDisplay.textContent = "N/A";
            humidityDisplay.textContent = "N/A";
            windSpeedDisplay.textContent = "N/A";
            errorMessageDisplay.textContent = `Weather data not found for "${country}". Please try another country from the list (e.g., USA, India, Japan, UK, Canada, Australia, Germany).`;
        }
    }

    countryInput.addEventListener('keydown', (event) => {
        if (event.key === 'Enter') {
            const countryName = countryInput.value.trim();
            if (countryName) {
                updateWeatherDetails(countryName);
            } else {
                errorMessageDisplay.textContent = "Please enter a country name.";
                countryNameDisplay.textContent = "N/A";
                temperatureDisplay.textContent = "N/A";
                conditionDisplay.textContent = "N/A";
                humidityDisplay.textContent = "N/A";
                windSpeedDisplay.textContent = "N/A";
            }
            countryInput.value = '';
        }
    });
});
