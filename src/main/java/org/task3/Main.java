package org.task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends JFrame {

	// 输入文件的路径
	private String filePath;

	// 构造方法
	public Main() {
		String inputText = JOptionPane.showInputDialog(null, "请输入需要进行KWIC索引的文件的路径：");
		// 如果用户输入了路径，则存入filePath
		if (inputText != null && !inputText.trim().isEmpty()) {
			filePath = inputText;
		}

		// 设置窗口标题
		setTitle("经典软件体系结构教学软件");

		// 创建面板，用于放置按钮
		JPanel buttonPanel = new JPanel();
		// 创建选项按钮
		JButton option1Button = new JButton("主程序-子程序体系结构");
		JButton option2Button = new JButton("面向对象体系结构");
		JButton option3Button = new JButton("事件系统体系结构");
		JButton option4Button = new JButton("管道-过滤体系结构");
		// 创建输入框按钮
		JButton inputButton = new JButton("修改文件的路径");
		inputButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 弹出输入框
				String inputText = JOptionPane.showInputDialog(Main.this, "请输入路径:");
				// 如果用户输入了路径，则存入filePath
				if (inputText != null && !inputText.trim().isEmpty()) {
					filePath = inputText;
				}
			}
		});
		buttonPanel.add(inputButton);
		buttonPanel.add(option1Button);
		buttonPanel.add(option2Button);
		buttonPanel.add(option3Button);
		buttonPanel.add(option4Button);

		// 创建图片标签
		JLabel imageLabel = new JLabel();
		imageLabel.setHorizontalAlignment(JLabel.CENTER);
		JScrollPane imageScrollPane = new JScrollPane(imageLabel);

		// 创建图片说明文字标签
		JLabel descriptionLabel = new JLabel();
		descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
		descriptionLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
		descriptionLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // 添加边框以提供间隔

		// 创建一个面板，用于放置图片说明和图片
		JPanel imagePanel = new JPanel(new BorderLayout());
		imagePanel.add(descriptionLabel, BorderLayout.NORTH); // 将说明文字标签放置在北部
		imagePanel.add(imageScrollPane, BorderLayout.CENTER); // 将图片放置在中心

		// 创建文本区域，用于显示说明文字
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		JScrollPane textScrollPane = new JScrollPane(textArea);

		// 创建文本区域，用于显示结果文字
		JTextArea resultArea = new JTextArea();
		resultArea.setEditable(false);
		resultArea.setFont(new Font("Monospaced", Font.BOLD, 16));
		JScrollPane resultScrollPane = new JScrollPane(resultArea);

		// 创建一个面板，用于放置图片和文本区域
		JPanel bottomPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weighty = 1.0;
		// 设置第一列的权重
		gbc.weightx = 2.0; // 设置列1的权重为2
		gbc.gridx = 0;
		bottomPanel.add(imagePanel, gbc);
		// 设置第二列的权重
		gbc.weightx = 1.0; // 重置权重为1
		gbc.gridx = 1;
		bottomPanel.add(resultScrollPane, gbc);
		// 设置第三列的权重
		gbc.gridx = 2;
		bottomPanel.add(textScrollPane, gbc);

		// 添加按钮监听器
		option1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayImage(imageLabel, "resources/image1.jpg", "主程序-子程序软件体系结构原理图");
				descriptionLabel.setText("主程序-子程序软件体系结构原理图");
				resultArea.setText("用主程序-子程序软件体系结构对输入文件进行KWIC\n索引排序结果为：\n\n");
				ArrayList<String> resultList = org.task3.mainsubprogram.Work.doWork(filePath);
				for (String result : resultList) {
					resultArea.append(result + "\n");
				}
				textArea.setText("""
						源程序的代码结构为：
						-Work (主程序)
						  -input (子程序)
						  -shift (子程序)
						  -Alphabetizer (子程序)
						  -output (子程序)
						
						主程序的代码为：
						Work kwic = new Work();
						kwic.input(filePath);
						kwic.shift();
						kwic.alphabetizer();
						return kwic.output();
						""");
			}
		});

		option2Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayImage(imageLabel, "resources/image2.jpg", "面向对象软件体系结构原理图");
				descriptionLabel.setText("面向对象软件体系结构原理图");
				resultArea.setText("用面向对象软件体系结构对输入文件进行KWIC\n索引排序结果为：\n\n");
				ArrayList<String> resultList = org.task3.objectoriented.Work.doWork(filePath);
				for (String result : resultList) {
					resultArea.append(result + "\n");
				}
				textArea.setText("""
						源程序的代码结构为：
						-Work (主类)
						  -input (输入类)
						  -shift (转换类)
						  -Alphabetizer (排序类)
						  -output (输出类)
						
						主程序的代码为：
						Input input = new Input();
						input.input(filePath);
						Shift shift = new Shift(input.getLineTxt());
						shift.shift();
						Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
						alphabetizer.sort();
						Output output = new Output(alphabetizer.getKwicList());
						return output.output();
						""");
			}
		});

		option3Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayImage(imageLabel, "resources/image3.jpg", "事件系统软件体系结构原理图");
				descriptionLabel.setText("事件系统软件体系结构原理图");
				resultArea.setText("用事件系统软件体系结构对输入文件进行KWIC\n索引排序结果为：\n\n");
				ArrayList<String> resultList = org.task3.eventdriven.Work.doWork(filePath);
				for (String result : resultList) {
					resultArea.append(result + "\n");
				}
				textArea.setText("""
						源程序的代码结构为：
						-Work (主类)
						  -Subject (抽象主题类)
						    -KWICSubject (具体主题类)
						  -Observer (观察者接口)
						    -Input (输入类)
						    -shift (转换类)
						    -Alphabetizer (排序类)
						    -output (输出类)
						
						主程序的代码为：
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
						""");
			}
		});

		option4Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayImage(imageLabel, "resources/image4.jpg", "管道-过滤器软件体系结构原理图");
				descriptionLabel.setText("管道-过滤器软件体系结构原理图");
				resultArea.setText("用管道-过滤器软件体系结构对输入文件进行KWIC\n索引排序结果为：\n\n");
				ArrayList<String> resultList = null;
				try {
					resultList = org.task3.pipefilter.Work.doWork(filePath);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
				for (String result : resultList) {
					resultArea.append(result + "\n");
				}
				textArea.setText("""
						源程序的代码结构为：
						-Work (主类)
						  -Pipe (管道类父类)
						  -Filter (传输类)
						    Input (输入类)
						    	|
						    shift (转换类)
						    	|
						    Alphabetizer (排序类)
						    	|
						    output (输出类)
						
						主程序的代码为：
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
						""");
			}
		});

		// 将面板和文本区域添加到窗口
		add(buttonPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.CENTER);

		// 设置窗口默认最大化
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// 设置窗口关闭操作
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// 在事件分派线程中创建和显示此应用程序的GUI
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// 创建窗口对象
				Main frame = new Main();
				// 显示窗口
				frame.setVisible(true);
			}
		});
	}

	// 显示图片的方法
	private void displayImage(JLabel label, String imagePath, String text) {
		ImageIcon icon = new ImageIcon(imagePath);
		// 检查图片是否存在
		if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
			label.setIcon(icon);
		} else {
			label.setText("图片加载失败");
		}
	}
}
