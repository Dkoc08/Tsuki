$(document).ready(function(){
	$('body').on('click', '.editarRepartidor', function(){
	    $('#id').val($(this).attr('id'));
	    $('#txtNombre').val($(this).attr('param1'));
	    $('#txtApellido').val($(this).attr('param2'));
	    $('#txtEmpresa').val($(this).attr('param3'));
	    $('#editarRepartidor').modal({show: true});
	    return false;
	 });
});