package main;

/**
 * Naming conventions: prefixes to the names of objects:
 * JLabel = LBL
 * JTextField = TF
 * 
 * after that continue with naming as usual, starting with small case letters, for example:
 * LBLlinkL
 * 
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main extends JFrame implements ActionListener {

	private final int WIDTH = 400;
	private final int HEIGHT = 400;
	private final int GRID_HEIGHT = 10;
	private final int GRID_WIDTH = 20;

	JTextField TFlinkFirstPart = new JTextField(15);
	JTextField TFlinkSecondPart = new JTextField(15);
	// index of first file -> index of the last file, that should be controlled,
	// endingIndex by default will be set to 2147483647
	JTextField TFstartingIndex = new JTextField(15);
	JTextField TFendingIndex = new JTextField(15);
	JLabel LBLlinkL = new JLabel("First part of the url: ", SwingConstants.LEFT);
	JLabel LBLlinkR = new JLabel("Second part of the url: ", SwingConstants.LEFT);
	JLabel LBLstart = new JLabel("Start with index: ", SwingConstants.LEFT);
	JLabel LBLend = new JLabel("Stop with index: ", SwingConstants.LEFT);
	JLabel LBintervall = new JLabel("How often should be a new file downloaded/checked? In seconds: ", SwingConstants.LEFT);
	JTextField TFintervall = new JTextField(15);
	JLabel LBlocation = new JLabel("Where should be file/log saved? ", SwingConstants.LEFT);
	JButton BTgetFileNameAndUrl = new JButton("Get names + url");
	JButton BTcreateLog = new JButton("Pointless Button");

	JTextArea TAlog = new JTextArea(5, 2);

	public Main() {
		setLocationRelativeTo(null);
		pack();
		init();
		setTitle("Url Iterator 0.0.1v");
		setSize(WIDTH, HEIGHT);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		BTgetFileNameAndUrl.addActionListener(this);
		BTcreateLog.addActionListener(this);
		TFstartingIndex.addActionListener(this);
		TFendingIndex.addActionListener(this);

	}

	public void init() {
		System.out.println("Applet initializing");
		getContentPane().add(new panel());
	}

	public class panel extends JPanel {
		public panel() {
			getContentPane().setLayout(new GridLayout(GRID_HEIGHT, GRID_WIDTH));
			getContentPane().add(LBLlinkL, BorderLayout.CENTER);
			getContentPane().add(TFlinkFirstPart, BorderLayout.CENTER);
			getContentPane().add(LBLlinkR, BorderLayout.CENTER);
			getContentPane().add(TFlinkSecondPart, BorderLayout.CENTER);
			getContentPane().add(LBLstart, BorderLayout.CENTER);
			getContentPane().add(TFstartingIndex, BorderLayout.CENTER);
			getContentPane().add(LBLend, BorderLayout.CENTER);
			getContentPane().add(TFendingIndex, BorderLayout.CENTER);
			getContentPane().add(LBintervall, BorderLayout.CENTER);
			getContentPane().add(TFintervall, BorderLayout.CENTER);
			getContentPane().add(BTgetFileNameAndUrl, BorderLayout.CENTER);
			getContentPane().add(BTcreateLog, BorderLayout.CENTER);
			getContentPane().add(TAlog, BorderLayout.CENTER);
			// getContentPane().add(LBlocation, BorderLayout.CENTER);
		}
	}

	public static void main(String[] args) {

		new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BTgetFileNameAndUrl) {
			Date currentDate = new Date();
			String firstL = TFlinkFirstPart.getText();
			System.out.println(firstL);			
			try {
				PrintWriter logger = new PrintWriter("C:\\urliterator_LOG" + currentDate.toString().replace(":","") + ".txt");
				for (int x = Integer.parseInt(TFstartingIndex.getText()); x < Integer.parseInt(TFendingIndex.getText()); x++) {
					String url = firstL + Integer.toString(x);
					Document doc = Jsoup.connect(firstL + Integer.toString(x)).get();
					Elements fileNames = doc.select("title");
					String names = fileNames.toString();
					String namesWithoutLeftTag = names.replace("<title>", " ");
					String namesWithoutTag = namesWithoutLeftTag.replace("</title>", " ");
					System.out.println(x + " " + namesWithoutTag + " " + url);
					logger.println(x + " " + namesWithoutTag + " " + url);
				}
				logger.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == BTcreateLog) {
			TAlog.setText("Toldya it's pointless");
			}
	}
}
