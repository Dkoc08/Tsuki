$(document).ready(function(){
	$('body').on('click', '.editarUsuario', function(){
	    $('#id').val($(this).attr('id'));
	    $('#Dni').val($(this).attr('param1'));
	    $('#txtNombre').val($(this).attr('param2'));
	    $('#txtApellido').val($(this).attr('param3'));
	    $('#txtCorreo').val($(this).attr('param4'));
	    $('#txtCelular').val($(this).attr('param5'));
	    $('#editarUsuario').modal({show: true});
	    return false;
	 });
});