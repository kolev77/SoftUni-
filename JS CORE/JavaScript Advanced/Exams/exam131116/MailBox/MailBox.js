class MailBox {
    constructor(subject, text) {
        this.subject = subject;
        this.text = text;
        this.mails = [];
    }

    addMessage(subject, text) {
        let newMessage = {
            subject: subject,
            text: text
        };
        this.mails.push(newMessage);
        return this;
    }

    get messageCount() {
        return this.mails.length;
    }

    deleteAllMessages() {
        this.mails = [];
        return this;
    }

    findBySubject(substr) {     // TODO: need to be sorted
        let searchedMail = substr;
        let result = [];
        let match = false;
        for (let mail of this.mails) {
            if (mail.subject == searchedMail) {
                result.push(mail);
            }
        }
        return result;
    }

    toString() {
        if (this.mails.length == 0) {
            return `* (empty mailbox)`
        } else {
            let result = [];
            for (let mail of this.mails) {
                result.push(`*[${mail.subject}] ${mail.text}`);
            }
            return result;
        }
    }
}

let mb = new MailBox();
// console.log("Msg count: " + mb.messageCount);
// console.log('Messages:\n' + mb);

mb.addMessage("meeting", "Let's meet at 17/11");
mb.addMessage("beer", "Wanna drink beer tomorrow?");
mb.addMessage("question", "How to solve this problem?");
mb.addMessage("Sofia next week", "I am in Sofia next week.");
// console.log("Msg count: " + mb.messageCount);
// console.log('Messages:\n' + mb);
console.log(mb.messageCount);
console.log("Messages holding 'beer': " +
    JSON.stringify(mb.findBySubject('beer')));
