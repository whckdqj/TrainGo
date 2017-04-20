/**
 * Table Handler
 */
jQuery(document).ready(function(){
	// Get City
	getNodes(jQuery("#stn_dep"), "NAT010000");
	getNodes(jQuery("#stn_arr"), "NAT014445");
	
	/* Picker */
	jQuery("#dept_time").on("click", function(){
	    showPicker(jQuery("#pickDate"));
	});
	
	jQuery("#table_form").on("submit", function(event){
		// Not Select - Error
		if(jQuery("#area_dep option:selected").val()=="선택하세요"){
			jQuery("#area_dep").focus();
			event.preventDefault();
			return false;
		}
		if(jQuery("#area_arr option:selected").val()=="선택하세요"){
			jQuery("#area_arr").focus();
			event.preventDefault();
			return false;
		}
		
		var ser = jQuery("#table_form").serialize();
		console.log(ser);
		jQuery("#timeTable").show();
		jQuery.ajax({
			url: getContextPath()+"/table/getStationInfoTable.do",
			type: "post",
			data: ser,
			dataType: "json",
			cache: false,
			timeout: 50000,
			success: function(data){
			    // List-Up Map
	            var theList = data.list;
	            
				jQuery("#targetTable").show().empty();
				
				if(data == null){
					alert("목록 호출 오류 발생!");
					return false;
				}
				else{
					jQuery(theList).each(function(index, item){
						var output = "<tr>";
						output += "<td>"+item.depPlaceName+"</td>";
						output += "<td>"+item.arrPlaceName+"</td>";
						output += "<td>"+item.trainGradeName+"</td>";
						output += "<td>"+item.depPlandTime+"</td>";
						output += "<td>"+item.arrPlandTime+"</td>";
						output += "<td>"+item.adultCharge+"</td>";
						output += "</tr>";
						
						// 문서 객체에 추가
						jQuery("#targetTable").append(output);
					});
				}
			},
			error: function(){
				jQuery("#timeTable").show().empty();
				jQuery("#timeTable").text("네트워크 오류");
			}
		});
		
		event.preventDefault();
	});
	
	// Admin Update
	jQuery("#admin_form").on("submit", function(event){
        // Not Select - Error
        if(jQuery("#table_update option:selected").val()=="0"){
            jQuery("#table_update").focus();
            event.preventDefault();
            return false;
        }
        
        var ser = jQuery("#admin_form").serialize();

        jQuery.ajax({
            url: getContextPath()+"/pageAdmin.do",
            type: "post",
            data: ser,
            dataType: "json",
            cache: false,
            timeout: 50000,
            success: function(data){
                // Get Bean
                var theMap = data.adminInfo;                
                
                if(data == null){
                    alert("목록 호출 오류 발생!");
                    return false;
                }
                else{
                    var context = "#"+theMap.tableName+"_update";
                    
                    // 문서 객체에 추가
                    jQuery("[id*=LIST_up]").text("");
                    jQuery(context).text("업뎃!");
                }
            },
            error: function(){
                jQuery("#updateTable").append("<div>(네트워크 오류)</div>");
            }
        });
        
        event.preventDefault();
    });
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
    console.log("Activate ShowPick~!!");
    context.show("slide", {}, 500, function(){
        context.datepicker({
            showMonthAfterYear:true
            ,dateFormat: "yy-mm-dd"
            ,minDate:0, maxDate:"+2D"
            ,defaultDate: +0
            ,showAnim: "slide"
        });
    });
}
// Hide Picker
function hidePicker(context){
    console.log("Activate HidePick~!!");
    context.empty();
    context.hide();
}

function getContextPath(){
    var offset=location.href.indexOf(location.host)+location.host.length;
    var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
    return ctxPath;
}