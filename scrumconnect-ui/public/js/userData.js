let status = 'pending'; 
    const onSubmitRegistration = ()=>{
        let data = {'name': null, 'age': null, 'sex': null, 'country': null}
        data.name = document.getElementById('name').value
        data.age = document.getElementById('age').value
        
        let countryElement = document.getElementById("country");
        data.country = countryElement.options[countryElement.selectedIndex].text;
        if(document.getElementById('male').checked)
            data.sex = 'male'
        else if (document.getElementById('female')){
            data.sex = 'female'
        }
        let errorString = "Required fields are missing:"
        let errorFound = false;
        Object.keys(data).forEach(key =>{
            if (data[key] === undefined || data[key] === null || data[key].trim().length === 0){
                if(errorFound)
                    errorString += ", " + key
                else
                    errorString += " " + key
                errorFound = true;
            }
        })
        errorString += ". "
        if (data.age!=null && (isNaN(data.age) ||isNaN(parseFloat(data.age)))){
            errorFound = true;
            errorString +="You must provide a valid number for age"
        }
            
        if (errorFound){
            document.getElementById('error-text').innerHTML = errorString
            return;
        }
        fetch("/", {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body:    JSON.stringify(data)
        }).then(response => {
             return response.text()
        })
        .then(text => {
            let formElement = document.getElementById('form-content')
            formElement.innerHTML = text
        });
    }