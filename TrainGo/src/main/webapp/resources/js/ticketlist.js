$(document).ready(function(data){
	
	/*selectData();*/
	

});
/*function selectData(){
	$.ajax({
		type:'post',
		url:'ticketlistAjax.do',
		dataType:'json',
		cache:false,
		timeout:30000,
		success:function(data){
			var command = data.list;
			if(command == null){
				alert('내역이 없습니다.');
			}else{
				$("#cancel").show();
				$(command).each(function(index,item){
					var output =' ';
					if(item.cancel =='취소'){
						output+= '<div>'+item.id+'<br>';
						output+=item.trainnum+"<br>";
						output+=item.ticketnum+"<br>";
						output+=item.seatnum+' </div>';
						output+='<input type="button" value="예매하기" >';
						output +='<hr size="1" noshade>';
						$('#output').append(output);
					}
				});
			}
		},
		error:function(){
			alert('네트워크 오류 발생!');
		}


	});
}*/