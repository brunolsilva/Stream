package com.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Classe responsável pela lógica para encontrar a primeira vogal não repetida que atende os requisitos
 *
 */
public class VogalNaoRepetida {
	
	private static final List<Character> VOGAIS = Collections.unmodifiableList(Arrays.asList('a', 'e', 'i', 'o', 'u'));
	
	public static void main(String[] args) {
		Stream stream = new StreamImpl("aAbBABacafe");
		Optional<Character> vogalEncontrada = VogalNaoRepetida.procuraVogalNaoRepetida(stream);
		if (vogalEncontrada.isPresent()) {
			System.out.println("Vogal encontrada: " + vogalEncontrada.get());
		} else {
			System.out.println("Vogal não encontrada");
		}
	}
	
	/**
	 * Retorna um Optional com o caractere encontrado
	 * 
	 * @param stream
	 * @return Um Optional com o caracter encontrado
	 */
	public static Optional<Character> procuraVogalNaoRepetida(Stream stream) {
		if(stream == null) {
			return Optional.empty();
		}

		List<Character> vogaisRepetidas = new LinkedList<>();
		List<Character> vogaisNaRegra = new LinkedList<>();
		char ultimo = '.', penultimo = '.';
		
		while (stream.hasNext()) {
			char caracterCorrente = Character.toLowerCase(stream.getNext());

			if (vogaisRepetidas.contains(caracterCorrente)) {
				vogaisNaRegra.remove((Character) caracterCorrente);
			} else {
				if(isVogal(caracterCorrente)) {
					vogaisRepetidas.add(caracterCorrente);
				}

				if(isVogal(caracterCorrente) && isConsoante(ultimo) && isVogal(penultimo)) {
					vogaisNaRegra.add(caracterCorrente);
				}
			}
			
			penultimo = ultimo;
			ultimo = caracterCorrente;
		}

		return vogaisNaRegra.stream().findFirst();
	}
	
	private static boolean isVogal(char caracterCorrente) {
		return VOGAIS.contains(caracterCorrente);
	}
	
	private static boolean isConsoante(char caracterCorrente) {
		return !VOGAIS.contains(caracterCorrente);
	}
}
