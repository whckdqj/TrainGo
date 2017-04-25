//2017.02.23 19:25 JCB Add For StaionInfo
jQuery(document).ready(function(){
	var mancount=0;
	var oldcount=0;
	var childrencount=0;

	var oldcost=0;
	var childrencost=0;

	var cost="";

	var totalmancost=0;
	var totaloldcost=0;
	var totalchildrencost=0;
	var totaltotalcost=0;
	
	
	var manrate=0;
	var childrate=0;
	var oldrate=0;
	
	function NWC(x) {
	    x = x.toString();
	    var pattern = /(-?\d+)(\d{3})/;
	    while (pattern.test(x))
	        x = x.replace(pattern, "$1,$2");
	    return x;
	}



	$(document).on('click','#clickmodal',function(){   
         output2="";
         $('#costtable').empty(); 
		cost=$(this).parent().text();
		cost=cost.replace("상세정보","");
		cost=cost.replace(",","");	

		cost=Number(cost);

	
		
        
		oldcost=Math.ceil((cost*oldrate/100))*100;
		childrencost=Math.ceil((cost*childrate/100))*100;
		
		//제일 마지막에 넣어야 함
		cost=Math.ceil((cost*manrate/100))*100;
		

	

		totalmancost=cost*mancount;
		totaloldcost=oldcost*oldcount;
		totalchildrencost=childrencost*childrencount;
		totaltotalcost=totalmancost+totaloldcost+totalchildrencost;

		
		
		
		
		var output2;

		
		if(mancount>0){ 
		output2+="<tr>"
			output2+="<td>"+"성인"+"</td>";
		output2+="<td>"+mancount+"명"+"</td>";
		output2+="<td>"+NWC(cost)+"원"+"</td>";
		output2+="<td>"+NWC(totalmancost)+"원"+"</td>";
		output2+="</tr>"
		}

		if(oldcount>0){  
			output2+="<tr>"
				output2+="<td>"+"노약자"+"</td>";
		output2+="<td>"+oldcount+"명"+"</td>";
		output2+="<td>"+NWC(oldcost)+"원"+"</td>";
		output2+="<td>"+NWC(totaloldcost)+"원"+"</td>";
		output2+="</tr>"	
		}
		
		if(childrencount>0){
			output2+="<tr>"
				output2+="<td>"+"어린이"+"</td>";
		output2+="<td>"+childrencount+"명"+"</td>";
		output2+="<td>"+NWC(childrencost)+"원"+"</td>";
		output2+="<td>"+NWC(totalchildrencost)+"원"+"</td>";
		output2+="</tr>"	
		}
            


			$("#costtable").append(output2);
			
			$("#totaltotalcost").text(NWC(totaltotalcost)+"원");
			
			
	

	});










	// Get City
	getCityNodes();

	// Selected Element Influence to StationCode
	jQuery(document).on("change", "#area_dep", function(){
		/*var vals = jQuery("#area_dep option:selected").val();
		console.log(vals);*/
		if(jQuery("#area_dep option:selected").val()=="선택하세요"){
			jQuery("#stn_dep").empty().append('<option selected="selected">출발지를 선택해 주세요</option>');
			return;
		}
		getStaionCodes(jQuery("#stn_dep"), jQuery("#area_dep option:selected").val());
	});
	jQuery(document).on("change", "#area_arr", function(){
		/*var vals = jQuery("#area_arr option:selected").val();
		console.log(vals);*/
		if(jQuery("#area_arr option:selected").val()=="선택하세요"){
			jQuery("#stn_arr").empty().append('<option selected="selected">도착지를 선택해 주세요</option>');
			return;
		}
		getStaionCodes(jQuery("#stn_arr"), jQuery("#area_arr option:selected").val());
	});

	jQuery("#startdate").datepicker({
		showMonthAfterYear:true
		,dateFormat: "yy-mm-dd"
			,minDate:0, maxDate:"+2D"
				,defaultDate: +0
	});

	$("#reservation").submit(function(event){
		
		
		
		
		
		if(Number($('#mancount').val())+Number($('#oldcount').val())+Number($('#childrencount').val())==0){
			
			
			
			
			alert("최소 한명은 선택해야 합니다.");								
			return false;
		}
		
		
		
		
if(1*$('#mancount').val()+1*$('#oldcount').val()+1*$('#childrencount').val()>=10){
	
	     			
			alert("최대 선택은 9명입니다.");								
			return false;
		}
		
				
		
		
		// 2017.02.23 JCB Add For Check Station - Available Only Seoul/Busan
		if(jQuery("#area_dep option:selected").val()=="선택하세요" ||jQuery("#area_arr option:selected").val()=="선택하세요"){
			alert("지역을 선택해주셔야 예매가 가능합니다.");
			return false;
		}
		if(jQuery("#stn_dep option:selected").val()!="NAT010000"||jQuery("#stn_arr option:selected").val()!="NAT014445"){
			alert("죄송합니다. 현재 서비스 가능 지역이 아닙니다." +
			"현재 가능지역 : 서울(출발) - 부산(도착)");
			console.log(jQuery("#stn_dep option:selected").val()+":"+jQuery("#stn_arr option:selected").val());
			return false;
		}
		jQuery("#resertable").show().empty();


		var ser = jQuery("#reservation").serialize();
		jQuery("#reservationcar").show();	

		jQuery.ajax({
			url:"trainseat.do",
			type: "post",
			data: ser,
			dataType: "json",
			cache: false,
			timeout: 50000,
			success: function(data){	
				if(data == null){
					alert("데이터가 안옴");
					return false;
				}			
				else{

					mancount=data.mancount;						
					oldcount=data.oldcount;
					childrencount=data.childrencount;
					
					
					
					
					manrate=data.man;
					oldrate=data.old;
					childrate=data.child;
					
					
					
										

					jQuery(data.list).each(function(index, item){
						var output = "<tr>";
						output += "<td>"+item.trainnum+"</td>";
						output += "<td>"+item.trainname+"</td>";
						output += "<td>"+item.departsta+"</td>";
						output += "<td>"+item.departtime+"</td>";
						output += "<td>"+item.arrivalsta+"</td>";
						output += "<td>"+item.arrivaltime+"</td>";
						output += "<td>"+item.charge+"<a href='#myModal' class='btn btn-primary' data-toggle='modal' id='clickmodal'>상세정보</a>"+"</td>";
						output += "<td>"+item.seats+"</td>";
						output += "<td><a href='"+getContextPath()+"/selectseat.do?trainnum="+item.trainnum+"'>예매</a></td>";
						output += "</tr>";




						// 문서 객체에 추가
						jQuery("#resertable").append(output);
					});

				}
			},
			error: function(){
				jQuery("#resertable").show().empty();
				jQuery("#resertable").text("에러");


			}
		});

		event.preventDefault();  //에이태크가 폼이랑 서밋의 기본작동및 태그에 명시해둔 각종 기능을 막는 거..예를 들어 display none 기능과 같은..

	});







});

//2017.02.23 19:25 JCB Add For StaionInfo
function getStaionCodes(context, vals){
	// Get Table for Station
	// vals : CityCode
	// context : select Tag context
	// Main Do : Generate Select Option Tags

	// Tag Construction : <option>2</option>

	// Post Data Set

	// Call Station Codes.
	jQuery.ajax({
		url: getContextPath()+"/contents/table/getSttn.do",
		type: "post",
		data: {ctyCode:vals},
		dataType: "json",
		cache: false,
		timeout: 50000,
		success: function(data){

			context.empty();

			if(data == null){
				alert("목록 호출 오류 발생!");
				return false;
			}
			else{
				jQuery(data).each(function(index, item){
					var output = '<option value="'+item.nodeId+'" id="node'+index+'">';
					output += item.nodeName;
					output += '</option>';

					// 문서 객체에 추가
					context.append(output);
				});
			}
		},
		error: function(){
			context.empty();
			var err_out="<option>에러가 터졌네요!!</option>";
			context.append(err_out);
		}
	});

}

function getCityNodes(){
	// Get City Code
	// Main Do : Generate City Names
	// Tag Construction : <option>2</option>

	jQuery.ajax({
		url: getContextPath()+"/contents/table/getCities.do",
		type: "post",
		dataType: "json",
		cache: false,
		timeout: 50000,
		success: function(data){

			jQuery("#area_dep").empty();
			jQuery("#area_arr").empty();

			if(data == null){
				alert("목록 호출 오류 발생!");
				return false;
			}
			else{
				var output = "<option>선택하세요</option>"
					jQuery(data).each(function(index, item){
						output += "<option value='"+item.cityCode;
						output += "'>"+item.cityName;
						output += "</option>";
					});
				// 문서 객체에 추가
				jQuery("#area_dep").append(output);
				jQuery("#area_arr").append(output);
			}
		},
		error: function(){
			jQuery("#area_dep").empty();
			jQuery("#area_arr").empty();

			var out_err="<option>지역정보 로딩실패</option>";

			jQuery("#area_dep").append(out_err);
			jQuery("#area_arr").append(out_err);
		}
	});

}

function getContextPath(){
	var offset=location.href.indexOf(location.host)+location.host.length;
	var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
	return ctxPath;
}