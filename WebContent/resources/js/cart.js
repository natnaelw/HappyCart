var addToCart = function(productId, quantity, mode){
	
	$.ajax({
		url:"/happyCart/cart/add/" + productId + "?quantity="+quantity+"&mode="+mode,
		type: "PUT",
		datatype:"json",
		contentType:"application/json",
		success:function(success){
			$("#dialog" ).dialog({
			    buttons: { "OK": function() { $(this).dialog("close"); } }
			});
		}
	});
}

