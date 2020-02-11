$(document).ready(function(){

    $('#loginBtn').on('click', function(event){
        var username = $('#username').val();
        var password = $('#password').val();
        if(username == "" || password == ""){
            alert("Korisnicko ime i lozinka ne smeju ostati prazni.");
            event.preventDefault();
            
            return false;
        }  

    });

});