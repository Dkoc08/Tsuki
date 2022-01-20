$(document).ready(function(){
	$('body').on('click', '.editarReparto', function(){
	    $('#id').val($(this).attr('id'));
	    $('#txtFecha').val($(this).attr('param3'));
	    
	    $('#cboPedido option:selected').removeAttr('selected');
	    $('#cboPedido option[value='+$(this).attr('param1')+']').attr("selected", true);
	    
	    $('#cboRepartidor option:selected').removeAttr('selected');
	    $('#cboRepartidor option[value='+$(this).attr('param2')+']').attr("selected", true);
	    
	    $('#modalReparto').modal({show: true});
	    return false;
	 });
});