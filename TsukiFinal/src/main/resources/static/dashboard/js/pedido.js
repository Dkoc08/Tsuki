$(document).ready(function(){
	$('body').on('click', '.editarPedido', function(){
	    $('#id').val($(this).attr('id'));
	    $('#Fecha').val($(this).attr('param1'));
	    
	    $('#cboCliente option:selected').removeAttr('selected');
	    $('#cboCliente option[value='+$(this).attr('param2')+']').attr("selected", true);
	    
	     $('#cboUsuario option:selected').removeAttr('selected');
	    $('#cboUsuario option[value='+$(this).attr('param3')+']').attr("selected", true);
	    
	    $('#modalPedido').modal({show: true});
	    return false;
	 });
});