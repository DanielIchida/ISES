package util;

import com.google.gson.Gson;

public class ParserJson {
	
	private Gson gson;
	private static ParserJson parse = new  ParserJson();
	
	public ParserJson() {
		gson  = new Gson();
	}
	
	public static ParserJson getInstace(){
		return parse;
	}
	
	public String read(Object o){
		return gson.toJson(o);
	}

}
