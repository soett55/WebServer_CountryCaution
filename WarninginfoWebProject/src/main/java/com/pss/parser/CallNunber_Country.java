package com.pss.parser;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pss.object.Callinfo;

public class CallNunber_Country {
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
	private ArrayList<Callinfo> callnumber_arraylist;

	public ArrayList<Callinfo> getCallnumber_arraylist() {
		return callnumber_arraylist;
	}

	public CallNunber_Country() {
		callnumber_arraylist = new ArrayList<Callinfo>();
	}

	public void getDataFromWeb(String data,String isocode) throws IOException{
		Callinfo callnumber_obj;
		Document docs = Jsoup.parse(data);
		Elements items = docs.getElementsByTag("item");
		for(Element item : items) {
			String [] callobj = new String[5];
			//String[] nodes = { item.nodeName(), item.text() };
			//System.out.println(item.nodeName() +" "+item.text());
			
			Elements temps0 = item.getElementsByTag("contact");
			for(Element temp0 : temps0){
				callobj[0] = temp0.text();
			}

			Elements temps1 = item.getElementsByTag("continent");
			for(Element temp1 : temps1){
				callobj[1] = temp1.text();
			}

			Elements temps2 = item.getElementsByTag("countryName");
			for(Element temp2 : temps2){       
				callobj[2] = temp2.text();
			}
			Elements temps3 = item.getElementsByTag("countryEnName");
			for(Element temp3 : temps3){
				callobj[3] = temp3.text();
			}
			Elements temps4 = item.getElementsByTag("imgUrl");
			for(Element temp4 : temps4){
				callobj[4] = temp4.text();
			}
			
			callnumber_obj = new Callinfo(isocode,callobj[0],callobj[1],callobj[2],callobj[3],callobj[4]);
			callnumber_arraylist.add(callnumber_obj);
		}
	}

	public void Parse(){
		Parse_Method parse_obj = new Parse_Method();
		String urlstr = "http://apis.data.go.kr/1262000/ContactService/getContactList";
		String key = "J2UXMfiSPxMk2YYBo9rNEG47s7fvy0GxhNmqM%2Bdf6STlt1oSGcfY5Ej9EKxnfmaT4Ph5uyRp9aYcmHG60sIA8Q%3D%3D";

		String result = "";
		try {
			for(int i=0;i<IsoCodeList.length;i++){
				result = parse_obj.GetWebString(urlstr, key,IsoCodeList[i]);
				System.out.println("[*]c"+i);
				getDataFromWeb(result, IsoCodeList[i]);				
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
