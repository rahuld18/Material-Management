$(document).ready(function(){
	
	$.getJSON("GetAllEmployeeReportJSON",{ajax:true},function(data){
		
	
			$('#eid').empty();
			$('#eid').append($('<option>').text('-ChooseEmployee-'));
			$.each(data,function(i,item){
				$('#eid').append($('<option>').text(item.EMPLOYEENAME).val(item.EMPLOYEEID));
				
		
			
		
	});
	});
	
$('#searchbtn').click(function(){
		
		$.getJSON("ReportEmployeeWiseProductWiseBetweenTwoDatesJSON",{ajax:true,eid:$('#eid').val(),status:$('#status').val(),datefrom:$('#datefrom').val(),dateto:$('#dateto').val()},function(data){
			if($('#status').val()=="Issue"){
			htm="<table border=1 cellspacing=3>";
	
	
	
			htm+="<caption><b><i>List Of Employee Issue Between "+$('#datefrom').val()+" and "+$('#dateto').val()+"</i></b></caption>";
			htm+="<tr><th>Employee Name</th><th>Transaction Id</th><th>Product Name</th><th>Issue Date</th><th>Quantity</th><th>Purpose Of Issue</th></tr>";
			$.each(data,function(i,item){
			htm+="<tr><td>["+item.EMPLOYEEID+"] "+item.IEMPNAME+"<br><img src=/MM/eimages/"+item.IEPICTURE+" width=30 height=30></td><td>"+item.TRANSACTIONID+"</td><td>["+item.PRODUCTID+"] "+item.IPNAME+"<br><img src=/MM/eimages/"+item.IPPICTURE+" width=30 height=30></td><td>"+item.ISSUEDATE+"</td><td>"+item.QTYISSUE+"</td><td>"+item.PURPOSEOFISSUE+"</td></tr>";
			});htm+="</table>";
			}
			else{
				htm="<table border=1 cellspacing=3>"
					htm+="<caption><b><i>List Of Employee Purchase Product Between "+$('#datefrom').val()+" and "+$('#dateto').val()+"</i></b></caption>";
					
				htm+="<tr><th>Transaction Id</th><th>Purchased By</th><th>Product</th><th>Purchase Date</th><th>Quantity<br>Purchased</th></tr>";
					$.each(data,function(i,item){
						//if($('#eid')==item.PEMPNAME){
					htm+="<tr><td>"+item.PTRANSACTIONID+"</td><th>["+item.EMPLOYEEID+"] "+item.PEMPNAME+"<br><img src=/MM/eimages/"+item.PEPICTURE+" width=30 height=30></th><th>["+item.PRODUCTID+"] "+item.PPNAME+"<br><img src=/MM/eimages/"+item.PPPICTURE+" width=30 height=30></th><td>"+item.PURCHASEDATE+"</td><td>"+item.QTYPURCHASE+"</td><td></td></tr>";
						//}
					});
								htm+="</table>";}
								$('#result').html(htm);
						});
								
			
});
});
			
