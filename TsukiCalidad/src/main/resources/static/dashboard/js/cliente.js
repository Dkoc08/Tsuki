$(document).ready(function(){
	$('body').on('click', '.editarCliente', function(){
	    $('#id').val($(this).attr('id'));
	    $('#Dni').val($(this).attr('param1'));
	    $('#txtNombre').val($(this).attr('param2'));
	    $('#txtApellido').val($(this).attr('param3'));
	    $('#txtDireccion').val($(this).attr('param4'));
	    $('#txtCelular').val($(this).attr('param5'));
	    $('#txtCorreo').val($(this).attr('param6'));
	     $('#cboDistrito option:selected').removeAttr('selected');
   		 $('#cboDistrito option[value='+$(this).attr('param7')+']').attr("selected", true);
	    $('#editarCliente').modal({show: true});
	    return false;
	 });
});