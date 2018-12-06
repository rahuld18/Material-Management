$(document).ready(function(){
	
	$.getJSON("GetAllProductReportJSON",{ajax:true},function(data){
		
	
			
			$('#pid').append($('<option>').text('-ChooseProduct-'));
			$.each(data,function(i,item){
				$('#pid').append($('<option>').text(item.PRODUCTNAME).val(item.PRODUCTID));
				
		
			
		
	});
			}); 
	$('#searchbtn').click(function(){
		
		$.getJSON("ReportProductWiseIssuePurchaseBetweenTwoDatesJSON",{ajax:true,pid:$('#pid').val(),status:$('#status').val(),datefrom:$('#datefrom').val(),dateto:$('#dateto').val()},function(data){
			if($('#status').val()=="Issue"){
			htm="<table border=1 cellspacing=3>"
				htm+="<caption><b><i>List Of Product Issue Between "+$('#datefrom').val()+" and "+$('#dateto').val()+"</i></b></caption>";
				htm+="<tr><th>Transaction Id</th><th>Issued By</th><th>Product</th><th>Issue Date</th><th>Quantity<br>Issued</th><th>Remark</th></tr>";
				$.each(data,function(i,item){
				htm+="<tr><td>"+item.TRANSACTIONID+"</td><th>["+item.EMPLOYEEID+"] "+item.IEMPNAME+"<br><img src=/MM/eimages/"+item.IEPICTURE+" width=30 height=30></th><th>["+item.PRODUCTID+"] "+item.IPNAME+"<br><img src=/MM/eimages/"+item.IPPICTURE+" width=30 height=30></th><td>"+item.ISSUEDATE+"</td><td>"+item.QTYISSUE+"</td><td>"+item.PURPOSEOFISSUE+"</td></tr>";
				});htm+="</table>";
				}
				else{
					htm="<table border=1 cellspacing=3>"
						htm+="<caption><b><i>List Of Product Purchase Between "+$('#datefrom').val()+" and "+$('#dateto').val()+"</i></b></caption>";
						htm+="<tr><th>Transaction Id</th><th>Purchased By</th><th>Product</th><th>Purchase Date</th><th>Quantity<br>Purchased</th><th>Supplier</th></tr>";
						$.each(data,function(i,item){
						htm+="<tr><td>"+item.PTRANSACTIONID+"</td><th>["+item.EMPLOYEEID+"] "+item.PEMPNAME+"<br><img src=/MM/eimages/"+item.PEPICTURE+" width=30 height=30></th><th>["+item.PRODUCTID+"] "+item.PPNAME+"<br><img src=/MM/eimages/"+item.PPPICTURE+" width=30 height=30></th><td>"+item.PURCHASEDATE+"</td><td>"+item.QTYPURCHASE+"</td><td>"+item.SUPPLIERNAME+"<br>"+item.INVOICENO+"<br>Rate:"+item.RATE+"</td></tr>";
						
					
								
	});
				htm+="</table>";}
				$('#result').html(htm);
		});
	
	
});
});