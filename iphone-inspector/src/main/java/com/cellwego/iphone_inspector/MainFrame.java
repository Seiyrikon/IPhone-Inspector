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

import com.cellwego.iphone_inspector.device.DeviceDetector;
import com.cellwego.iphone_inspector.inspector.Inspector;

import printer.ZebraPrinterService;

/**
 * @author Seiyrikon
 *
 */
// public class MainFrame extends JFrame {
public class MainFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private static JTextArea logArea;
	private JProgressBar progressBar;
	
	private static Inspector inspector = new Inspector();
	private static DeviceDetector detector = new DeviceDetector();
	
	private static ZebraPrinterService zebraPrinter = new ZebraPrinterService();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		MainFrame ui = new MainFrame();
//		detector.detect();
//		inspector.runCommand("ideviceinfo.exe");

		String zpl = "^XA^LH0,0^FO20,20^ADN,36,20^FDHello from Java!^FS^XZ";

		try {
			zebraPrinter.printLabel(zpl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("This works");
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the frame.
	 */
	// public MainFrame() {
	// 	setTitle("CellWeGo IPhone Inspector");
	// 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// 	setBounds(100, 100, 450, 300);
	// 	contentPane = new JPanel();
	// 	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	// 	contentPane.setLayout(new BorderLayout(10,10));
	// 	setContentPane(contentPane);
		
	// 	logArea = new JTextArea();
	// 	logArea.setEditable(false);
	// 	contentPane.add(new JScrollPane(logArea), BorderLayout.CENTER);
		
	// 	progressBar = new JProgressBar();
	// 	progressBar.setIndeterminate(true);
	// 	contentPane.add(progressBar, BorderLayout.SOUTH);
    //     setVisible(true);
	// }
	
	public static void log(String message) {
		SwingUtilities.invokeLater(() -> logArea.append(message + "\n"));
	}

}
