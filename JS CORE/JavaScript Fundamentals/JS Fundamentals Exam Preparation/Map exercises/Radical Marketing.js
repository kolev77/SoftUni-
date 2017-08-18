function solve(input) {

    let users = new Map();
    let subscriptions = new Map();

    for (let i = 0; i < input.length; i++) {
        let currentCommand = input[i].split("-");

        if (currentCommand.length === 2) {
            let subscriber = currentCommand[0];
            let user = currentCommand[1];

            if (users.has(subscriber) && users.has(user)) { // check if two users exists
                users.get(user).add(subscriber);  // add subscriber to user`s subscribers
                subscriptions.get(subscriber).add(user); // add subscription ( user has been added, we just add his subscription )
            }
        } else {
            if (!users.has(currentCommand[0])) {
                let user = currentCommand[0];
                users.set(user, new Set()); // add user
                subscriptions.set(user, new Set()); // add user as future subscriber. There we`ll be able to  add his subscriptions
            }
        }
    }
    let sortedLog = new Map([...users.entries()].sort(function (firstEntry, secondEntry) {
        let firstEntryName = firstEntry[0];
        let firstEntrySubscribers = firstEntry[1].size;

        let secondEntryName = secondEntry[0];
        let secondEntrySubscribers = secondEntry[1].size;

        let result = secondEntrySubscribers - firstEntrySubscribers;

        if (result == 0) {
            let firstEntrySubscriptions = subscriptions.get(firstEntryName).size;
            let secondEntrySubscriptions = subscriptions.get(secondEntryName).size;

            result = secondEntrySubscribers - firstEntrySubscribers;
        }
        return result;
    }));

    let mostImportantPerson = [...sortedLog.entries()][0];
    console.log(mostImportantPerson[0]);

    let count = 1 ;
    mostImportantPerson[1].forEach(function (e) {
        console.log(count + ". " + e);
        count++;
    })
}

solve(['A', 'B', 'C', 'D',
    'A-B',
    'B-A',
    'C-A',
    'D-A']);