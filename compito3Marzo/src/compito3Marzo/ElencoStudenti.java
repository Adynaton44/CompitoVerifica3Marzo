package compito3Marzo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ElencoStudenti extends ArrayList<Studente> implements Serializable {
	
	public ElencoStudenti() {
		super();
	}
	
	public void scrivicsv(Finestra f) {//scrive su un file csv
		JFileChooser chooser=new JFileChooser();
		chooser.setFileFilter(new TxtFileFilter());
		int n=chooser.showSaveDialog(f);//senza riferimento alla finestra non funziona
		if(n==JFileChooser.APPROVE_OPTION) {
			File file=chooser.getSelectedFile();//volendo si può creare un un metodo scegli file per separare front-end e back-end
			try {
				FileWriter fw= new FileWriter(file);//ObjectOutputStream se fosse serializzabile
				for(int i=0;i<this.size();i++) {//no ciclo perché 
					fw.write(this.get(i).getNome() + "," + this.get(i).getCognome() + "," + this.get(i).getClasse() + "\n");
					/*f = new FileOutputStream(file);
					o = new ObjectOutputStream(f);
					o.writeObject(this);*/
				}
				fw.flush();
				fw.close();	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void importacsv(Finestra f){//prende informazioni da un file csv
		
		JFileChooser chooser=new JFileChooser();
		chooser.setFileFilter(new TxtFileFilter());
		int n=chooser.showOpenDialog(f);
		if(n==JFileChooser.APPROVE_OPTION) {
			try {
				BufferedReader br=new BufferedReader(new FileReader(chooser.getSelectedFile()));
				String line="";
				while((line=br.readLine())!=null) {
					String s[]=line.split(",");
					this.add(new Studente(s[1],s[2],s[3],s[4]));
				}
				br.close();	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void serializza(Finestra j) throws Exception{	
		FileOutputStream f = null;
		ObjectOutputStream o = null;
		try {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("generico", "dat");
			chooser.setFileFilter(filter);
			int retVal = chooser.showSaveDialog(j);
			if(retVal == chooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				file.createNewFile();
				f = new FileOutputStream(file);
				o = new ObjectOutputStream(f);
				o.writeObject(this);
				o.flush();
			}		
		}
		catch(Exception exc) {
			throw new Exception();
		}
		finally {
			if(o != null) {
				try {
					o.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


	public void deserializza(Finestra j ) {
		FileInputStream f = null;
		ObjectInputStream o = null;
		try {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("generico", "dat");
			chooser.setFileFilter(filter);
			int retVal = chooser.showOpenDialog(j);
			if(retVal == chooser.APPROVE_OPTION) {
				File f1 = chooser.getSelectedFile();
				if(f1.exists()) {
					f = new FileInputStream(f1);
					o = new ObjectInputStream(f);
					ElencoStudenti ep = (ElencoStudenti)o.readObject();
					
					int i;
					for(i=0; i<ep.size(); i++) {
						this.add(ep.get(i));
					}					
				}
			}
		}
		catch(Exception exc) {
			JOptionPane.showMessageDialog(null, exc.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			if(o != null) {
				try {
					o.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
