$('#submit').click(send);
$('#refresh').click(refresh);

let hostUrl = "https://messenger-40767.firebaseio.com/messenger.json";
function send() {
    let message = {
        author: $('#author').val(),
        content: $('#content').val(),
        timestamp: Date.now()
    };
    $('#content').val('');
    $.post(hostUrl, JSON.stringify(message)).then(refresh);
}

function refresh() {
    $('#messages').empty();
    $.get(hostUrl)
        .then((result) => {
            let keys = Object.keys(result).sort((m1,m2) => result[m1].timestamp - result[m2].timestamp);
            for (let msg of keys) {
                $('#messages').append(`${result[msg].author}: ${result[msg].content}\n`);
            }
        });
}