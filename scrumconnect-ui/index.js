const nunjucks = require('nunjucks') 
const userDataJS = require('./public/js/userData')
const express = require('express')
const path = require('path')
const fetch = require('node-fetch');
const app = express();
const bodyParser = require('body-parser')
app.use( bodyParser.json() );    
app.use(bodyParser.urlencoded({     
  extended: true
})); 
const API_SERVER_URL= 'http://localhost:8080/'

app.use(express.static(path.join(__dirname, 'public')));

nunjucks.configure('public/', {
    autoescape: true,
    express: app
});

let countries = [];

fetch('https://restcountries.eu/rest/v1/region/Europe').then(res => res.json())
    .then(json => {
        json.forEach(country => {
            countries.push({"country": country['name']})
        })
    });

app.post('/', function(req, res) {
    console.log(req.body)
    fetch(API_SERVER_URL+"userData/", {
        method: 'post',
        body:    JSON.stringify(req.body),
        headers: { 'Content-Type': 'application/json' },
    })
    .then(response => {
        if (response.status === 200)
            return response.json()
        else
            res.render('views/userFailed.html')
    })
    .then(json => {
        res.render('views/userComplete.html',{"name": json["name"]})
    });
});

app.get('/', function(req, res) {
    res.render('views/userData.html',{"countries": countries});
});

app.listen(3000, ()=>{
    console.log("scrumconnect-ui started successfully")
})