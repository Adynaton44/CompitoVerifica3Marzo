package compito3Marzo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class ElencoStudenti extends ArrayList<Studente> {
	
	public ElencoStudenti() {
		super();
	}
	
	public void scrivicsv(Finestra f) {
		JFileChooser chooser=new JFileChooser();
		chooser.setFileFilter(new TxtFileFilter());
		int n=chooser.showSaveDialog(f);
		if(n==JFileChooser.APPROVE_OPTION) {
			File file=chooser.getSelectedFile();
			try {
				FileWriter fw= new FileWriter(file);
				for(int i=0;i<this.size();i++) {
					fw.write(this.get(i).getNome() + ";" + this.get(i).getCognome() + ";" + this.get(i).getClasse() + "\n");
				}
				fw.flush();
				fw.close();
				/*FileWriter fw = null;
				try {
					fw = new FileWriter(f);
					for(String line : a) {
						fw.write(line+"\n");
						
					}			
				}*/
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void importacsv(Finestra f){
		
		JFileChooser chooser=new JFileChooser();
		chooser.setFileFilter(new TxtFileFilter());
		int n=chooser.showSaveDialog(f);
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

}
