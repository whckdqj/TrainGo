$(document).ready(function(data){
	
	$('#confirmPass').click(function(){
		if($('#check').val()==''){
			alert('비밀번호를 입력하세요!');
			$('#passwd').focus();
			return;
		}
		
		$.ajax({
			url:'passwdConfirm.do',
			type:'post',
			data:{id:$('#id2').val(),passwd:$('#check').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result =='correct'){
					mysubmit();
					
				}else if(data.result=='incorrect'){
					alert('비밀번호를 잘못 입력하셨습니다.');
					$('#check').val('');
				}
				
				
			},
			error:function(){
				
				alert('네트워크 오류 발생');
			}
		});
		
	});
	

});

