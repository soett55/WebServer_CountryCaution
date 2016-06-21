package com.pss.parser;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pss.object.Warning;

public class Warning_Country {
	private String[] IsoCodeList = {
			"ALA","AFG","ALB","DZA","ASM","AND","AGO","AIA","ATA",
			"ATG","ARG","ARM","ABW","AUS","AUT","AZE","BHS","BHR",
			"BGD","BRB","BLR","BEL","BLZ","BEN","BMU","BTN","BOL",
			"BIH","BWA","BVT","BRA","IOT","BRN","BGR","BFA","BDI",
			"KHM","CMR","CAN","CPV","CYM","CAF","TCD","CHL","CHN",
			"CXR","CCK","COL","COM","COD","COG","COK","CRI","CIV",
			"HRV","CUB","CYP","CZE","DNK","DJI","DMA","DOM","ECU",
			"EGY","SLV","GNQ","ERI","EST","ETH","FLK","FRO","FJI",
			"FIN","FRA","GUF","PYF","ATF","GAB","GMB","GEO","DEU",
			"GHA","GIB","GRC","GRL","GRD","GLP","GUM","GTM","GIN",
			"GNB","GUY","HTI","HMD","HND","HKG","HUN","ISL","IND",
			"IDN","IRN","IRQ","IRL","ISR","ITA","JAM","JPN","JOR",
			"KAZ","KEN","KIR","PRK","KOR","KWT","KGZ","LAO","LVA",
			"LBN","LSO","LBR","LBY","LIE","LTU","LUX","MAC","MKD",
			"MDG","MWI","MYS","MDV","MLI","MLT","MHL","MTQ","MRT",
			"MUS","MYT","MEX","FSM","MDA","MCO","MNG","MSR","MAR",
			"MOZ","MMR","NAM","NRU","NPL","NLD","ANT","NCL","NZL",
			"NIC","NER","NGA","NIU","NFK","MNP","NOR","OMN","PAK",
			"PLW","PSE","PAN","PNG","PRY","PER","PHL","PCN","POL",
			"PRT","PRI","QAT","REU","ROU","RUS","RWA","SHN","KNA",
			"LCA","SPM","VCT","WSM","SMR","STP","SAU","SEN","SCG",
			"SYC","SLE","SGP","SVK","SVN","SLB","SOM","ZAF","SGS",
			"ESP","LKA","SDN","SUR","SJM","SWZ","SWE","CHE","SYR",
			"TWN","TJK","TZA","THA","TLS","TGO","TKL","TON","TTO",
			"TUN","TUR","TKM","TCA","TUV","UGA","UKR","ARE","GBR",
			"USA","UMI","URY","UZB","VUT","VAT","VEN","VNM","VGB",
			"VIR","WLF","ESH","YEM","ZMB","ZWE"};
	private ArrayList<Warning> warning_arraylist;

	public ArrayList<Warning> getWarning_arraylist() {
		return warning_arraylist;

	}

	public Warning_Country() {		  
		warning_arraylist = new ArrayList<Warning>();
	}

	public void getDataFromWeb(String data, String isocode) throws IOException{
		Warning warning_object;

		Document docs = Jsoup.parse(data);
		Elements items = docs.getElementsByTag("item");
		

		for(Element item : items) {
			String []country = new String[7];			
			//String[] nodes = { item.nodeName(), item.text() };

			Elements temps0 = item.getElementsByTag("countryEnName");
			for(Element temp0 : temps0){				
				country[0] = temp0.text();
			}			

			Elements temps1 = item.getElementsByTag("continent");
			for(Element temp1 : temps1){
				country[1] = temp1.text();	
			}

			Elements temps2 = item.getElementsByTag("countryName");
			for(Element temp2 : temps2){
				country[2] = temp2.text();
			}

			Elements temps3 = item.getElementsByTag("attentionNote");
			for(Element temp3 : temps3){
				country[3] = temp3.text();
			}
			Elements temps4 = item.getElementsByTag("controlNote");
			for(Element temp4 : temps4){
				country[4] = temp4.text();
			}
			Elements temps5 = item.getElementsByTag("limitaNote");
			for(Element temp5 : temps5){
				country[5] = temp5.text();          
			}
			Elements temps6 = item.getElementsByTag("imgUrl2");
			for(Element temp5 : temps5){
				country[6] = temps6.text();          
			}
			warning_object = new Warning(isocode,country[0],country[1],country[2],
					country[6],country[3],country[4],country[5]);			
			warning_arraylist.add(warning_object);
		}
		//System.out.println(warning_arraylist.toString());
	}

	public void Parse(){
		Parse_Method parse_obj = new Parse_Method();
		String urlstr = " http://apis.data.go.kr/1262000/TravelWarningService/getTravelWarningList";
		String key = "J2UXMfiSPxMk2YYBo9rNEG47s7fvy0GxhNmqM%2Bdf6STlt1oSGcfY5Ej9EKxnfmaT4Ph5uyRp9aYcmHG60sIA8Q%3D%3D";

		String result = "";
		try {
			for(int i=0;i<IsoCodeList.length;i++){
				result = parse_obj.GetWebString(urlstr, key,IsoCodeList[i]);
				getDataFromWeb(result, IsoCodeList[i]);				
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
