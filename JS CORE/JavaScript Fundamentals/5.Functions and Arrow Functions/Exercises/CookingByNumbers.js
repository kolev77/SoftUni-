function cooking(input) {
    for (let i = 0; i < input.length; i++) {
        let activity = '';
    if (i == 0)
        var num = input[i];
    if( i>0)
        activity += input[i];

        if (activity == 'chop') {
            num /= 2;
            console.log(num)
        }
        if (activity == 'dice') {
                num = Math.sqrt(num);
                console.log(num);
            }
        if (activity == 'spice') {
            num += 1;
            console.log(num)
        }
        if (activity == 'bake') {
                num *= 3;
                console.log(num)
        }
        if (activity == 'fillet') {
                    num -= num * 0.2;
                    console.log(num)
        }
    }
}



cooking([32, 'chop', 'chop', 'chop', 'chop', 'chop']);
cooking([9, 'dice', 'spice', 'chop', 'bake', 'fillet'])