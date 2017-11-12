package com.stream;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;

public class EncontrarVogalNaoRepetidaTest {

	@Test
	public void streamVazioTest() {
		Stream stream = new StreamImpl("");
		Optional<Character> vogal = VogalNaoRepetida.procuraVogalNaoRepetida(stream);
		assertThat(vogal).isEmpty();
	}
	
	@Test
	public void streamComStringNulaTest() {
		Stream stream = new StreamImpl("");
		Optional<Character> vogal = VogalNaoRepetida.procuraVogalNaoRepetida(stream);
		assertThat(vogal).isEmpty();
	}
	
	@Test
	public void streamNuloTest() {
		Optional<Character> vogal = VogalNaoRepetida.procuraVogalNaoRepetida(null);
		assertThat(vogal).isEmpty();
	}
	
	@Test
	public void encontraStreamExemploTest() {
		Stream stream = new StreamImpl("aAbBABacafe");
		Optional<Character> vogal = VogalNaoRepetida.procuraVogalNaoRepetida(stream);
		assertThat(vogal.get()).isEqualTo('e');
	}
	
	@Test
	public void streamComMaisDeUmCaracterEncontradoTest() {
		Stream stream = new StreamImpl("aAbBABacafefu");
		Optional<Character> vogal = VogalNaoRepetida.procuraVogalNaoRepetida(stream);
		assertThat(vogal.get()).isEqualTo('e');
	}
}
