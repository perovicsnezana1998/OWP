$(document).ready(function(){

    $('#registerBtn').on('click', function(event){
        var name = $('#name').val();
        var lastName = $('#lastname').val();
        var username = $('#username').val();
        var password = $('#password').val();
        var password2 = $('#password2').val();
        if(username == "" || password == "" || name == "" || lastName == "" || password2 == ""){
            alert("Sva polja moraju biti popunjena.");
            event.preventDefault();
            
            return false;
        }  

        if(password != password2){
            alert('Lozinke se moraju podudarati.');
            event.preventDefault();
            
            return false;
        }

    });

});