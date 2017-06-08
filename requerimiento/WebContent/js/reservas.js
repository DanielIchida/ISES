$('#r1').on("change",function(){
	$('.vuelta-form').css('display','none');
});

$('#r2').on('change',function(){
	$('.vuelta-form').css('display','block');
});

$('#form-reserva').on("submit",function(e){
	  e.preventDefault();
	  var fecha_vuelta = $('#vuelta').val();
	  var vuelta = fecha_vuelta.replace('T',' ')+":00";
	  var fecha_ida = $('#ida').val();
	  var ida = fecha_ida.replace('T',' ')+":00";
	  $.ajax({
	        url : "http://localhost:8150/requerimiento/rest/itinerario/reservas",
	        method: "POST",
	        data: {"lugarida" : $('#origMun').val() , "lugarvuelta" : $('#vueltMun').val() , "fechaida" : ida , "fechavuelta" : vuelta },
	        contentType: "application/x-www-form-urlencoded",
	        success: function(data){
	        	var selectIda = new Date(ida);
	        	var selectVuelta = new Date(vuelta);
	        	var hoy = new Date();
	        	var diaSumar = hoy.setDate(hoy.getDate() + 3)
	        	if(selectIda < diaSumar || selectVuelta < diaSumar){
	        		alert("Debes reservar con 3 dias de anticipacion");
	        	}else{
	        		$("#itinerario").modal();
		        	$('#idaf').text(ida);
		        	$('#vueltaf').text(vuelta);
		        	nombreLugar('#idal',$('#origMun').val());
		        	nombreLugar('#vueltal',$('#vueltMun').val());
	        	}
	        	
	        },
	        error : function(xhr, status) {
	             console.log("Error: "+xhr+" "+status);
	        }
	    });
});

function nombreLugar(contenedor,id){
	 $.getJSON('http://localhost:8150/requerimiento/rest/municipios/get/'+id).done(function(data, textStatus, jqXHR ){
		  $(contenedor).text(data.nombre); 
	 }).fail(function (jqXHR, textStatus, errorThrown ) {
		 console.log( "Algo ha fallado: " +  textStatus);
	 });
}