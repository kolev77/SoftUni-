/**
 * Created by Rostislav on 16.6.2016 г..
 */
"use strict";
solve(['750'];
function solve(args) {
    let number = Number(args[0]);

    for(let i= 1; i <= number; i++)if (isPalindrome(i)) {
        console.log(i);
    }
    function isPalindrome(number) {
        let isSymmetric = true;
        for ( let i = 0; i < number.length/2; i++) {
            if ( number[i]!= number[number.length-i])
            {
                isSymetric= false;
                break;
            }
        }
    }
}