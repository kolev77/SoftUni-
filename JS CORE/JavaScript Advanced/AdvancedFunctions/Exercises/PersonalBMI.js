function checkBMI(name, age, weight, height) {
    let bmi = '';
    let object = {
        name: name,
        personalInfo: {age: Number(age), weight: Number(weight), height: Number(height)},
        BMI: (() => {
            return bmi = Math.round(weight / (Math.pow((height/100),2)));
        })(),
        status: (() => {
            if (bmi < 18.5) {
                return 'underweight'
            } else if (bmi < 25) {
                return 'normal'
            } else if (bmi < 30) {
                return 'overweight'
            } else {
                return 'obese'
            }
        })()
    };
    if (object.status ===  'obese') {
        object['recommendation'] = 'admission required';
    }
    return object;
}
console.log(checkBMI('Peter', '29', '75', '182'));
console.log(checkBMI('Honey Boo Boo', '9', '57', '137'));