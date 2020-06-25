$(document).ready(function(){
	
	$.get("ProjectionsServlet", function(data){
		
		if(data.status == "success"){


			for(i=0; i < data.movies.length; i++){
				var id = data.movies[i].id;
				var name = data.movies[i].name;
				var description = data.movies[i].description;

				var div = document.getElementById('projectionDetails');

				div.innerHTML += '<div class="col-md-4">' +
								 	'<img src="images/movie3-1.jpg" alt="..." id="movieImg">' +
								 '</div>' +
								 '<div class="col-md-5" id="moviePr">' +
									 '<h3>' + name + '</h3>' +
									 '<p>' + description + '<p>' + 
									 '<p><a href="details.html?id=' + id +'" class="btn btn-primary" role="button">Detaljnije</a></p>' +
								 '</div>' +
								 '<div class="col-md-3" id="">' +
								 '<h4>Izaberi vreme projekcije i rezervisi:</h4>' +
								 '<br>' +
								 '<div class="row">' +
									 '<div class="col-md-4" id="prTime">' +
										 '<a href="buyTicket.html" class="prTime">' +
											 '<div class="prTime2">' +
												 '<p>14:30</p>' +
												 '<p>370RSD</p>' +
												 '<hr>' +
												 '<p>sala: 5</p>' +
											 '</div>' +
										 '</a>' +
									 '</div>' +
								 '</div>' +
							 	 '</div>';


		

			}

		}
	});
	
});
