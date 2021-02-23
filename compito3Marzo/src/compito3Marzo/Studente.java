package compito3Marzo;

public class Studente {
	
	public String nome, cognome, classe, path;
	
	public Studente(String nome, String cognome, String classe, String path) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.classe = classe;
		this.path = path;
	}
	public Studente() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String NomeCognome() {
		return this.nome +", "+this.nome;
	}

}
