function solve([day,month,year]) {
    [day,month,year] = [day,month,year].map(Number);

    let date = new Date(year,month-1,0); // months are from 0 to 11. If the day is 0, it returns the last day of previous month;
    console.log(date.getDate());
}

solve(['17','3','2002']);
solve(['13','12','2004']);