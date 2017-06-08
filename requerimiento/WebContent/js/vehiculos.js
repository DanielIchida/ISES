 $.getJSON('http://localhost:8150/requerimiento/rest/vehiculos/lista').done(function(data, textStatus, jqXHR ){
		 $.each(data, function(idx,x) {
			 $("#vehiculos").append('<li>'+x.placa+' - '+x.marca+'</li>');
			 console.log(data);
		 });
	 }).fail(function (jqXHR, textStatus, errorThrown ) {
		 console.log( "Algo ha fallado: " +  textStatus);
	 });