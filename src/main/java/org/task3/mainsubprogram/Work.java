package org.task3.mainsubprogram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Work {
	private ArrayList<String> kwicList = new ArrayList<String>();
	private ArrayList<String> lineTxt = new ArrayList<String>();
	private BufferedReader inputFile;

	public static ArrayList<String> doWork(String filePath) {
		Work kwic = new Work();
		kwic.input(filePath);
		kwic.shift();
		kwic.alphabetizer();
		return kwic.output();
	}

	public void input(String fileName) {
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

	public ArrayList<String> output() {
		if (!kwicList.isEmpty()) {
			return kwicList;
		} else {
			ArrayList<String> arrayList = new ArrayList<>();
			arrayList.add("输入的文本为空");
			return arrayList;
		}
	}

	public void shift() {
		//获取每个单词，存入tokens
		Iterator<String> it = lineTxt.iterator();
		while (it.hasNext()) {
			StringTokenizer token = new StringTokenizer(it.next());
			ArrayList<String> tokens = new ArrayList<String>();
			int i = 0;
			//循环添加单词
			int count = token.countTokens();
			while (i < count) {
				tokens.add(token.nextToken());
				i++;
			}
			//切割各个单词，不断改变起始值和利用loop实现位移。
			for (i = 0;i < count;i++) {
				StringBuffer lineBuffer = new StringBuffer();
				int index = i;
				for (int f = 0;f < count;f++) {
					//从头继续位移
					if (index >= count) index = 0;
					//存入StringBuffer
					lineBuffer.append(tokens.get(index));
					lineBuffer.append(" ");
					index++;
				}
				String tmp = lineBuffer.toString();
				kwicList.add(tmp);
			}
		}
	}

	public void alphabetizer() {
		Collections.sort(this.kwicList, new AlphabetizerComparator());
	}

	private class AlphabetizerComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			if (o1 == null && o2 == null) {
				throw new NullPointerException();
			}
			int compareValue = 0;
			char o1c = o1.toLowerCase().charAt(0); //忽略大小写
			char o2c = o2.toLowerCase().charAt(0); //忽略大小写
			compareValue = o1c - o2c;
			return compareValue;
		}
	}
}

