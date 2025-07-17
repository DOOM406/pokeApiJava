package pokeApiJava;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Ingresa el nombre del pokemon: ");
			String nombre = sc.nextLine();
			if(nombre.equals("")) {break;} // "" to break that while
			Pokemon pokemon = Poke.buscarPokemon(nombre);
			
			if(pokemon!=null) {
				pokemon.mostrarInfo();
			}
		}
		sc.close();
		
	}

}
