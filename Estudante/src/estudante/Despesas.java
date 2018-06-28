package estudante;

public class Despesas {
private String descricao;
private float valor;
private String categoria;
public Despesas(String d, float v, String c){
	descricao = d;
	valor = v;
	setCategoria(c);
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
public String getCategoria() {
	return categoria;
}

public void setCategoria(String categoria) {
	this.categoria = categoria;
}
public String toString(){
	String resposta = "\n"+
                      "Descrição: " + descricao + "\n" + 
			          "Valor: " + valor + "\n" +
	                  "Categoria: " + categoria;
	return resposta;
}
}
