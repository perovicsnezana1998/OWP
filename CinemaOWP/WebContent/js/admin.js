$(document).ready(function(){

    $('.delete').on('click', function(event){
        alert('Korisnik uspesno obrisan!');
    });

    $('#addMovie').on('click', function(event){
        window.location.replace('addMovie.html');
    });

    $('#addProjection').on('click', function(event){
        window.location.replace('addProjection.html');
    });

});