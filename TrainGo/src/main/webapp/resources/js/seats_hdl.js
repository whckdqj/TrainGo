$(function(){
	var clickseat="";
	var cancelseat="";		
	var su=0;
	var count=$('#humancount').val();
	var totalcost=$('#totalcost').text();
	$("#totalcost").text(numberWithCommas(totalcost)+"원"); 
	
	
	
			
	//var cost=$("#cost").val();	
//	cost=Number(cost.toString().replace(",",""));
	
	
	
	function numberWithCommas(x) {
	    x = x.toString();
	    var pattern = /(-?\d+)(\d{3})/;
	    while (pattern.test(x))
	        x = x.replace(pattern, "$1,$2");
	    return x;
	}	
		
	
	$('.seat').css('color','#0000ff');
	$(document).on('click','.seat',function(){   
		if(su==count){
			alert("더 이상 선택이 불가합니다.");
			return false;		
			
		}
		
		clickseat+=$(this).text()+" "; 
		++su;
		$('#humancount').val(count-su);
		$(this).css('color','red');		
				
		
		$("#seatnums").val(clickseat);		
		$(this).attr('class','off');   
				
		/*$("#totalcost").text(numberWithCommas(cost*su)+"원"); */

		
		
	});


	$(document).on('click','.off',function(){	
				
		
		cancelseat="";
		cancelseat=$(this).text()+" ";
				
		
        clickseat=clickseat.toString().replace(cancelseat,""); 
        
       
		--su;	
		$('#humancount').val(count-su);
		
		$("#seatnums").val(clickseat); 
		$(this).css('color','#0000ff'); 		
		$(this).attr('class','seat');
		
		
	/*	$("#totalcost").text(numberWithCommas(cost*su)+"원"); */

	});



	$('#select_seat').submit(function(){  
		var ser = jQuery("#select_seat").serialize();
		
		
		
		 if(su!=count){
			   alert("좌석을 더 선택하셔야 합니다.")
			   return false;
		   }	
	
	
	
	
	});
	
	    
	
});		