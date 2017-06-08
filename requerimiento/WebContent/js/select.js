function select(ident,munic){
	 $.getJSON('http://localhost:8150/requerimiento/rest/departamentos/listado').done(function(data, textStatus, jqXHR ){
		 $.each(data, function(idx,x) {
			 $(ident).append('<option value="'+x.id+'">'+x.nombre+'</option>');
		 });
	 }).fail(function (jqXHR, textStatus, errorThrown ) {
		 console.log( "Algo ha fallado: " +  textStatus);
	 });
	 $(ident).on("click",function(){
		 $(munic).empty();
		 $.getJSON('http://localhost:8150/requerimiento/rest/municipios/listado/'+$(ident).val()).done(function(data, textStatus, jqXHR ){
			 $.each(data, function(idx,x) {
				 $(munic).append('<option value="'+x.id+'">'+x.nombre+'</option>');
			 });
		 }).fail(function (jqXHR, textStatus, errorThrown ) {
			 console.log( "Algo ha fallado: " +  textStatus);
		 });
	 });
}
select('#origDep','#origMun'); 
select('#vueltDep','#vueltMun'); 