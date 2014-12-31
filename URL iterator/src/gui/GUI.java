package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import scripts.SendfilePl;
import searchEngine.SearchEngine;

public class GUI extends JFrame implements ActionListener {

	private final int WIDTH = 450;
	private final int HEIGHT = 400;
	private final int GRID_HEIGHT = 10;
	private final int GRID_WIDTH = 2;

	private final String WINDOW_TITLE = "URL Iterator 0.0.3v";
	private final String htmlBody = "<!doctype html><html><head><title> UrlIterator Results </title></head><body><ol>";
	private final String htmlBodyEnd = " </body></html></ol>";

	JTextField TFlinkFirstPart = new JTextField(15);
	JTextField TFfindFile = new JTextField(15);
	public static JTextField TFstartingIndex = new JTextField(15);
	public static JTextField TFendingIndex = new JTextField(15);
	public static JTextField TFlocation = new JTextField(15);

	JLabel LBLlinkL = new JLabel("First part of the url: ", SwingConstants.LEFT);
	JLabel LBLfindFile = new JLabel("Find file:  ", SwingConstants.LEFT);
	JLabel LBLstart = new JLabel("Start with index: ", SwingConstants.LEFT);
	JLabel LBLend = new JLabel("Stop with index: ", SwingConstants.LEFT);
	JLabel LBLlocation = new JLabel("Path of the log file: ", SwingConstants.LEFT);

	JButton BTgetFileNameAndUrl = new JButton("Get names + url");
	JButton Search = new JButton("Search: ");

	JTextArea TAlog = new JTextArea(6, 2);

	public GUI() {
		pack();
		getContentPane().add(new panel());
		setLayout(new GridLayout(GRID_HEIGHT, GRID_WIDTH));
		setLocationRelativeTo(null);
		setTitle(WINDOW_TITLE);
		setSize(WIDTH, HEIGHT);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		BTgetFileNameAndUrl.addActionListener(this);
		Search.addActionListener(this);
		TFstartingIndex.addActionListener(this);
		TFendingIndex.addActionListener(this);
		TFlocation.addActionListener(this);

	}

	public class panel extends JPanel {
		public panel() {
			getContentPane().add(LBLlinkL, BorderLayout.CENTER);
			getContentPane().add(TFlinkFirstPart, BorderLayout.CENTER);
			getContentPane().add(LBLstart, BorderLayout.CENTER);
			getContentPane().add(TFstartingIndex, BorderLayout.CENTER);
			getContentPane().add(LBLend, BorderLayout.CENTER);
			getContentPane().add(TFendingIndex, BorderLayout.CENTER);
			getContentPane().add(LBLlocation, BorderLayout.CENTER);
			getContentPane().add(TFlocation, BorderLayout.CENTER);
			getContentPane().add(LBLfindFile, BorderLayout.CENTER);
			getContentPane().add(TFfindFile, BorderLayout.CENTER);
			getContentPane().add(BTgetFileNameAndUrl, BorderLayout.CENTER);
			getContentPane().add(Search, BorderLayout.CENTER);
			getContentPane().add(TAlog, BorderLayout.CENTER);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BTgetFileNameAndUrl) {
			// TODO conditional if sendfile box checked. Add check box
			try {
				SendfilePl.createLog();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
		} else if (e.getSource() == Search) {
			SearchEngine.findFile(TFfindFile.getText());		}
	}

}
