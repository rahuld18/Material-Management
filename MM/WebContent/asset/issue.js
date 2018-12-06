$(document).ready(function(){
$.getJSON("GetAllCategoryJSON",{ajax:true},function(data){
	
	$('#cid').append($('<option>').text('-Category-'));
	$.each(data,function(i,item){
	  
		$('#cid').append($('<option>').text(item.CATEGORYNAME).val(item.CATEGORYID));	
		
	});
	
	
});

$('#cid').change(function(){
	 $.getJSON("GetAllSubcategoryJSON",{ajax:true,cid:$('#cid').val()},function(data){
		 $('#sid').empty();
		 $('#sid').append($('<option>').text('-SubCategory-'));
			$.each(data,function(i,item){
		 		$('#sid').append($('<option>').text(item.SUBCATEGORYNAME).val(item.SUBCATEGORYID));	
		 		 $('#pid').empty();
			}); 

	});
});


$('#sid').change(function(){
	 $.getJSON("GetAllProductJSON",{ajax:true,sid:$('#sid').val()},function(data){
		 $('#pid').empty();
		 $('#pid').append($('<option>').text('-Product-'));
			$.each(data,function(i,item){
		 		$('#pid').append($('<option>').text(item.PRODUCTNAME).val(item.PRODUCTID));	
		 	}); 

	});
});


});