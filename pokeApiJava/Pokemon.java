package pokeApiJava;

import java.util.*;

public class Pokemon {

	private String nombre;
	private int altura;
	private int peso;
	private List<String> tipo;
	private List<String> habilidad;
	public Pokemon(String nombre, int altura, int peso, List<String> tipo,List<String> habilidad) {
		
		this.nombre = nombre;
		this.altura = altura;
		this.peso = peso;
		this.tipo = tipo;
		this.habilidad=habilidad;
	}
	
	public void mostrarInfo() {
		System.out.println("Nombre: "+this.nombre);
		System.out.println("Altura: "+this.altura);
		System.out.println("Peso: "+this.peso);
		System.out.println("Tipo: "+ String.join(",", tipo));
		System.out.println("Habilidad: "+ String.join(",", habilidad));
	}
	
	
}
