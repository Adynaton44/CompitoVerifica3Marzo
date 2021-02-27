package compito3Marzo;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class TxtFileFilter extends FileFilter {//spudoratamente copiato da Diego

	@Override
	public boolean accept(File f) {
		if(f.isDirectory()) {
			return true;
		}
		String filename=f.getName().toLowerCase();
		return false;
	}

	@Override
	public String getDescription() {
		return "file csv";
	}
	
	
}