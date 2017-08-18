function Fun (command){

    let num = Number(command[0])
    let numbers = []

    for (let i = 0; i< num; i++ ){
        numbers[i] = 0
    }

    for (let i = 1; i < command.length; i++){
        let pair = command[i].split(' - ')
        let index = Number(pair[0])
        let value = Number(pair[1])

        numbers[index] = value
    }
    for(let a of numbers){
        console.log(a)
    }
}