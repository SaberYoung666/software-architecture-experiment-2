package org.task3.objectoriented;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Output {
	private ArrayList<String> kwicList;

	public Output(ArrayList<String> kwicList) {
		this.kwicList = kwicList;
	}

	public ArrayList<String> output() {
		if (!kwicList.isEmpty()) {
			return kwicList;
		} else {
			ArrayList<String> arrayList = new ArrayList<>();
			arrayList.add("输入的文本为空");
			return arrayList;
		}
	}
}

