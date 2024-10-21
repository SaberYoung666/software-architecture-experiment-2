package org.task3.pipefilter;

import java.io.IOException;
import java.util.ArrayList;

public class Output extends Filter {
	private final ArrayList<String> resultList;

	public Output(ArrayList<String> resultList, Pipe input) {
		super(input, null);
		this.resultList = resultList;
	}

	@Override
	protected void transform() throws IOException {
		String line;
		while (input.hashNextLine()) {
			resultList.add(input.readerLine());
		}
		input.closeReader();
		if (resultList.isEmpty()) {
			resultList.add("输入的文本为空");
		}
	}
}

