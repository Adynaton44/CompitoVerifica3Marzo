package compito3Marzo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Dialogo extends JDialog implements ActionListener {
	
	public JTextField t1,t2,t3,t4;
	public JLabel l1,l2,l3,l4;
	private JButton b1;
	private JButton b2;
	public Studente s;
	public ElencoStudenti elenco;

	
	public Dialogo(boolean bol, JFrame f) {
		super(f,bol);
		initC();
		this.setSize(600,600);
		this.setVisible(true);
	}

	private void initC() {
		
		this.setLayout(new GridLayout(5,2));
		t1=new JTextField(12);
		t2=new JTextField(12);
		t3=new JTextField(12);
		t4=new JTextField(12);
		l1=new JLabel("Nome");
		l2=new JLabel("Cognome");
		l3=new JLabel("Classe");
		l4=new JLabel("Path");
		b1=new JButton("Salva");
		b1.addActionListener(this);
		b2=new JButton("Chiudi");
		b2.addActionListener(this);
		this.add(l1);this.add(t1);
		this.add(l2);this.add(t2);
		this.add(l3);this.add(t3);
		this.add(l4);this.add(t4);
		this.add(b1);this.add(b2);
		s=new Studente();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(b2));
		dispose();
		
		if(e.getSource().equals(b1)) {
			s=new Studente(t1.getText(),t2.getText(),t3.getText(),t4.getText());
			
		}
		
	}

}
