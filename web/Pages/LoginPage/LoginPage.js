
window.onload = function() {

    setInterval(postUsersOnline,200);

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
    var usersTable = $("#BodyOFUserTable");

    usersTable.empty();

    users.forEach(function(value,index) {

       if (value.isConnected) {
           var tr = $(document.createElement('tr'));
           var td = $(document.createElement('td')).text(value.Name);

           td.appendTo(tr);
           tr.appendTo(usersTable);
       }
    });

}

function getUserName() {

    var result = $("#userTextBox").val();
    console.log(result);
    return result;
}


function clickConnect() {

    var userName = getUserName();
    $.ajax({

        url:"/Chat/Stam",
        type: 'GET',
        data:{
            UserName: userName
        },
        success: clickConnectCallback
    });
}

function clickConnectCallback(json) {

    if (json.isNameExists) {

        $('#error').text(json.errorMessage);

    }

    else if ((!json.isEmpty) && (!json.isNameExists)) {

        window.location = "/Chat/Pages/ChatRoom/ChatRoom.html";

    }

}