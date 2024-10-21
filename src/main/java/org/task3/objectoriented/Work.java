package org.task3.objectoriented;

import java.util.ArrayList;

public class Work {
	public static ArrayList<String> doWork(String filePath) {
		Input input = new Input();
		input.input(filePath);
		Shift shift = new Shift(input.getLineTxt());
		shift.shift();
		Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
		alphabetizer.sort();
		Output output = new Output(alphabetizer.getKwicList());
		return output.output();
	}
}