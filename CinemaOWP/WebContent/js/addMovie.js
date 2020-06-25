$(document).ready(function(){

    var nameInput = $('#imeFilma');
    var directorInput = $('#reziser');
    var actorsInput = $('#glumci');
    var genreInput = $('#zanr');
    var durationInput = $('#trajanje');
    var distributorInput = $('#distributer');
    var countryInput = $('#zemlja');
    var yearInput = $('#godina');
    var descriptionInput = $('#opis');

    $('#dodajFilm').on('click', function(){

        var name = nameInput.val();
        var director = directorInput.val();
        var actors = actorsInput.val();
        var genre = genreInput.val();
        var duration = durationInput.val();
        var distributor = distributorInput.val();
        var country = countryInput.val();
        var year = yearInput.val();
        var description = descriptionInput.val();

        console.log(name);
        console.log(director);
        console.log(actors);
        console.log(genre);
        console.log(duration);
        console.log(distributor);
        console.log(country);
        console.log(year);
        console.log(description);

        if(name == ""){
            alert('Name cannot be empty!');
            event.preventDefault();
            return false;
        }
        if(director == ""){
            alert('Director cannot be empty!');
            event.preventDefault();
            return false;
        }
        
        if(distributor == ""){
            alert('Distributor cannot be empty!');
            event.preventDefault();
            return false;
        }
        if(description == ""){
            alert('Description cannot be empty!');
            event.preventDefault();
            return false;
        }
        
        if(isNaN(year)){
            alert('Year must be a number!')
            event.preventDefault();
            return false;
        }
        if(isNaN(duration)){
            alert('Duration must be a number!')
            event.preventDefault();
            return false;
        }

        var action = 'add';

        var params = {
            'name': name,
            'director': director,
            'actors': actors,
            'genre': genre,
            'duration': duration,
            'distributor': distributor,
            'country': country,
            'year': year,
            'description': description,
            'action': action
        }

        $.post('MovieServlet', params, function(){

            if(data.status == 'success'){
                alert("Movie added succesfully! ");
                window.location.replace('projections.html');
            }
            
            if(data.status == 'failure'){
                
                console.log('nevalja');
                
                $("#imeFilma").val('');
                $("#reziser").val('');
                $("#glumci").val('');
                $("#trajanje").val('');
                $("#zanr").val('');
                $("#distributer").val('');
                $("#zemlja").val('');
                $("#godina").val('');
                $("#opis").val('');
                
                alert('Nesto je pogresno popunjeno.Pokusajte opet!')
                
                event.preventDefault();
                return;
                
            }

        });

    });

});