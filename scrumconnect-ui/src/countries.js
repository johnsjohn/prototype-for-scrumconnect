const fetch = require('node-fetch');
module.exports.getCountries = async () => {
    let countries = []
    let response = await fetch('https://restcountries.eu/rest/v1/region/Europe')
    let result = await response.json()
    result.forEach(country => {
        countries.push({ "country": country['name'] })
    }
    )
    return countries;
}