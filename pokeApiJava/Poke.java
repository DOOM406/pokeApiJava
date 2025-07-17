package pokeApiJava;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Poke {
	
	public static Pokemon buscarPokemon(String nombre) {
		String url = "https://pokeapi.co/api/v2/pokemon/"+nombre.toLowerCase();
		
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(url))
			.build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		if(response.statusCode()==200) {
			JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
			
			String nombreReal = json.get("name").getAsString();
			int altura = json.get("height").getAsInt();
			int peso = json.get("weight").getAsInt();
			
			List<String> tipos = new ArrayList<>();
			
			JsonArray tiposArray = json.getAsJsonArray("types");
			
			for(JsonElement tipoElem : tiposArray) {
				JsonObject tipoObj = tipoElem.getAsJsonObject();
				String tipoNombre = tipoObj
						.getAsJsonObject("type")
						.get("name")
						.getAsString();
				tipos.add(tipoNombre);
			}
			List<String> habilidad = new ArrayList<>();
			
			JsonArray habilidadArray = json.getAsJsonArray("abilities");
			
			for(JsonElement tipoElem : habilidadArray) {
				JsonObject tipoObj = tipoElem.getAsJsonObject();
				String habilidadNombre = tipoObj
						.getAsJsonObject("ability")
						.get("name")
						.getAsString();
				habilidad.add(habilidadNombre);
			}
			
			return new Pokemon(nombreReal, altura, peso, tipos,habilidad);
		}else {
			System.out.println("No se encontro el pokemon xd");
		}
			//
		} catch (Exception e) {
			System.out.println("Error al conectar la api"+e.getMessage());
		}
		return null;
	}
	
}
