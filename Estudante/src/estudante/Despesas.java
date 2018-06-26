package estudante;

public class Despesas {
private String descricao;
private float valor;
Categoria categoria = new Categoria();
public Despesas(String d, float v){
	descricao = d;
	valor = v;
	
}

public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public float getValor() {
	return valor;
}
public void setValor(float valor) {
	this.valor = valor;
}
public String toString(){
	String resposta = "---------despesa------------"+"\n"+
                      "Descriao: " + descricao + "\n" + 
			          "Valor" + valor + "\n"+
                      "tipo: " + categoria.getTipo() + "\n";
	return resposta;
}
}
