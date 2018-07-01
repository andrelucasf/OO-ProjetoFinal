package estudante;

public class Alunos {
	
	private float renda, contribuicao;
	private String nome;
	private String email;
	 
public Alunos(String n, String e, float r){
	this.setNome(n);
	this.setEmail(e);
	this.setRenda(r);
	//this.setContribuicao(c);
}
	
@Override
public String toString() {
		String resposta = "\n"+
				          "Nome: " + nome +"\n"+
				          "Email: " + email +"\n"+
				          "Renda: " + renda + "\n" +
						  "Contribuição: " + contribuicao + "\n";
	return resposta;
}

	public float getRenda() {
		return renda;
	}
	public void setRenda(float renda) {
		this.renda = renda;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public float getContribuicao() {
		return contribuicao;
	}

	public void setContribuicao(float contribuicao) {
		this.contribuicao = contribuicao;
	}
	}


