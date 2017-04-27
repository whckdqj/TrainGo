/**
 * Table Handler
 */
jQuery(document).ready(function(){
	
	// Admin Update
    jQuery.ajax({
        url: getContextPath()+"/board/faqBoard/miniFaq.do",
        type: "post",
        data: {},
        dataType: "json",
        cache: false,
        timeout: 50000,
        success: function(data){
            // Get Bean
            var theMap = data.faqList;                
            
            if(data == null){
                alert("목록 호출 오류 발생!");
                return false;
            }
            else{
                var output = "";
                
                output = "<td>"+theMap.num+"</td>";
                output = "<td>"+theMap.faq_title+"</td>";
                output = "<td>"+theMap.id+"</td>";
                output = "<td>"+theMap.register+"</td>";
                
                // 문서 객체에 추가
                jQuery("#faq_mini").empty();
                jQuery("#faq_mini").text("업뎃!");
            }
        },
        error: function(){
            jQuery("#updateTable").append("<div>(네트워크 오류)</div>");
        }
    });
    
    event.preventDefault();
});

function getStaionCodes(context, vals){
	// Get Table for Station
	// vals : CityCode
	// context : select Tag context
	// Main Do : Generate Select Option Tags
	
	// Tag Construction : <option>2</option>
	
	// Post Data Set
	
	// Call Station Codes.
	jQuery.ajax({
		url: getContextPath()+"/table/getTrainSttnList.do",
		type: "post",
		data: {ctyCode:vals},
		dataType: "json",
		cache: false,
		timeout: 50000,
		success: function(data){
		    // List-Up Map
		    var theList = data.list;
			
			context.empty();
			
			if(data == null){
				alert("목록 호출 오류 발생!");
				return false;
			}
			else{
				jQuery(theList).each(function(index, item){
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

/* 2017.04.20 19:41 - JCB Add for Mini-Resv */
function getNodes(context, selNodeId){
    // Get Station Node for Mini-Resv
    // Main Do : Mini Resv Selector Construction
    // Tag Construction : <option>2</option>
    
    jQuery.ajax({
        url: getContextPath()+"/table/getCtyCode.do",
        type: "post",
        dataType: "json",
        cache: false,
        timeout: 50000,
        success: function(data){
            // List-Up the HashTable
            var theList = data.list;
            
            context.empty();
            
            if(theList == null){
                alert("목록 호출 오류 발생!");
                return false;
            }
            else{
                
                jQuery(theList).each(function(index, item){
                    var output = '';
                    output += "<optgroup label='"+item.cityName+"' data-ctyCode='"+item.cityCode+"'>";
                    jQuery.ajax({
                        url: getContextPath()+"/table/getTrainSttnList.do",
                        type: "post",
                        data: {ctyCode:item.cityCode},
                        dataType: "json",
                        cache: false,
                        timeout: 50000,
                        success: function(data){
                            
                            if(data == null){
                                alert("SttnCode : 목록 호출 오류 발생!");
                                return false;
                            }
                            else{
                                jQuery(data.list).each(function(index, item){
                                    output += '<option value="'+item.nodeId+'" class="nodeIds" '
                                    if(item.nodeId == selNodeId){
                                        output += 'selected="selected">';
                                    }
                                    else{
                                        output += '>';
                                    }
                                    output += item.nodeName;
                                    output += '</option>';
                                });
                                output += "</optgroup>";
                                context.append(output);
                            }
                        },
                        error: function(){
                            console.log("SttnCode : Error");
                        }
                    });
                    
                });
                // 문서 객체에 추가
                /*jQuery("#stn_dep").append(output);
                jQuery("#stn_arr").append(output);*/
            }
        },
        error: function(){
            context.empty();
            
            var out_err="<option>지역정보 로딩실패</option>";
            
            context.append(out_err);
        }
    });
    
}

function getCityNodes(){
	// Get City Code
	// Main Do : Generate City Names
	// Tag Construction : <option>2</option>
	
	jQuery.ajax({
		url: getContextPath()+"/table/getCtyCode.do",
		type: "post",
		dataType: "json",
		cache: false,
		timeout: 50000,
		success: function(data){
			// List-Up the HashTable
		    var theList = data.list;
		    
			jQuery("#stn_dep").empty();
			jQuery("#stn_arr").empty();
			
			if(theList == null){
				alert("목록 호출 오류 발생!");
				return false;
			}
			else{
				var output = '';
				jQuery(theList).each(function(index, item){
					output += "<optgroup label='"+item.cityName+"' data-ctyCode='"+item.cityCode+"'>";
					output += "<option>역 정보 로딩중...</option>";
					output += "</optgroup>";
				});
				// 문서 객체에 추가
				jQuery("#stn_dep").append(output);
				jQuery("#stn_arr").append(output);
			}
		},
		error: function(){
			jQuery("#stn_dep").empty();
			jQuery("#stn_arr").empty();
			
			var out_err="<option>지역정보 로딩실패</option>";
			
			jQuery("#stn_dep").append(out_err);
			jQuery("#stn_arr").append(out_err);
		}
	});
	
}

// Show Picker
function showPicker(context){
    context.show("slide", {}, 500, function(){
        context.datepicker({
            showMonthAfterYear:true
            ,dateFormat: "yy-mm-dd"
            ,minDate:0, maxDate:"+2D"
            ,defaultDate: +0
            ,showAnim: "slide"
            ,autoSize: false
            /*,altField: "#dept_time"*/
            ,onSelect: function(dateText, inst){
                jQuery("#startdate").val("");
                jQuery("#startdate").val(dateText);
                
                hidePicker(context);
            }
        });
    });
}
// Hide Picker
function hidePicker(context){
    context.hide("slide", {}, 500, function(){
        // Do Nothing
    });
}

function getContextPath(){
    var offset=location.href.indexOf(location.host)+location.host.length;
    var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
    return ctxPath;
}