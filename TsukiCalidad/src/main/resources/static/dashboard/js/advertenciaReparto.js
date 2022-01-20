function eliminar(id){
        swal({
  			title: "Estás seguro que deseas eliminar?",
			text: "Una vez eliminado no se podra recuperar lo iliminado",
			icon: "warning",
			buttons: true,
			dangerMode: true,
	})
		.then((OK) => {
 			 if (OK) {
				$.ajax({
					url:"delete/"+id,
					success: function(res){
						console.log(res);
					}, 
			});
    	swal("Listo! El reparto fue eliminado con éxito", {
      		icon: "success",
   		 }).then((OK)=>{
				if(OK){
					location.href="/reparto/";
				}
			});
  			} else {
    		swal("No se ha eliminado nada");
  }
});
}	