package com.stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.Test;

public class StreamTest {
	
	@Test
	public void streamVazioTest() {
		Stream stream = new StreamImpl("");
		assertThat(stream.hasNext()).isEqualTo(false);
		Throwable t = catchThrowable(() -> {stream.getNext();});
		assertThat(t).isInstanceOfAny(IndexOutOfBoundsException.class);
	}
	
	@Test
	public void streamNuloTest() {
		Stream stream = new StreamImpl(null);
		assertThat(stream.hasNext()).isEqualTo(false);
		Throwable t = catchThrowable(() -> {stream.getNext();});
		assertThat(t).isInstanceOfAny(IndexOutOfBoundsException.class);
	}

	@Test
	public void streamHasNextTest() {
		Stream stream = new StreamImpl("abcd");
		assertThat(stream.hasNext()).isEqualTo(true);
		stream.getNext();
		stream.getNext();
		stream.getNext();
		assertThat(stream.hasNext()).isEqualTo(true);
		stream.getNext();
		assertThat(stream.hasNext()).isEqualTo(false);
	}
	
	@Test
	public void streamGetNextTest() {
		Stream stream = new StreamImpl("abcd");
		assertThat(stream.getNext()).isEqualTo('a');
		assertThat(stream.getNext()).isEqualTo('b');
		assertThat(stream.getNext()).isEqualTo('c');
		assertThat(stream.getNext()).isEqualTo('d');
	}
}
