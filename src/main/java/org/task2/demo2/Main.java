package org.task2.demo2;

public class Main {
	public static void main(String[] args) {
		Input input = new Input();
		input.input("D:\\SWPU\\软件体系结构\\input.txt");
		Shift shift = new Shift(input.getLineTxt());
		shift.shift();
		Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
		alphabetizer.sort();
		Output output = new Output(alphabetizer.getKwicList());
		output.output("D:\\SWPU\\软件体系结构\\output2.txt");
	}
}