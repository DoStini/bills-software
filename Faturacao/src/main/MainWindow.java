package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.jar.Attributes.Name;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.builder.ButtonStackBuilder;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Button;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import java.awt.Choice;
import java.util.List;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.ScrollPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame implements EventListener {

	// Name->Quantity
	public Map<String, Integer> ShoppingCart = new HashMap<String, Integer>();
	public Map<String, Integer> DailyCart = new HashMap<String, Integer>();
	public Float ShoppingCartValue = 0.0f;
	public Float DailyCartValue = 0.0f;
	
	public DecimalFormat priceFormat;
	
	public JList TotalList;
	public DefaultListModel<String> ModelTotal = new DefaultListModel<String>();
	public DefaultListModel<String> ModelDaily = new DefaultListModel<String>();

	public Map<String, String> NameList = new HashMap<String, String>(); // btn id -> Name
	public Map<String, Float> PriceList = new HashMap<String, Float>(); // btn id -> Price
	public Map<String, Float> NamePriceList = new HashMap<String, Float>();

	public String euro = "\u20ac";
	public JPanel contentPanel;

	public JButton btnBar;
	public JButton btnBar_0;
	public JButton btnBar_1;
	public JButton btnBar_2;
	public JButton btnBar_3;
	public JButton btnBar_4;
	public JButton btnBar_5;
	public JButton btnBar_6;
	public JButton btnBar_7;
	public JButton btnBar_8;
	public JButton btnBar_9;
	public JButton btnBar_10;
	public JButton btnBar_11;
	public JButton btnBar_12;
	public JButton btnBar_13;
	public JButton btnBar_14;
	public JButton btnBar_15;
	public JButton btnBar_16;
	public JButton btnBar_17;
	public JButton btnManual;

	public JPanel SnackPanel;
	public JButton btnSnack;
	public JButton btnSnack_0;
	public JButton btnSnack_1;
	public JButton btnSnack_2;
	public JButton btnSnack_3;
	public JButton btnSnack_4;
	public JButton btnSnack_5;
	public JButton btnSnack_6;
	public JButton btnSnack_7;
	public JButton btnSnack_8;
	public JButton btnSnack_9;
	public JButton btnSnack_10;
	public JButton btnSnack_11;
	public JButton btnSnack_12;
	public JButton btnSnack_13;
	public JButton btnSnack_14;
	public JButton btnSnack_15;
	public JButton btnSnack_16;
	public JButton btnSnack_17;
	public JButton btnSnack_18;
	public JPanel KitchenPanel;

	public JButton btnKitchen;
	public JButton btnKitchen_0;
	public JButton btnKitchen_1;
	public JButton btnKitchen_2;
	public JButton btnKitchen_3;
	public JButton btnKitchen_4;
	public JButton btnKitchen_5;
	public JButton btnKitchen_6;
	public JButton btnKitchen_7;
	public JButton btnKitchen_8;
	public JButton btnKitchen_9;
	public JButton btnKitchen_10;
	public JButton btnKitchen_11;
	public JButton btnKitchen_12;
	public JButton btnKitchen_13;
	public JButton btnKitchen_14;
	public JButton btnKitchen_15;
	public JButton btnKitchen_16;
	public JButton btnKitchen_17;
	public JButton btnKitchen_18;

	public JLabel labelPrice;
	private JButton btnOpenDaily;
	private JButton btnEndDay;
	private JButton TotalBtn;

	public String path;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					// frame.setUndecorated(true);
					frame.setAlwaysOnTop(true);
					// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					// frame.setResizable(false);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() throws IOException {
		priceFormat = new DecimalFormat("#.#");
		initComponents();
		LoadDatabase();
		eventHandler();
	}

	private void eventHandler() {
		TotalList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					int index = TotalList.getSelectedIndex();
					String value = ModelTotal.getElementAt(index).split(" X")[0];// Word to be removed

					if (JOptionPane.showConfirmDialog(contentPanel, "Remover item: " + value + "?", "",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						if (ShoppingCart.get(value) == 1) {
							ShoppingCart.remove(value);
						} else {
							ShoppingCart.put(value, ShoppingCart.get(value) - 1);
						}
						ShoppingCartValue -= NamePriceList.get(value);
						ShoppingCartValue = Float.parseFloat(priceFormat.format(ShoppingCartValue));
						UpdateCartVisual();
					}
				}
			}
		});

		// ADD F10 TO DAILY
		TotalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Total();
			}
		});

		btnEndDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(contentPanel,
						"Tem a certeza que pretende fechar sessão? Não feche antes das 00:00H", "",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					EndOfDay();
				}
			}
		});

		btnOpenDaily.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string = "";
				string += ("Total: " + DailyCartValue.toString() + euro + "\n\n");
				for (Object key : DailyCart.keySet()) {
					string += (key.toString() + " X" + DailyCart.get(key) + "\n");
				}
				JScrollPane scrollPane = new JScrollPane(new JTextArea(string));
				JOptionPane.showMessageDialog(contentPanel, scrollPane, "Total de Hoje", JOptionPane.OK_OPTION);
			}
		});

		btnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String price = JOptionPane.showInputDialog(contentPanel, "Preco:", "Manual");
				AddToCart("Manual", Float.parseFloat(price));
			}
		});

		btnBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar"), PriceList.get("btnBar"));
			}
		});
		btnBar_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_0"), PriceList.get("btnBar_0"));
			}
		});
		btnBar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_1"), PriceList.get("btnBar_1"));
			}
		});
		btnBar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_2"), PriceList.get("btnBar_2"));
			}
		});
		btnBar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_3"), PriceList.get("btnBar_3"));
			}
		});
		btnBar_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_4"), PriceList.get("btnBar_4"));
			}
		});
		btnBar_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_5"), PriceList.get("btnBar_5"));
			}
		});
		btnBar_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_6"), PriceList.get("btnBar_6"));
			}
		});
		btnBar_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_7"), PriceList.get("btnBar_7"));
			}
		});
		btnBar_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_8"), PriceList.get("btnBar_8"));
			}
		});
		btnBar_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_9"), PriceList.get("btnBar_9"));
			}
		});
		btnBar_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_10"), PriceList.get("btnBar_10"));
			}
		});
		btnBar_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_11"), PriceList.get("btnBar_3"));
			}
		});
		btnBar_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_12"), PriceList.get("btnBar_12"));
			}
		});
		btnBar_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_13"), PriceList.get("btnBar_13"));
			}
		});
		btnBar_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_14"), PriceList.get("btnBar_14"));
			}
		});
		btnBar_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_15"), PriceList.get("btnBar_15"));
			}
		});
		btnBar_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_16"), PriceList.get("btnBar_16"));
			}
		});
		btnBar_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnBar_17"), PriceList.get("btnBar_17"));
			}
		});

		btnKitchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen"), PriceList.get("btnKitchen"));
			}
		});
		btnKitchen_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_0"), PriceList.get("btnKitchen_0"));
			}
		});
		btnKitchen_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_1"), PriceList.get("btnKitchen_1"));
			}
		});
		btnKitchen_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_2"), PriceList.get("btnKitchen_2"));
			}
		});
		btnKitchen_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_3"), PriceList.get("btnKitchen_3"));
			}
		});
		btnKitchen_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_4"), PriceList.get("btnKitchen_4"));
			}
		});
		btnKitchen_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_5"), PriceList.get("btnKitchen_5"));
			}
		});
		btnKitchen_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_6"), PriceList.get("btnKitchen_6"));
			}
		});
		btnKitchen_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_7"), PriceList.get("btnKitchen_7"));
			}
		});
		btnKitchen_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_8"), PriceList.get("btnKitchen_8"));
			}
		});
		btnKitchen_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_9"), PriceList.get("btnKitchen_9"));
			}
		});
		btnKitchen_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_10"), PriceList.get("btnKitchen_10"));
			}
		});
		btnKitchen_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_11"), PriceList.get("btnKitchen_3"));
			}
		});
		btnKitchen_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_12"), PriceList.get("btnKitchen_12"));
			}
		});
		btnKitchen_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_13"), PriceList.get("btnKitchen_13"));
			}
		});
		btnKitchen_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_14"), PriceList.get("btnKitchen_14"));
			}
		});
		btnKitchen_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_15"), PriceList.get("btnKitchen_15"));
			}
		});
		btnKitchen_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_16"), PriceList.get("btnKitchen_16"));
			}
		});
		btnKitchen_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_17"), PriceList.get("btnKitchen_17"));
			}
		});
		btnKitchen_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCart(NameList.get("btnKitchen_18"), PriceList.get("btnKitchen_18"));
			}
		});

	}

	public void LoadDatabase() throws IOException {

		Map<String, JButton> Buttons = new HashMap<String, JButton>();
		Buttons.clear();
		Buttons.put("btnBar", btnBar);
		Buttons.put("btnBar_0", btnBar_0);
		Buttons.put("btnBar_1", btnBar_1);
		Buttons.put("btnBar_2", btnBar_2);
		Buttons.put("btnBar_3", btnBar_3);
		Buttons.put("btnBar_4", btnBar_4);
		Buttons.put("btnBar_5", btnBar_5);
		Buttons.put("btnBar_6", btnBar_6);
		Buttons.put("btnBar_7", btnBar_7);
		Buttons.put("btnBar_8", btnBar_8);
		Buttons.put("btnBar_9", btnBar_9);
		Buttons.put("btnBar_10", btnBar_10);
		Buttons.put("btnBar_11", btnBar_11);
		Buttons.put("btnBar_12", btnBar_12);
		Buttons.put("btnBar_13", btnBar_13);
		Buttons.put("btnBar_14", btnBar_14);
		Buttons.put("btnBar_15", btnBar_15);
		Buttons.put("btnBar_16", btnBar_16);
		Buttons.put("btnBar_17", btnBar_17);

		Buttons.put("btnSnack", btnSnack);
		Buttons.put("btnSnack_0", btnSnack_0);
		Buttons.put("btnSnack_1", btnSnack_1);
		Buttons.put("btnSnack_2", btnSnack_2);
		Buttons.put("btnSnack_3", btnSnack_3);
		Buttons.put("btnSnack_4", btnSnack_4);
		Buttons.put("btnSnack_5", btnSnack_5);
		Buttons.put("btnSnack_6", btnSnack_6);
		Buttons.put("btnSnack_7", btnSnack_7);
		Buttons.put("btnSnack_8", btnSnack_8);
		Buttons.put("btnSnack_9", btnSnack_9);
		Buttons.put("btnSnack_10", btnSnack_10);
		Buttons.put("btnSnack_11", btnSnack_11);
		Buttons.put("btnSnack_12", btnSnack_12);
		Buttons.put("btnSnack_13", btnSnack_13);
		Buttons.put("btnSnack_14", btnSnack_14);
		Buttons.put("btnSnack_15", btnSnack_15);
		Buttons.put("btnSnack_16", btnSnack_16);
		Buttons.put("btnSnack_17", btnSnack_17);
		Buttons.put("btnSnack_18", btnSnack_18);

		Buttons.put("btnKitchen", btnKitchen);
		Buttons.put("btnKitchen_0", btnKitchen_0);
		Buttons.put("btnKitchen_1", btnKitchen_1);
		Buttons.put("btnKitchen_2", btnKitchen_2);
		Buttons.put("btnKitchen_3", btnKitchen_3);
		Buttons.put("btnKitchen_4", btnKitchen_4);
		Buttons.put("btnKitchen_5", btnKitchen_5);
		Buttons.put("btnKitchen_6", btnKitchen_6);
		Buttons.put("btnKitchen_7", btnKitchen_7);
		Buttons.put("btnKitchen_8", btnKitchen_8);
		Buttons.put("btnKitchen_9", btnKitchen_9);
		Buttons.put("btnKitchen_10", btnKitchen_10);
		Buttons.put("btnKitchen_11", btnKitchen_11);
		Buttons.put("btnKitchen_12", btnKitchen_12);
		Buttons.put("btnKitchen_13", btnKitchen_13);
		Buttons.put("btnKitchen_14", btnKitchen_14);
		Buttons.put("btnKitchen_15", btnKitchen_15);
		Buttons.put("btnKitchen_16", btnKitchen_16);
		Buttons.put("btnKitchen_17", btnKitchen_17);
		Buttons.put("btnKitchen_18", btnKitchen_18);

		// DAILY LOAD
		String[] line;
		Path path = Paths.get("Resources", "DailyDB.txt");
		line = null;
		try {
			List<String> lines = Files.readAllLines(path);

			for (int x = 0; x < lines.size(); x++) {
				if (x == 0) {
					DailyCartValue = Float.parseFloat(lines.get(0));
				} else {
					line = lines.get(x).split("/");
					DailyCart.put(line[0], Integer.parseInt(line[1]));
				}
			}
		} finally {
		}

		// LOAD
		path = Paths.get("Resources", "DB.txt");
		line = null;
		try {
			List<String> lines = Files.readAllLines(path);

			for (int x = 0; x < lines.size(); x++) {
				if (!lines.get(x).equals("NULL")) {
					System.out.println(lines.get(x));
					line = lines.get(x).split("/");
					System.out.println("Works " + line[0] + "\n");
					NameList.put(line[0], line[1]);
					PriceList.put(line[0], Float.parseFloat(line[2]));
					NamePriceList.put(line[1], Float.parseFloat(line[2]));
					Buttons.get(line[0]).setText("<html>" + line[1] + "<br>" + line[2].toString() + euro);
					Buttons.get(line[0]).setEnabled(true);
				} else {
					System.out.println("Skips");
					NameList.put("", "");
					PriceList.put("", 0.0f);
					NamePriceList.put("", 0.0f);

				}
			}
		} finally {
		}
	}

	private void initComponents() {

		setFont(new Font("Source Code Pro Black", Font.PLAIN, 15));
		setTitle("Fatura\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);

		JPanel MainPanel = new JPanel();
		MainPanel.setBorder(new LineBorder(new Color(192, 192, 192), 10, true));
		MainPanel.setBackground(Color.DARK_GRAY);

		JPanel TotalPanel = new JPanel();
		TotalPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 10, true));
		TotalPanel.setBackground(Color.DARK_GRAY);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
						.addComponent(MainPanel, GroupLayout.DEFAULT_SIZE, 1504, Short.MAX_VALUE).addGap(18)
						.addComponent(TotalPanel, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(11)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(TotalPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1009,
										Short.MAX_VALUE)
								.addComponent(MainPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));

		JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanel.setBackground(Color.LIGHT_GRAY);
		tabbedPanel.setForeground(Color.BLACK);
		tabbedPanel.setFont(new Font("Impact", Font.PLAIN, 40));
		GroupLayout gl_MainPanel = new GroupLayout(MainPanel);
		gl_MainPanel.setHorizontalGroup(gl_MainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MainPanel.createSequentialGroup().addContainerGap()
						.addComponent(tabbedPanel, GroupLayout.DEFAULT_SIZE, 1461, Short.MAX_VALUE).addContainerGap()));
		gl_MainPanel.setVerticalGroup(gl_MainPanel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_MainPanel.createSequentialGroup().addContainerGap()
						.addComponent(tabbedPanel, GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE).addContainerGap()));

		JPanel BarPanel = new JPanel();
		tabbedPanel.addTab("Bar", null, BarPanel, null);
		BarPanel.setLayout(new GridLayout(0, 5, 5, 5));

		btnBar = new JButton("");
		btnBar.setEnabled(false);
		btnBar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar);

		btnBar_0 = new JButton("");
		btnBar_0.setEnabled(false);
		btnBar_0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_0);

		btnBar_1 = new JButton("");
		btnBar_1.setEnabled(false);
		btnBar_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_1);

		btnBar_2 = new JButton("");
		btnBar_2.setEnabled(false);
		btnBar_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_2);

		btnBar_3 = new JButton("");
		btnBar_3.setEnabled(false);
		btnBar_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_3);

		btnBar_4 = new JButton("");
		btnBar_4.setEnabled(false);
		btnBar_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_4);

		btnBar_5 = new JButton("");
		btnBar_5.setEnabled(false);
		btnBar_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_5);

		btnBar_6 = new JButton("");
		btnBar_6.setEnabled(false);
		btnBar_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_6);

		btnBar_7 = new JButton("");
		btnBar_7.setEnabled(false);
		btnBar_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_7);

		btnBar_8 = new JButton("");
		btnBar_8.setEnabled(false);
		btnBar_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_8);

		btnBar_9 = new JButton("");
		btnBar_9.setEnabled(false);
		btnBar_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_9);

		btnBar_10 = new JButton("");
		btnBar_10.setEnabled(false);
		btnBar_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_10);

		btnBar_11 = new JButton("");
		btnBar_11.setEnabled(false);
		btnBar_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_11);

		btnBar_12 = new JButton("");
		btnBar_12.setEnabled(false);
		btnBar_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_12);

		btnBar_13 = new JButton("");
		btnBar_13.setEnabled(false);
		btnBar_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_13);

		btnBar_14 = new JButton("");
		btnBar_14.setEnabled(false);
		btnBar_14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_14);

		btnBar_15 = new JButton("");
		btnBar_15.setEnabled(false);
		btnBar_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_15);

		btnBar_16 = new JButton("");
		btnBar_16.setEnabled(false);
		btnBar_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_16);

		btnBar_17 = new JButton("");
		btnBar_17.setEnabled(false);
		btnBar_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnBar_17);

		btnManual = new JButton("Manual");

		btnManual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BarPanel.add(btnManual);

		SnackPanel = new JPanel();
		tabbedPanel.addTab("Snack", null, SnackPanel, null);
		SnackPanel.setLayout(new GridLayout(0, 5, 5, 5));

		btnSnack = new JButton("");
		btnSnack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack.setEnabled(false);
		SnackPanel.add(btnSnack);

		btnSnack_0 = new JButton("");
		btnSnack_0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_0.setEnabled(false);
		SnackPanel.add(btnSnack_0);

		btnSnack_1 = new JButton("");
		btnSnack_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_1.setEnabled(false);
		SnackPanel.add(btnSnack_1);

		btnSnack_2 = new JButton("");
		btnSnack_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_2.setEnabled(false);
		SnackPanel.add(btnSnack_2);

		btnSnack_3 = new JButton("");
		btnSnack_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_3.setEnabled(false);
		SnackPanel.add(btnSnack_3);

		btnSnack_4 = new JButton("");
		btnSnack_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_4.setEnabled(false);
		SnackPanel.add(btnSnack_4);

		btnSnack_5 = new JButton("");
		btnSnack_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_5.setEnabled(false);
		SnackPanel.add(btnSnack_5);

		btnSnack_6 = new JButton("");
		btnSnack_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_6.setEnabled(false);
		SnackPanel.add(btnSnack_6);

		btnSnack_7 = new JButton("");
		btnSnack_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_7.setEnabled(false);
		SnackPanel.add(btnSnack_7);

		btnSnack_8 = new JButton("");
		btnSnack_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_8.setEnabled(false);
		SnackPanel.add(btnSnack_8);

		btnSnack_9 = new JButton("");
		btnSnack_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_9.setEnabled(false);
		SnackPanel.add(btnSnack_9);

		btnSnack_10 = new JButton("");
		btnSnack_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_10.setEnabled(false);
		SnackPanel.add(btnSnack_10);

		btnSnack_11 = new JButton("");
		btnSnack_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_11.setEnabled(false);
		SnackPanel.add(btnSnack_11);

		btnSnack_12 = new JButton("");
		btnSnack_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_12.setEnabled(false);
		SnackPanel.add(btnSnack_12);

		btnSnack_13 = new JButton("");
		btnSnack_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_13.setEnabled(false);
		SnackPanel.add(btnSnack_13);

		btnSnack_14 = new JButton("");
		btnSnack_14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_14.setEnabled(false);
		SnackPanel.add(btnSnack_14);

		btnSnack_15 = new JButton("");
		btnSnack_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_15.setEnabled(false);
		SnackPanel.add(btnSnack_15);

		btnSnack_16 = new JButton("");
		btnSnack_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_16.setEnabled(false);
		SnackPanel.add(btnSnack_16);

		btnSnack_17 = new JButton("");
		btnSnack_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_17.setEnabled(false);
		SnackPanel.add(btnSnack_17);

		btnSnack_18 = new JButton("");
		btnSnack_18.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSnack_18.setEnabled(false);
		SnackPanel.add(btnSnack_18);

		KitchenPanel = new JPanel();
		tabbedPanel.addTab("Cozinha", null, KitchenPanel, null);
		KitchenPanel.setLayout(new GridLayout(0, 5, 5, 5));

		btnKitchen = new JButton("");
		btnKitchen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen.setEnabled(false);
		KitchenPanel.add(btnKitchen);

		btnKitchen_0 = new JButton("");
		btnKitchen_0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_0.setEnabled(false);
		KitchenPanel.add(btnKitchen_0);

		btnKitchen_1 = new JButton("");
		btnKitchen_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_1.setEnabled(false);
		KitchenPanel.add(btnKitchen_1);

		btnKitchen_2 = new JButton("");
		btnKitchen_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_2.setEnabled(false);
		KitchenPanel.add(btnKitchen_2);

		btnKitchen_3 = new JButton("");
		btnKitchen_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_3.setEnabled(false);
		KitchenPanel.add(btnKitchen_3);

		btnKitchen_4 = new JButton("");
		btnKitchen_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_4.setEnabled(false);
		KitchenPanel.add(btnKitchen_4);

		btnKitchen_5 = new JButton("");
		btnKitchen_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_5.setEnabled(false);
		KitchenPanel.add(btnKitchen_5);

		btnKitchen_6 = new JButton("");
		btnKitchen_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_6.setEnabled(false);
		KitchenPanel.add(btnKitchen_6);

		btnKitchen_7 = new JButton("");
		btnKitchen_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_7.setEnabled(false);
		KitchenPanel.add(btnKitchen_7);

		btnKitchen_8 = new JButton("");
		btnKitchen_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_8.setEnabled(false);
		KitchenPanel.add(btnKitchen_8);

		btnKitchen_9 = new JButton("");
		btnKitchen_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_9.setEnabled(false);
		KitchenPanel.add(btnKitchen_9);

		btnKitchen_10 = new JButton("");
		btnKitchen_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_10.setEnabled(false);
		KitchenPanel.add(btnKitchen_10);

		btnKitchen_11 = new JButton("");
		btnKitchen_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_11.setEnabled(false);
		KitchenPanel.add(btnKitchen_11);

		btnKitchen_12 = new JButton("");
		btnKitchen_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_12.setEnabled(false);
		KitchenPanel.add(btnKitchen_12);

		btnKitchen_13 = new JButton("");
		btnKitchen_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_13.setEnabled(false);
		KitchenPanel.add(btnKitchen_13);

		btnKitchen_14 = new JButton("");
		btnKitchen_14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_14.setEnabled(false);
		KitchenPanel.add(btnKitchen_14);

		btnKitchen_15 = new JButton("");
		btnKitchen_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_15.setEnabled(false);
		KitchenPanel.add(btnKitchen_15);

		btnKitchen_16 = new JButton("");
		btnKitchen_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_16.setEnabled(false);
		KitchenPanel.add(btnKitchen_16);

		btnKitchen_17 = new JButton("");
		btnKitchen_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_17.setEnabled(false);
		KitchenPanel.add(btnKitchen_17);

		btnKitchen_18 = new JButton("");
		btnKitchen_18.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKitchen_18.setEnabled(false);
		KitchenPanel.add(btnKitchen_18);
		MainPanel.setLayout(gl_MainPanel);

		TotalBtn = new JButton("Total");

		TotalBtn.setFont(new Font("Dialog", Font.BOLD, 35));

		JPanel BackScrollPanel = new JPanel();
		BackScrollPanel.setBorder(null);
		GroupLayout gl_TotalPanel = new GroupLayout(TotalPanel);
		gl_TotalPanel.setHorizontalGroup(gl_TotalPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TotalPanel.createSequentialGroup().addGap(7)
						.addGroup(gl_TotalPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(BackScrollPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 325,
										Short.MAX_VALUE)
								.addComponent(TotalBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 328,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_TotalPanel.setVerticalGroup(gl_TotalPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TotalPanel.createSequentialGroup().addGap(7)
						.addComponent(TotalBtn, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE).addGap(18)
						.addComponent(BackScrollPanel, GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
						.addContainerGap()));

		JScrollPane TotalScroll = new JScrollPane();
		TotalScroll.setViewportBorder(null);
		TotalScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		TotalScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		labelPrice = new JLabel("Pre\u00E7o: ");
		labelPrice.setFont(new Font("Dialog", Font.BOLD, 25));

		btnOpenDaily = new JButton("Di\u00E1rio");

		btnEndDay = new JButton("Fechar Sess\u00E3o");

		GroupLayout gl_BackScrollPanel = new GroupLayout(BackScrollPanel);
		gl_BackScrollPanel.setHorizontalGroup(gl_BackScrollPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BackScrollPanel.createSequentialGroup().addContainerGap().addGroup(gl_BackScrollPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_BackScrollPanel.createSequentialGroup()
								.addComponent(btnOpenDaily, GroupLayout.PREFERRED_SIZE, 73, Short.MAX_VALUE).addGap(18)
								.addComponent(btnEndDay, GroupLayout.PREFERRED_SIZE, 73, Short.MAX_VALUE).addGap(5))
						.addComponent(TotalScroll, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
						.addGroup(gl_BackScrollPanel.createSequentialGroup()
								.addComponent(labelPrice, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
								.addGap(10)))));
		gl_BackScrollPanel.setVerticalGroup(gl_BackScrollPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_BackScrollPanel.createSequentialGroup().addContainerGap()
						.addComponent(labelPrice, GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE).addGap(8)
						.addComponent(TotalScroll, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_BackScrollPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnOpenDaily, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE).addComponent(
										btnEndDay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));

		TotalList = new JList();
		TotalList.setBorder(null);
		TotalList.setFont(new Font("Tahoma", Font.PLAIN, 25));
		TotalList.setModel(new AbstractListModel() {
			String[] values = new String[] {};

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		TotalScroll.setViewportView(TotalList);
		BackScrollPanel.setLayout(gl_BackScrollPanel);
		TotalPanel.setLayout(gl_TotalPanel);
		contentPanel.setLayout(gl_contentPanel);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { contentPanel, MainPanel, tabbedPanel,
				BarPanel, btnBar, btnBar_0, btnBar_1, btnBar_2, btnBar_3, btnBar_4, btnBar_5, btnBar_6, btnBar_7,
				btnBar_8, btnBar_9, btnBar_10, btnBar_11, btnBar_12, btnBar_13, btnBar_14, btnBar_15, btnBar_16,
				btnBar_17, btnManual, TotalPanel, BackScrollPanel, TotalScroll, TotalList, TotalBtn }));

	}

	private void AddToCart(String name, Float price) {
		if (!ShoppingCart.containsKey(name)) {
			ShoppingCart.put(name, 1);
			ShoppingCartValue += price;
		} else {
			ShoppingCart.put(name, ShoppingCart.get(name) + 1);
			ShoppingCartValue += price;
		}
		ShoppingCartValue = Float.parseFloat(priceFormat.format(ShoppingCartValue));
		UpdateCartVisual();
	}

	private void Total() {
		for (Object key : ShoppingCart.keySet()) {
			if (!DailyCart.containsKey(key)) {
				DailyCart.put(key.toString(), ShoppingCart.get(key));
			} else {
				DailyCart.put(key.toString(), DailyCart.get(key) + ShoppingCart.get(key));
			}
		}
		DailyCartValue += ShoppingCartValue;
		ShoppingCart.clear();
		ModelTotal.clear();
		ShoppingCartValue = 0.0f;

		UpdateCartVisual();
		try {
			FileWriter fw = new FileWriter("Resources/DailyDB.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.println(DailyCartValue.toString());
			for (Object key : DailyCart.keySet()) {
				pw.println(key.toString() + "/" + DailyCart.get(key).toString());
			}
			fw.close();
			pw.close();
			System.out.println("Works");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private void EndOfDay() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
		Date date = new Date();
		try {
			Files.move(Paths.get("Resources", "DailyDB.txt"),
					Paths.get(Paths.get("Diario").toString() + "/" + dateFormat.format(date) + ".txt"));
		} catch (IOException e) {
			System.out.println(e);
		}

		try {
			FileWriter fw = new FileWriter("Resources/DailyDB.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.println("0.0");
			fw.close();
			pw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		System.exit(0);
	}

	private void UpdateCartVisual() {
		try {
			ModelTotal.clear();
		} finally {
			for (Object key : ShoppingCart.keySet()) {
				ModelTotal.addElement(key.toString() + " X" + ShoppingCart.get(key).toString());
			}
		}
		TotalList.setModel(ModelTotal);
		labelPrice.setText("Pre\u00E7o: " + ShoppingCartValue.toString() + euro);
	}
}
