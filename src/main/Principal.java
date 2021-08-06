package main;

import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Principal {
	public static void main(String[] args) {
		ApiRequest myApiRequest = new ApiRequest();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca la palabra que desea buscar:");
		while (sc.hasNext()) {
			String word = sc.next();
			String path = "https://api.dictionaryapi.dev/api/v2/entries/es/" + word;
			try {
				String response = myApiRequest.getRequest(path);
				JSONArray respuesta = (JSONArray) JSONValue.parse(response.toString());
				JSONObject row = (JSONObject) respuesta.get(0);
				JSONArray meanings = (JSONArray) row.get("meanings");
				JSONObject rowDefinitions = (JSONObject) meanings.get(0);
				JSONArray definitions = (JSONArray) rowDefinitions.get("definitions");
				JSONObject rowDefinitions2 = (JSONObject) definitions.get(0);
				String definition = rowDefinitions2.get("definition").toString();
				System.out.println("Definicion:" + definition);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
