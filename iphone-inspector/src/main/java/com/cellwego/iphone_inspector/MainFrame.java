package com.cellwego.iphone_inspector;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.cellwego.iphone_inspector.setup.EnvironmentSetup;

/**
 * @author Seiyrikon
 *
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea logArea;
	private JProgressBar progressBar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainFrame ui = new MainFrame();
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("CellWeGo IPhone Inspector");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10,10));
		setContentPane(contentPane);
		
		logArea = new JTextArea();
		logArea.setEditable(false);
		contentPane.add(new JScrollPane(logArea), BorderLayout.CENTER);
		
		progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		contentPane.add(progressBar, BorderLayout.SOUTH);
        setVisible(true);
	}
	
	public void log(String message) {
		SwingUtilities.invokeLater(() -> logArea.append(message + "\n"));
	}

}
