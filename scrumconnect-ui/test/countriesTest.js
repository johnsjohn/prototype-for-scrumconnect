const countriesAPI = require('../src/countries.js')
const expect    = require("chai").expect;

describe("Countries API", function() {
    it("fetches a list of countries", async function() {
        let countries = await countriesAPI.getCountries();
        expect(Object.keys(countries).length).to.equal(53)
    })
})