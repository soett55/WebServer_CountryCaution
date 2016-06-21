//맵 구성요소
var map;
var layer;
var infoWindow = new google.maps.InfoWindow(); // InfoWindow

var warninglist = [];
var FT_TableID = 423734;
var FT_Query;

function openIW(FTevent) {
	console.log("openIW()");

	var isocode = FTevent.row['iso_a3'].value;
	// infoWindow.setContent(FTevent.infoWindowHtml);
	// infoWindow.setPosition(FTevent.latLng);
	// var content = FTevent.row['admin'].value + " " +FTevent.row['iso_a3'].value;
	var content = "";
	content += warninginfo_jsonread(isocode);
	content += basicinfo_jsonread(isocode);
	content += callinfo_jsonread(isocode);	

	infoWindow.setOptions(
			{ 
				// content: FTevent.infoWindowHtml,
				content: content,
				position: FTevent.latLng,
				pixelOffset: FTevent.pixelOffset
			});

	infoWindow.open(map);
}

//jsonread
function jsonread() {
	console.log("jsonread start");
	$.ajax({
		type:"GET",
		async: false,
		url:"/warning",
		success:function(json){
			console.log("jsonread start in");
			console.log(json);
			var jsonlen = json.length;
			var list = jQuery.parseJSON(JSON.stringify(json));

			var listLen = list.length;
			var contentStr = "";
			console.log("jsonread start in 1");
			console.log(list);

			for(var i=0; i<listLen; i++){
				warninglist.push("'"+list[i].isocode+"'");
			}
			console.log(warninglist);
		}
	});
	initialize();
}

function basicinfo_jsonread(isocode) {
	console.log("basicinfo_jsonread start");
	var content = "";
	$.ajax({
		type:"GET",
		async: false,
		url:"/basicinfo/"+isocode,
		success:function(json){
			var list = jQuery.parseJSON(JSON.stringify(json));
			content += "<br/><h2>---------------기본 정보---------------</h2><br/>";
			content += list[0].basic;						
		}
	});
	console.log(content);
	return content;
}

function callinfo_jsonread(isocode) {
	console.log("callinfo_jsonread start");
	var content = "";
	$.ajax({
		type:"GET",
		async: false,
		url:"/callinfo/"+isocode,
		success:function(json){
			var list = jQuery.parseJSON(JSON.stringify(json));
			var listLen = list.length;
			content += "<br/><h2>---------------연락처 정보---------------</h2><br/>";

			//content += '<img src="'+list[0].imgUrl+'"  height="42" width="42" >';
			content += list[0].contact;

		}
	});
	console.log(content);
	return content;
}

function warninginfo_jsonread(isocode) {
	console.log("warninginfo_jsonread start");
	var content = "";
	$.ajax({
		type:"GET",
		async: false,
		url:"/warninginfo/"+isocode,
		success:function(json){
			var list = jQuery.parseJSON(JSON.stringify(json));
			var listLen = list.length;
			if(listLen>0){
				content += "<br/><h2>---------------경보 정보---------------</h2><br/>";
				var temp = list[0].attentionNote;
				if(temp != null)
					content += "여행 유의 : "+temp+"<br/>"; 
				var temp = list[0].controlNote;
				if(temp != null)
					content += "여행 자제 : "+temp+"<br/>";
				var temp = list[0].limitNote;
				if(temp != null)
					content += "여행 제한 : "+temp+"<br/>";				
			}
		}
	});
	console.log(content);
	return content;
}

//jsonread end
//initialize start
function initialize() {
	console.log('initial');

	var mapOptions = {
			zoom: 2,
			center: new google.maps.LatLng(30.55, -200.2), // Map center
			mapTypeId: google.maps.MapTypeId.ROADMAP
	};

	map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);

	/*
	var CountryName = 'United States of America';
	var FT_Query = "SELECT 'kml_4326' FROM "+FT_TableID+" WHERE 'admin' = '"+CountryName+"';";
	var FT_Options = { suppressInfoWindows: true, query:FT_Query, options:optionvar};

	layer = new google.maps.FusionTablesLayer({
		suppressInfoWindows: true,
		query: {
			select: 'kml_4326',
			from: FT_TableID,
			where: "'admin' = '"+CountryName+"'"
		},
		styles: [{
			polygonOptions: {
				fillColor: '#00FF00',
				fillOpacity: 0.3
			}
		}]
	});
	var bluestyles = [
	                  {
	                	  polygonOptions: {
	                		  fillOpacity: 0.2,
	                		  fillColor:"#0000FF",
	                		  strokeWeight: 1,
	                	  }
	                  }	
	                  ];

	layer.set('styles', bluestyles);
	layer.setMap(map);
	 */
	
	renewal();
}
//initialize end

function renewal(){
	console.log('renewal');
//	layer.setMap(null);

	var CountriesQuery = warninglist.join(",");
	var wherestr = "'iso_a3' IN (" + CountriesQuery + ')';
	console.log(wherestr);

	layer = new google.maps.FusionTablesLayer({
		suppressInfoWindows: true,
		query: {
			select: 'kml_4326',
			from: FT_TableID
		},
		styles: [
		         {
		        	 polygonOptions: {
		        		 fillColor: '#00FF00',
		        		 fillOpacity: 0.3
		        	 }
		         },
		         {
		        	 where: wherestr,
		        	 polygonOptions: {
		        		 fillColor: '#FFFF00',
		        		 fillOpacity: 0.3
		        	 }
		         }
		         ]
	});

	console.log(layer);

	/*
	var FT_Query = "SELECT 'kml_4326' FROM "+FT_TableID+" WHERE 'sovereignt' IN("+CountriesQuery+");";
	console.log(FT_Query);
	layer.setQuery(FT_Query);
	 */
	layer.setMap(map);
	google.maps.event.addListener(layer, 'click', openIW);

}
jsonread();

//google.maps.event.addDomListener(window, 'load', initialize);

