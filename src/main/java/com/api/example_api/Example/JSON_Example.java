package com.api.example_api.Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.api.example_api.model.Data;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSON_Example {
	public static Data getData(String url) throws ClientProtocolException, IOException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		try {
		httpGet.addHeader("accept","application/json");
		HttpResponse response = httpClient.execute(httpGet);
		String data = readData(response);
		Gson gson = new Gson();
		return gson.fromJson(data, Data.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Data> getDataList(String url) throws ClientProtocolException, IOException {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("accept","application/json");
		HttpResponse response = httpClient.execute(httpGet);
		String data = readData(response);
		Gson gson = new Gson();
		Type type = new TypeToken<List<Data>>(){}.getType();
		return gson.fromJson(data, type);
	}
	
	public static String readData(HttpResponse httpResponse) throws IOException {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			StringBuffer buffer = new StringBuffer();
			char[] dataLength = new char[1024];
			int read;
			while((read = bufferedReader.read(dataLength)) != -1) {
				buffer.append(dataLength, 0, read);
			}
			return buffer.toString();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bufferedReader != null) {
				bufferedReader.close();
			}
		}
		return null;
	}
	public static void main(String[] args) {
		try {
			Data data = getData("https://reqres.in/api/users?page=2");
			System.out.println(data);
			//List<User> s = data.getData();
			//System.out.println(s.get(0).getEmail());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}