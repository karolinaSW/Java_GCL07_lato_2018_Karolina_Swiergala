import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import java.awt.Button;
import javax.swing.BoxLayout;
import javax.swing.border.MatteBorder;
import java.awt.Component;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.Font;

public class Table extends JFrame {

	private JFrame frmTabele;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void tableWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table window = new Table();
					window.frmTabele.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Table() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTabele = new JFrame();
		frmTabele.setTitle("Tabele");
		frmTabele.setBounds(100, 100, 718, 411);
		frmTabele.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		String studentName;
		
		JMenuBar menuBar = new JMenuBar();
		frmTabele.setJMenuBar(menuBar);
		
		JMenu mnProgram = new JMenu("Program");
		menuBar.add(mnProgram);
		
		JMenuItem mntmZamknij = new JMenuItem("Zamknij");
		mnProgram.add(mntmZamknij);
		mntmZamknij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		DefaultTableModel model = new DefaultTableModel(new Object[][] {
			{"Jan Kowalski", "WIMiIP", "IS", "6", "Fizyka I", new Double(3.0)},
			{"Anna Nowak", "WIMiIP", "ETI", "2", "Systemy operacyjne", new Double(4.5)},
		},
		new String[] {
			"Student", "Wydzia\u0142", "Kierunek", "Grupa", "Przedmiot", "Ocena"
		}
	) {
		Class[] columnTypes = new Class[] {
			String.class, String.class, String.class, String.class, String.class, Double.class
		};
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
	};
		
		JMenu mnPraca = new JMenu("Praca");
		menuBar.add(mnPraca);
		
		
		Object [] row = new Object[6];

		JMenuItem mntmDodaj = new JMenuItem("Dodaj");
		mntmDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nazwaInput = JOptionPane.showInputDialog("Wpisz nazwê studenta:");
				String wydzialInput = JOptionPane.showInputDialog("Wpisz nazwê wydzia³u:");
				String kierunekInput = JOptionPane.showInputDialog("Wpisz nazwê kierunku:");
				String grupaInput = JOptionPane.showInputDialog("Wpisz nazwê grupy:");
				String przedmiotInput = JOptionPane.showInputDialog("Wpisz nazwê przedmiotu:");
				String ocenaInput = JOptionPane.showInputDialog("Wpisz ocenê (oceny z czêœci¹ dziesiêtn¹ zapisuj z u¿yciek kropki, nie przecinka!):");
				
				double ocena = Double.parseDouble(ocenaInput);
				
				row[0] = nazwaInput;
				row[1] = wydzialInput;
				row[2] = kierunekInput;
				row[3] = grupaInput;
				row[4] = przedmiotInput;
				row[5] = ocena;
				

			}
		});
		mnPraca.add(mntmDodaj);
		frmTabele.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 8, 686, 203);
		frmTabele.getContentPane().add(scrollPane);
		
	
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFillsViewportHeight(true);
		//frmTabele.getContentPane().add(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setSurrendersFocusOnKeystroke(true);
		
		/*table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Jan Kowalski", "WIMiIP", "IS", "6", "Fizyka I", new Double(3.0)},
				{"Anna Nowak", "WIMiIP", "ETI", "2", "Systemy operacyjne", new Double(4.5)},
			},
			new String[] {
				"Student", "Wydzia\u0142", "Kierunek", "Grupa", "Przedmiot", "Ocena"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});*/
	
	table.setModel(model);
	
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		table.setBounds(21, 58, 646, 270);
		frmTabele.setVisible(true);
		scrollPane.setViewportView(table);
		
		JButton btnUsuZaznaczoneRekordy = new JButton("Usu\u0144 zaznaczone rekordy");
		btnUsuZaznaczoneRekordy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int[] selectedRows = table.getSelectedRows();
				for(int i = selectedRows.length -1 ; i >= 0 ; i --) {
					model.removeRow(selectedRows[i]);
				}
				
				
			}
		});
		btnUsuZaznaczoneRekordy.setBackground(new Color(250, 128, 114));
		btnUsuZaznaczoneRekordy.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUsuZaznaczoneRekordy.setBounds(8, 261, 181, 36);
		frmTabele.getContentPane().add(btnUsuZaznaczoneRekordy);
		
		JButton btnGeneruj = new JButton("Generuj");
		btnGeneruj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.addRow(row);

			}
		});
		btnGeneruj.setBackground(new Color(102, 205, 170));
		btnGeneruj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGeneruj.setBounds(513, 261, 181, 36);
		frmTabele.getContentPane().add(btnGeneruj);
		table.setVisible(true);
		
		
		
		
	}
}
