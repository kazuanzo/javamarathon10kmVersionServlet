<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK rel="stylesheet" type="text/css" href="css/hotel_serch_screen.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<script>
var num = 12345;

allert(num.toLocaleString(););

$(function() {
 var requestObj = {
		 price : null,
	};
	$("#request").click(function() {
	 	//リクエスト用のオブジェクトに値を詰め込む
		requestObj.price = $("#price").val();
		//JavaScriptのオブジェクトをJSONに変換する
		
  		var requestJson =JSON.stringify(requestObj); 
		  console.log(requestJson);    

	

	// サーブレットからチーム一覧を非同期で取得
	$.getJSON('/javamarathon10km/Javamarathon10kmservelet', {price : requestJson},function(data){
		$("#demo").empty();
		jQuery.each(data,function(i,val)  {
			
			
			 $("#demo").append($("<table>")
					 	.attr({"border":1})
					    
					    
					    .append($("<tr>")
					    .append($("<td>")
					    .attr({"width":100})
					    .text("ホテル名"))
			 			.append($("<td>")
			 			.attr({"width":200})
						.text(data[i].hotelName)))
						
					    .append($("<tr>")
					    .append($("<td>")
					    .text("最寄駅"))
			 			.append($("<td>")
						.text(data[i].nearestStation)))
						
					    .append($("<tr>")
					    .append($("<td>")
					    .text("価格"))
			 			.append($("<td>")
						.text((data[i].price).toLocaleString())))
												
						).append($("<br/>"));
			 
		
		});
		
	});
 	});	 
});

</script>

<title>ホテル検索画面</title>
</head>
<body>

<h1>ホテル検索</h1>

 <FORM action='./Javamarathon10kmservelet' method=get>
一泊料金：<INPUT type='text' id="price"  value=''>以下
<BR>
<INPUT type='button' id="request"  value='検索'>
</FORM>
<div id="demo"></div>    
</body>
</html>