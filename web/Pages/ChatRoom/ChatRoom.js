

window.onload = function() {

    setInterval(postMessages,200);
    setInterval(postUsersOnline, 200);

};

function postUsersOnline() {

    $.ajax({
        url: "/Chat/PostUsers",
        type: 'GET',
        success: postUsersOnlineCallback
    });

}

function postUsersOnlineCallback(json) {

    var users = json.users;
    var usersTable = $("#usersTable");

    usersTable.empty();

    users.forEach(function(value,index) {

        if (value.isConnected) {
            var tr = $(document.createElement('tr'));
            var td = $(document.createElement('td')).text(value.Name);
            td.addClass("tdata");

            td.appendTo(tr);
            tr.appendTo(usersTable);
        }
    });

}

function postMessages() {

    $.ajax({
        url: "/Chat/Post",
        type: 'GET',
        success: submitMessageCallback
    });

}



function submitMessage() {

    var string = $('.messagebox').val();

    $('.messagebox').val("");

    $.ajax({
        url: "/Chat/Message",
        data: {
            Message: string
        },
        type: 'GET'

    });
}

function submitMessageCallback(json) {


    var allMessages = json.allMessages;

    var body = $("#messages");
    body.empty();

    allMessages.forEach(function(value,index) {

        var tr = $(document.createElement('tr'));
        var td = $(document.createElement('td')).text(value);
        td.addClass("tableData").attr("index",index%2);

        td.appendTo(tr);
        tr.appendTo(body);
    });

}