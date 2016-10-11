function borrar(id){
	$.ajax({
		type: "GET", 
		url: "Eliminar",
		data: "id="+id,
		success: function(html){
			alert(html);
			location.reload();
		}
	  }
	);
}