function addOrRemove(actions) {
    let initNum = 1;
    let result = [];

    for (let action = 0; action < actions.length; action++) {
        if(actions[action] === 'add'){
            result.push(initNum);
        }
        else if(actions[action] === "remove"){
            result.pop();
        }
        initNum++;
    }

    if(result.length <= 0)
    {
        console.log("Empty")
    }
    else {
        console.log(result.join("\n"));
    }
}
//addOrRemove(['remove','remove','remove']);
addOrRemove(['add','add','add'])