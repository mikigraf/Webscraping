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

import gui.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
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

public class Main {

	// test path on osx = /Users/spejs/Desktop/test.html
	// test path on windows = D:\\test.html

	public static void main(String[] args) {
		new GUI();

	}

}
