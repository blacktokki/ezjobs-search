package com.example.demo2.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class IndeedCrawler implements Crawler{
	
	@Override
	public List<Map<?,?>> getAutoComp(String keyword) throws Exception{
		String url="https://kr.indeed.com/cmp/_cs/cmpauto?returncmppageurls=1&q="+keyword+"&caret=2&n=5";
		Document doc = Jsoup.connect(url).ignoreContentType(true).get();
		JSONArray arr=(JSONArray)stringParse(doc.text());
		return getAutoComp(arr);
	}
	
	@Override
	public String getCompName() {
		return "name";
	}
	@Override
	public String getIco() {
		return "Indeed";
	}
	
	@Override
	public Map<?,?> getPage(Map<?,?> map) throws Exception{
		JSONObject temp3=(JSONObject)map;
		String code=(String)temp3.get("name");
		String encode=URLEncoder.encode(code,"UTF-8");
		String url="https://kr.indeed.com/cmp/"+encode;
		Document doc = Jsoup.connect(url).get();
		Elements div=doc.select(".cmp-ReviewAndRatingsStory-ratings");
		Map<String,String> map2=new HashMap<>();
		map2.put("CompName", (String) map.get(getCompName()));
		Elements div2,div3;
		div2=div.select(".cmp-ReviewCategory-name");
		div3=div.select(".cmp-ReviewCategory-rating");
		for(int i=0;i<div2.size();i++) {
			map2.put("score"+i, div2.get(i).text());
			map2.put("scoreVal"+i,div3.get(i).text());
		}
		map2.put("url", url);
		return map2;
	}
}
