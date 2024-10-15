package org.task2.demo3;

public class Main {
	public static void main(String[] args) {
		//创建主题
		KWICSubject kwicSubject = new KWICSubject();
		//创建观察者
		Input input = new Input("D:\\SWPU\\软件体系结构\\input.txt");

		// 先调用input
		kwicSubject.addObserver(input);
		kwicSubject.notifyAllObserver();
		kwicSubject.deleteObserver(input);

		Shift shift = new Shift(input.getLineTxt());
		Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
		Output output = new Output(alphabetizer.getKwicList(), "D:\\SWPU\\软件体系结构\\output3.txt");

		// 将观察者加入主题
		kwicSubject.addObserver(shift);
		kwicSubject.addObserver(alphabetizer);
		kwicSubject.addObserver(output);
		// 逐步调用各个观察者
		kwicSubject.startKWIC();
	}
}