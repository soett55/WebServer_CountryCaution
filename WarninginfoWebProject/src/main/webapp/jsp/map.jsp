<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<style>
  body { font-family: Arial, sans-serif; }
  #map_canvas { height: 600px; width: 1000px; }
</style>

<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script> 
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

</head>
<body>	
	<div id="p1" style="background-color:rgba(0,255,0,0.3);  display: inline-block;	">안전한 나라들(Safe Countries)</div>
	<div id="p2" style="background-color:rgba(255,255,0,0.3);   display: inline-block;	">여행 경보 나라들(Attention Countries)</div>
	<br/>
	<div id="p2" style="background-color:rgba(1,1,1,0.3);   display: inline-block;	">나라를 누르면 정보창이 열립니다.</div>
	<div id="map_canvas"></div>
	<script type="text/javascript" src="js/googlemap.js"></script>
</body>




<!--
<button onclick="basicinfo_jsonread('RUS')">basic</button>
<button onclick="callinfo_jsonread('RUS')">call</button>

<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCSBUMk0UocFHRaYLQKRQzp-SVvGq3Mvc0&callback=initMap">
</script>
-->
</html>