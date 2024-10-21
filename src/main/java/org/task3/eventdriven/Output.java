package org.task3.eventdriven;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Output implements Observer {
	private ArrayList<String> kwicList;

	public ArrayList<String> getKwicList() {
		return kwicList;
	}

	public Output(ArrayList<String> kwicList) {
		this.kwicList = kwicList;
	}

	@Override
	public void toDo() {
		if (kwicList.isEmpty()) {
			ArrayList<String> arrayList = new ArrayList<>();
			arrayList.add("输入的文本为空");
		}
	}
}