package com.pss.parser;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.pss.object.Basicinfo;
import com.pss.object.Callinfo;
import com.pss.repository.BasicinfoRepository;
import com.pss.repository.CallinfoRepository;
import com.pss.repository.WarningRepository;

public class Parse_Method {
		
	public void ParseStart(
			WarningRepository warn_repository,BasicinfoRepository basic_repository,
			CallinfoRepository call_repository){
		/*
		// 1. warning
		Warning_Country Warning_obj = new Warning_Country();
		Warning_obj.Parse();
		ArrayList<Warning> warning_arraylist = Warning_obj.getWarning_arraylist();	
		for(Warning obj : warning_arraylist){
			warn_repository.save(obj);			
		}
		 */
		
		
		// 2. call
		CallNunber_Country callnumber_obj = new CallNunber_Country();
		callnumber_obj.Parse();
		ArrayList<Callinfo> call_array = callnumber_obj.getCallnumber_arraylist();
		for(Callinfo obj : call_array){
			System.out.println(obj.toString());
			call_repository.save(obj);
		}

		// 3. basic
		BasicInfo_Country basicinfo_obj = new BasicInfo_Country();
		basicinfo_obj.Parse_BasicInfo();
		ArrayList<Basicinfo> basicinfo_arraylist = basicinfo_obj.getBasicinfo_arraylist();
		for(Basicinfo obj : basicinfo_arraylist){
			System.out.println(obj.toString());
			basic_repository.save(obj);
		}
		
	}

	public String GetWebString(String urlstr, String key,String isocode) throws IOException {
//		String key = "J2UXMfiSPxMk2YYBo9rNEG47s7fvy0GxhNmqM%2Bdf6STlt1oSGcfY5Ej9EKxnfmaT4Ph5uyRp9aYcmHG60sIA8Q%3D%3D";
//		String urlstr = "http://apis.data.go.kr/1262000/CountryBasicService/getCountryBasicList";
		
		StringBuilder urlBuilder = new StringBuilder(urlstr); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8")+ "=" + key); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("isoCode1","UTF-8")+ "=" + isocode); /*Service Key*/
//		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*검색건수*/
//		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
		
		System.out.println(urlBuilder.toString());
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));			
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(),"UTF-8"));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();		
				
		return sb.toString();
	}

}
