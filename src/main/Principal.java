package main;

import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Principal {
	public static void main(String[] args) {
		ApiRequest myApiRequest = new ApiRequest();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca la palabra que desea buscar:");
		String word = sc.next();
		String path = "https://api.dictionaryapi.dev/api/v2/entries/es/" + word;
		try {
			String response = myApiRequest.getRequest(path);
			JSONObject respuesta = (JSONObject) JSONValue.parse(response.toString());
			System.out.println(respuesta.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
