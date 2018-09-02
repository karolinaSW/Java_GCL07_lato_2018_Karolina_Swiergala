import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;

public class App {

	private JFrame frmPanelLogowania;
	private JTextField textFieldNazwaStudenta;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmPanelLogowania.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String nameLegal = "Karolina Œwierga³a";
		String passwordLegal = "1234";
		
		frmPanelLogowania = new JFrame();
		frmPanelLogowania.setTitle("Panel logowania");
		frmPanelLogowania.setBounds(100, 100, 685, 487);
		frmPanelLogowania.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblInfoNazwa = new JLabel("Nazwa musi zawiera\u0107 od 3 do 20 znak\u00F3w");
		lblInfoNazwa.setVisible(false);
		JLabel lblInfoHaslo = new JLabel("Has\u0142o musi zawiera\u0107 od 3 do 20 znak\u00F3w");
		lblInfoHaslo.setVisible(false);


		
		JMenuBar menu = new JMenuBar();
		menu.setMargin(new Insets(8, 8, 8, 8));
		menu.setForeground(Color.BLACK);
		menu.setBackground(new Color(192, 192, 192));
		menu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		frmPanelLogowania.setJMenuBar(menu);
		
		JMenu mnProgram = new JMenu("Program");
		mnProgram.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menu.add(mnProgram);
		
		JMenuItem mntmZakoncz = new JMenuItem("Zako\u0144cz");
		mntmZakoncz.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnProgram.add(mntmZakoncz);
		mntmZakoncz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frmPanelLogowania.getContentPane().setLayout(new GridLayout(7, 2, 40, 0));
		
		JPanel panel_5 = new JPanel();
		frmPanelLogowania.getContentPane().add(panel_5);
		
		JPanel panel_1 = new JPanel();
		frmPanelLogowania.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNazwaStudenta = new JLabel("Nazwa studenta  ");
		lblNazwaStudenta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNazwaStudenta.setFont(new Font("Verdana", Font.PLAIN, 18));
		panel_1.add(lblNazwaStudenta);
		
		textFieldNazwaStudenta = new JTextField();
		textFieldNazwaStudenta.setFont(new Font("Verdana", Font.PLAIN, 18));
		panel_1.add(textFieldNazwaStudenta);
		/*textFieldNazwaStudenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});*/
		
		textFieldNazwaStudenta.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(textFieldNazwaStudenta.getText().length() < 3 || textFieldNazwaStudenta.getText().length() > 20) {
					lblInfoNazwa.setVisible(true);
				}
				else {
					lblInfoNazwa.setVisible(false);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		textFieldNazwaStudenta.setColumns(1);
		
		JPanel panel_2 = new JPanel();
		frmPanelLogowania.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblInfoNazwa.setForeground(Color.RED);
		lblInfoNazwa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfoNazwa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInfoNazwa.setVerticalAlignment(SwingConstants.TOP);
		lblInfoNazwa.setVisible(false);
		panel_2.add(lblInfoNazwa);
		
		JPanel panel_3 = new JPanel();
		frmPanelLogowania.getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblHaslo = new JLabel("Has\u0142o   ");
		lblHaslo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHaslo.setFont(new Font("Verdana", Font.PLAIN, 18));
		panel_3.add(lblHaslo);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 18));
		panel_3.add(passwordField);
		passwordField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
				if(passwordField.getText().length() < 3 || passwordField.getText().length() > 20) {
					lblInfoHaslo.setVisible(true);
				}
				else {
					lblInfoHaslo.setVisible(false);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JPanel panel_4 = new JPanel();
		frmPanelLogowania.getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblInfoHaslo.setVerticalAlignment(SwingConstants.TOP);
		lblInfoHaslo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInfoHaslo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfoHaslo.setForeground(Color.RED);
		lblInfoHaslo.setVisible(false);
		panel_4.add(lblInfoHaslo);
		
		JLabel label = new JLabel(" ");
		frmPanelLogowania.getContentPane().add(label);
		
		JPanel panel = new JPanel();
		frmPanelLogowania.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		JButton btnZaloguj = new JButton("Zaloguj");
		btnZaloguj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					if(textFieldNazwaStudenta.getText().equals(nameLegal) && passwordField.getText().equals(passwordLegal)) {
						//TODO: nowe okno
						Table table = new Table();
						table.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "B³êdne dane do logowania");
					}
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		btnZaloguj.setBackground(new Color(240, 255, 240));
		btnZaloguj.setForeground(new Color(0, 128, 0));
		btnZaloguj.setFont(new Font("Verdana", Font.PLAIN, 23));
		panel.add(btnZaloguj);
		
		menu.setVisible(true);
		
		
		


	}
	
	boolean getData(){
		String name = textFieldNazwaStudenta.getText();
		if(name.isEmpty()) {
			return false;
		}
		if (!name.matches("[a-zA-Z¹æê³ñóœ¿Ÿ-]+")) {
			return false;
		}
		if(name.length()<3 || name.length()>20) {
			return false;
		}
		char[] password = passwordField.getPassword();
		if(password.length < 3 || password.length > 20) {
			return false;
		}
		if(password.length == 0) {
			return false;
		}
		return true;
	}

}
