package org.task3.eventdriven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input implements Observer {

	private ArrayList<String> lineTxt = new ArrayList<String>();
	private String fileName;

	public Input(String fileName) {
		this.fileName = fileName;
	}

	public ArrayList<String> getLineTxt() {
		return lineTxt;
	}

	@Override
	public void toDo() {
		BufferedReader inputFile = null;
		try {
			inputFile = new BufferedReader(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String line;
		try {
			while ((line = inputFile.readLine()) != null) {
				lineTxt.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

