package compito3Marzo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Finestra extends JFrame implements ActionListener, MouseListener{
	
	private JMenuBar barra;
	private JMenu menu;
	private JMenuItem nuovo,salva;
	private JPanel pannello;
	private JTable table;
	private DefaultTableModel dtm;
	private JLabel foto;
	private JTextField t1,t2;
	private Dialogo pd;
	private ElencoStudenti elenco;
	private ImageIcon icon;
	private JScrollPane jsp;

	
	public Finestra() {
		initMenu();
	}
	
	public void initMenu() {
		this.setLayout(new BorderLayout());
		barra = new JMenuBar();
		menu = new JMenu("FILE");
		nuovo = new JMenuItem("Nuovo");
		nuovo.addActionListener(this);
		salva = new JMenuItem("Salva");
		salva.addActionListener(this);
		menu.add(nuovo);
		menu.add(salva);
		barra.add(menu);
		this.setJMenuBar(barra);
		
		elenco = new ElencoStudenti();
		dtm= new DefaultTableModel(new String[] {"COGNOME", "NOME","CLASSE"}, 0);
		table = new JTable(dtm);
		table.addMouseListener(this);
		jsp = new JScrollPane(table);
		pannello = new JPanel();
		pannello.setLayout(new BorderLayout());	
		foto = new JLabel();
		pannello.add(foto, BorderLayout.SOUTH);
		pannello.add(jsp, BorderLayout.NORTH);
		this.add(pannello);
	}
	
	public static void main(String args[]) {
		Finestra f = new Finestra();
		f.setVisible(true);
		f.setSize(600,800);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
