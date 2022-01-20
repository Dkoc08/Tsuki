$(document).ready(function(){
	$('body').on('click', '.editarProducto', function(){
	    $('#id').val($(this).attr('id'));
	    $('#txtNombre').val($(this).attr('param2'));
	    $('#Precio').val($(this).attr('param3'));
	    $('#txtDescripcion').val($(this).attr('param4'));
	    
	    $('#cboCategoria option:selected').removeAttr('selected');
	    $('#cboCategoria option[value='+$(this).attr('param1')+']').attr("selected", true);
	    
	    $('#modalProducto').modal({show: true});
	    return false;
	 });
});