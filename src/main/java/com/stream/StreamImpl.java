package com.stream;

/**
 * Implementação da classe Stream
 *
 */
public class StreamImpl implements Stream {

	private String chars;
	private int index = 0;
	private int size;

	public StreamImpl(String chars) {
		if(chars == null) {
			chars = "";
		}
		this.chars = chars;
		this.size = chars.length();
	}

	/**
	 * 
	 */
	@Override
	public char getNext() throws IndexOutOfBoundsException {
		return chars.charAt(index++);

	}

	/**
	 * a
	 */
	@Override
	public boolean hasNext() {
		return index < size;
	}
}
