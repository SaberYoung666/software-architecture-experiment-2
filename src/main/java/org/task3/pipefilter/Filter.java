package org.task3.pipefilter;

import java.io.IOException;

public abstract class Filter {
	protected Pipe input;
	protected Pipe output;

	public Filter(Pipe input, Pipe output) {
		this.input = input;
		this.output = output;
	}

	protected abstract void transform() throws IOException;
}