package org.task3.eventdriven;

import java.util.ArrayList;

public class Work {
	public static ArrayList<String> doWork(String filePath) {
		//创建主题
		KWICSubject kwicSubject = new KWICSubject();
		//创建观察者
		Input input = new Input(filePath);

		// 先调用input
		kwicSubject.addObserver(input);
		kwicSubject.notifyAllObserver();
		kwicSubject.deleteObserver(input);

		Shift shift = new Shift(input.getLineTxt());
		Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
		Output output = new Output(alphabetizer.getKwicList());

		// 将观察者加入主题
		kwicSubject.addObserver(shift);
		kwicSubject.addObserver(alphabetizer);
		kwicSubject.addObserver(output);
		// 逐步调用各个观察者
		kwicSubject.startKWIC();

		return output.getKwicList();
	}
}