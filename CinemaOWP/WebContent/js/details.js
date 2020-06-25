$(document).ready(function(){

    var id = window.location.search.slice(1).split('&')[0].split('=')[1];

    var params = {
        'id': id 
    }

    $.get("MovieServlet", params, function(data){

        if (data.status == "success") {
            
            var movieName = document.getElementById('movieName');
            var movieDirector = document.getElementById('movieDirector');
            var movieActors = document.getElementById('movieActors');
            var movieGenre = document.getElementById('movieGenre');
            var movieDuration = document.getElementById('movieDuration');
            var movieDistributor = document.getElementById('movieDistributor');
            var movieCountry = document.getElementById('movieCountry');
            var movieYear = document.getElementById('movieYear');
            var movieDescription = document.getElementById('movieDescription');

            movieName.innerHTML += data.movie.name;
            movieDirector.innerHTML += data.movie.director;
            movieActors.innerHTML += data.movie.actors;
            movieGenre.innerHTML += data.movie.genre;
            movieDuration.innerHTML += data.movie.duration;
            movieDistributor.innerHTML += data.movie.distributor;
            movieCountry.innerHTML += data.movie.country;
            movieYear.innerHTML += data.movie.year;
            movieDescription.innerHTML += data.movie.description;

            

        }

    });

});