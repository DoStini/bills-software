import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.UIManager;


import java.awt.print.PrinterJob;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.PrintService;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrinterSetup extends JFrame {
	
	List<JButton> buttons = new ArrayList<JButton>();
	
	public static void main(String[] args) throws IOException {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrinterSetup frame = new PrinterSetup();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public PrinterSetup() {
		List<String> selectedPrinter = new ArrayList<String>();
		
		setTitle("Printer Setup");	
		
		PrintService[] printers = PrinterJob.lookupPrintServices();
		
		getContentPane().setLayout(new GridLayout(printers.length, 1, 0, 0));
        for (int x = 0; x < printers.length; x++) {
        	String printerName = printers[x].getName();
        	buttons.add(new JButton(printerName));
        	getContentPane().add(buttons.get(x));
        	buttons.get(x).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					selectedPrinter.clear();
					selectedPrinter.add(((JButton) e.getSource()).getText());
					
					try {
						Files.write(Paths.get("Resources", "Printer.txt"), selectedPrinter);
						System.exit(0);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
        }
        
	}
}
