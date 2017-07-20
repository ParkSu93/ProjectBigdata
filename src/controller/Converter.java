package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson; // 자바 Object를 Json으로 바꿔주고 역으로도 바꿔는 라이브러리를 인포트 했다.

public class Converter {
	private static Gson gson;
	static {
		gson = new Gson();
	}
	
	public static String convertToJson(Object obj) {
		return gson.toJson(obj); // 자바Object를 JSON형태로 바꿔준다. { "name" : value } 이런식으로
	}
	
	public static <T> T convertFromJson(String json, Class<T> type) {//A.class !! 정보를 넣어줘라
		return gson.fromJson(json, type);// JSON형태를 자바 Object형태로 바꿔준다.
	}
	
	public static <T> T convertFromJSONStream(InputStream is, Class<T> type) {
		try {
			Reader reader = new BufferedReader(
					new InputStreamReader(is, "UTF-8"));
			return gson.fromJson(reader, type);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
