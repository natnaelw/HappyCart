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


var removeFromCart = function(rowid, productId){
	$.ajax({
		url:"/happyCart/cart/remove/"+productId,
		type: "DELETE",
		dataType: "json",
		contentType: "application/json",
		success:function(success){
			location.reload();
		},
		error:function(error){
		}
	});
}