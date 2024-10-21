package org.task3.pipefilter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Work {
	public static ArrayList<String> doWork(String filePath) throws IOException {
		File inFile = new File(filePath);
		ArrayList<String> resultList = new ArrayList<>();
		Pipe pipe1 = new Pipe();
		Pipe pipe2 = new Pipe();
		Pipe pipe3 = new Pipe();
		Input input = new Input(inFile, pipe1);
		Shift shift = new Shift(pipe1, pipe2);
		Alphabetizer alphabetizer = new Alphabetizer(pipe2, pipe3);
		Output output = new Output(resultList, pipe3);
		input.transform();
		shift.transform();
		alphabetizer.transform();
		output.transform();
		return resultList;
	}
}