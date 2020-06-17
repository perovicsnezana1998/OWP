$(document).ready(function(){

    $('#loginBtn').on('click', function(event){
        var username = $('#username').val();
        var password = $('#password').val();
        if(username == "" || password == ""){
            alert("Korisnicko ime i lozinka ne smeju ostati prazni.");
            event.preventDefault();
            
            return false;
        }  

        if(username == "" && password == ""){
            alert("Korisnicko ime i lozinka ne smeju ostati prazni.");
            event.preventDefault();
            
            return false;
        }  

        var params = {
            'username': username,
            'password': password
        }

        $.post('LoginServlet', params, function(data){

            if (data.status == 'failure') {
                $('#usernameInput').val('');
                $('#passwordInput').val('');
                return;
            }

            if (data.status == 'success') {
                $.get('UserServlet', {'action': 'loggedInUserRole'}, function(data){

                    if (data.status == 'unauthenticated') {
                        window.location.replace('index.html');
                        return;
                    }
                    if (data.loggedInUserRole == 'admin') {
                        alert('Bravo brate admine!');
                        window.location.replace('admin.html');
                    }
                    else{
                        alert('Bravo brate korisnice!')
                        window.location.replace('projections.html');
                    }

                });
            }

        });

    });

});