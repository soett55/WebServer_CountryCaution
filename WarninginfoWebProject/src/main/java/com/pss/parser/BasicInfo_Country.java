package com.pss.parser;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pss.object.Basicinfo;



public class BasicInfo_Country {
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
	private ArrayList<Basicinfo> basicinfo_arraylist; 

	public BasicInfo_Country() {
		basicinfo_arraylist = new ArrayList<Basicinfo>();
	}

	public ArrayList<Basicinfo> getBasicinfo_arraylist() {
		return basicinfo_arraylist;
	}

	public void getDataFromWeb(String data,String isocode) throws IOException{
		Basicinfo basicInfo_object;

		Document docs = Jsoup.parse(data);
		Elements items = docs.getElementsByTag("item");        
		for(Element item : items) {
			//String[] nodes = { item.nodeName(), item.text() };
			System.out.println(item.nodeName());
			String basic = null;
									
			Elements temps1 = item.getElementsByTag("basic");
			for(Element temp1 : temps1){
				basic = temp1.text();
			}

			basicInfo_object = new Basicinfo(isocode,basic);
			System.out.println(basicInfo_object.toString());
			basicinfo_arraylist.add(basicInfo_object);
		}		
	}

	public void Parse_BasicInfo(){
		Parse_Method parse_obj = new Parse_Method();
		String urlstr = "http://apis.data.go.kr/1262000/CountryBasicService/getCountryBasicList";
		String key = "J2UXMfiSPxMk2YYBo9rNEG47s7fvy0GxhNmqM%2Bdf6STlt1oSGcfY5Ej9EKxnfmaT4Ph5uyRp9aYcmHG60sIA8Q%3D%3D";

		String result = "";
		try {
			
			for(int i=0;i<IsoCodeList.length;i++){
				result = parse_obj.GetWebString(urlstr, key,IsoCodeList[i]);
				System.out.println("[*]b"+i);
				getDataFromWeb(result, IsoCodeList[i]);				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
