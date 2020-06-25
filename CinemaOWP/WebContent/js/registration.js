$(document).ready(function(){
	
	var usernameInput = $('#korisnickoIme');
	var passwordInput = $('#lozinka');
	var password2Input = $('#password2');

    $('#registerBtn').on('click', function(event){
    	
    	var username = usernameInput.val();
        var password = passwordInput.val();
        var password2 = password2Input.val();
    	
        alert(username)
    	alert(password);
    	alert(password2);
        console.log(password);
        console.log(password2);



        if (password2 == "") {
            alert("Sva polja moraju biti popunjena.");
            event.preventDefault();
            
            return false;
        }

//        if(password != password2){
//            alert('Lozinke se moraju podudarati.');
//            console.log(password);
//            event.preventDefault();
//            
//            return false;
//        }

        var params = {
            'username': username,
            'password': password2
        }

        $.post('RegistrationServlet', params, function(data){
            if (data.status == 'failure') {
                alert('Neuspela registracija');
                return;
            }

            if (data.status == 'success') {
            	
            	alert('Uspesno ste se registrovali!');
                
                window.location.replace('index.html');

            }
        });

        event.preventDefault();
        return false;

    });

});