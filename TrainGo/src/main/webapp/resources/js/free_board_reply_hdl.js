//freeBoard 댓글
$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	
	//댓글 목록
	function selectData(pageNum,num){
		currentPage = pageNum;
		
		if(pageNum == 1){
			//처음 호출시는 해당 ID의 div의 내부 내용물을 제거
			$('#output').empty();
		}
		//로딩 이미지노출
		$('#loading').show();
		
		//등록 호출 Ajax
		$.ajax({
			type:'post',
			data:{pageNum:pageNum,num:num},
			url:'freeListReplyAjax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				//로딩 이미지 감추기
				$('#loading').hide();
				count = data.count;
				rowCount = data.rowCount;
				var list = data.list;
				
				if(count < 0 || list == null){
					alert('목록 호출 오류 발생');
				}else{
					$(list).each(function(index,item){
						var output = '';
						
						output += '<div class="item" id="i'+item.re_num+'">';
						output += '<h4>' + item.id + '</h4>';
						output += '<div class="sub-item">';
						output += '<p>' + item.re_content + '</p>';
						output += '<div>' + item.re_register;
						
						if($('#userId').val() && $('#userId').val()==item.id){
							output += ' <input type="button" value="수정" data-num="'+item.re_num+'" data-id="'+item.id+'" class="modify_button">';
							output += ' <input type="button" value="삭제" data-num="'+item.re_num+'" data-id="'+item.id+'" class="delete_button">';
						}else{
							output += ' <input type="button" value="수정" disabled="disabled">';
							output += ' <input type="button" value="삭제" disabled="disabled">';
						}
						
						output += '<hr size="1" noshade>';
						output += '</div>';
						output += '</div>';
						output += '</div>';
						
						//문서 객체에 추가
						$('#output').append(output);
					});
					
					//paging button 처리
					if(currentPage>=Math.ceil(count/rowCount)){
						//다음 페이지가 없음
						$('.paging_button').hide();
					}else{
						//다음 페이지가 존재
						$('.paging_button').show();
					}
				}
			},
			error:function(){
				//로딩 이미지 감추기
				$('#loading').hide();
				alert('네트워크 오류 발생1!');
			}
		});
		
	}
	
	//다음 댓글 보기 버튼 클릭시 데이터 추가
	$('.paging_button input').click(function(){
		var pageNum = currentPage + 1;
		selectData(pageNum,$('#num').val());
	});
	
	//댓글 등록
	$('#re_form').submit(function(event){
		if($('#re_content').val()==''){
			alert('내용을 입력하세요!');
			$('#re_content').focus();
			return false;
		}
		
		//폼에 입력한 데이터 반환
		var data = $(this).serialize();
		
		//댓글 등록 Ajax
		$.ajax({
			type:'post',
			data:data,
			url:'freeWriteReplyAjax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result=='logout'){
					alert('로그인해야 작성할 수 있습니다.');
				}else if(data.result == 'success'){
					//폼 초기화
					initForm();
					//수정폼 초기화
					initModifyForm();
					//댓글 작성이 성공하면 새로 삽입한 글을
					//포함새서 첫번째 페이지의 게시글을 다시
					//호출함
					selectData(1,$('#num').val());
				}else{
					alert('등록시 오류 발생!');
				}
			},
			error:function(){
				alert('네트워크 오류 발생2!');
			}
		});
		//기본 이벤트 제거
		event.preventDefault();
	});
	
	//댓글 작성 폼 초기화
	function initForm(){
		$('textarea').val('');
		$('#re_first .letter-count').text('300/300');
	}
	
	//textarea에 내용 입력시 글자수 체크
	$('#re_content,#mre_content').keyup(function(){
		//남은 글자수를 구함
		var inputLength = $(this).val().length;
		
		if(inputLength>300){
			$(this).val($(this).val().substring(0,300));
			if($(this).attr('id')=='re_content'){
				//등록폼 글자수
				$('#re_first .letter-count').text('0/300');
			}else{
				//수정폼 글자수
				$('#mre_first .letter-count').text('0/300');
			}
		}else{
			var remain = 300 - inputLength;
			remain += '/300';
			//문서 객체에 반영
			if($(this).attr('id')=='re_content'){
				//등록폼 글자수
				$('#re_first .letter-count').text(remain);
			}else{
				//수정폼 글자수
				$('#mre_first .letter-count').text(remain);
			}
		}
	});
	
	//댓글 수정 버튼 클릭시 수정폼 노출
	$(document).on('click','.modify_button',function(){
		//댓글 글번호
		var num = $(this).attr('data-num');
		//작성자 아이디
		var id = $(this).attr('data-id');
		//이전에 이미 수정하는 댓글이 있을 경우 수정버튼을
	    //클릭하면 숨긴 sub-item를 환원시키는 작업
		$('.sub-item').show();
		//현재 클릭해서 수정하고자 하는 데이터는 감추기
		$('#i'+num+' .sub-item').hide();
		
		//수정폼에 데이터 셋팅
		$('#mre_num').val(num);
		$('#muserId').val(id);
		$('#mre_content').val($('#i'+num+' p').text());
		
		//입력한 글자수 셋팅
		var inputLength = $('#mre_content').val().length;
		var remain = 300 - inputLength;
		remain += '/300';
		
		//문서 객체에 반영
		$('#mre_first .letter-count').text(remain);
		
		//수정폼을 수정하고자하는 데이터가 있는 div에 노출
		$('#i'+num).append($('#mre_form'));
	});
	
	//수정폼에서 취소 버튼 클릭시 수정폼 초기화
	$('.re-reset').click(function(){
		initModifyForm();
	});
	
	//댓글 수정 폼 초기화
	function initModifyForm(){
		$('.sub-item').show();
		//폼의 원래위치로 복원
		$('#modify_div').append($('#mre_form'));
		$('#mre_num').val('');
		$('#muserId').val('');
		$('#mre_content').val('');
		$('#mre_first .letter-count').text('300/300');
	}
	
	//댓글 수정
	$('#mre_form').submit(function(event){
		if($('#mre_content').val()==''){
			alert('내용을 입력하세요!');
			$('#mre_content').focus();
			return false;
		}
		
		//폼에 입력한 데이터 반환
		var data = $(this).serialize();
		
		//수정
		$.ajax({
			type:'post',
			data:data,
			url:'freeUpdateReplyAjax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result=='logout'){
					alert('로그인해야 수정할 수 있습니다.');
				}else if(data.result=='wrongAccess'){
					alert('잘못된 접속입니다.');
				}else if(data.result=='success'){
					$('#i'+$('#mre_num').val() + ' p').html($('#mre_content').val());
					//수정폼 초기화
					initModifyForm();
				}else{
					alert('수정시 오류 발생!');
				}
			},
			error:function(){
				alert('네트워크 오류 발생!');
			}
		});
		//기본 이벤트 제거
		event.preventDefault();
	});
	
	//댓글 삭제
	$(document).on('click','.delete_button',function(){
		//댓글 번호
		var num = $(this).attr('data-num');
		//작성자 아이디
		var id = $(this).attr('data-id');
		
		//삭제
		$.ajax({
			type:'post',
			data:{re_num:num,id:id},
			url:'freeDeleteReplyAjax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result=='logout'){
					alert('로그인해야 삭제할 수 있습니다.');
				}else if(data.result=='wrongAccess'){
					alert('잘못된 접속입니다.');
				}else if(data.result=='success'){
					alert('삭제 완료!');
					//수정폼초기화
					initModifyForm();
					selectData(1,$('#num').val());
				}else{
					alert('삭제시 오류 발생!');
				}
			},
			error:function(){
				alert('네트워크 오류 발생3!');
			}
		});
		
	});
	
	//초기 데이터(목록)호출
	selectData(1,$('#num').val());
});