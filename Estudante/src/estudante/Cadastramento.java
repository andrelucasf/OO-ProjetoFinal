package estudante;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Cadastramento {
	List<Alunos> alunos;
	List<Despesas> despesa;
	
	public Cadastramento(){
		alunos = new LinkedList<Alunos>();
		despesa = new LinkedList<Despesas>();
	}

//Cadastros
public boolean cadastrarAluno(Alunos a){
	boolean resposta = alunos.add(a);
	return resposta;
}

public boolean removerAluno(Alunos a){
	boolean resposta = alunos.remove(a);
	return resposta;
}

public Alunos pesquisarAluno(String nome){// a função pesquisar alunos será usada pela função remover alunos presente na principal e em cadastramento para pesquisar o objeto a ser removido 
	Alunos resposta = null;
	Iterator<Alunos> it = alunos.iterator();
	while(it.hasNext()){
		Alunos a = it.next();
		if(a.getNome().equalsIgnoreCase(nome))
			resposta = a;
	}
	return resposta;
	}

public boolean cadastrarDespesa(Despesas d){
		boolean resposta = despesa.add(d);
		return resposta;
}

public boolean removerDespesa(Despesas d){
	boolean resposta = despesa.remove(d);
	return resposta;
}

public Despesas pesquisarDespesa(String nome){
	Despesas resposta = null;
	Iterator<Despesas>it = despesa.iterator();
	while(it.hasNext()){
		Despesas d = it.next();
		if(d.getDescricao().equalsIgnoreCase(nome)){
			resposta = d;
		}
	}
	return resposta;
}
	
//Calculos de despesas e contribuições
public float calcularTotal(){
  float total = 0;
Iterator <Despesas> it= despesa.iterator();
while(it.hasNext()){
	Despesas d = it.next();
	total+=d.getValor();
}

return total;
}
public float calcularIgual(){
	
	float valor = calcularTotal()/alunos.size();
	System.out.println(valor);
	
	for(Alunos a : alunos){
		a.setContribuicao(valor);
		JOptionPane.showMessageDialog(null,a);
	}
	return valor;
}
public float calcularProporcional(){
	float valor = 0;
	float total=0;
	
	for(Alunos a : alunos)
		total+=a.getRenda();
	
	for(Alunos a : alunos){
		a.setContribuicao(calcularTotal()*(a.getRenda()/total));
		JOptionPane.showMessageDialog(null,a);
	}
	return valor;
}

//Persistência
public boolean gravarAlunosEmArquivo() {
	boolean resposta = false;
	FileWriter arquivo = null;
	try {
		arquivo = new FileWriter("alunos.txt");
	} catch (IOException e) {
		e.printStackTrace();
	}
	BufferedWriter buffer = new BufferedWriter(arquivo);
	
	Iterator<Alunos> it = alunos.iterator();
	while (it.hasNext()) {
		Alunos a = it.next();
		String str = "";
		str += a.getNome() + ";";
		str += a.getEmail() + ";";
		str += a.getRenda() + ";";
		
		try {
			buffer.write(str);
			buffer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	try {
		buffer.close();
		resposta = true;
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return resposta;
}

public boolean lerArquivo() {
	FileReader arquivo = null;
	BufferedReader buffer;
	boolean resposta; 
	
	try {
		arquivo = new FileReader("alunos.txt");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	buffer = new BufferedReader(arquivo);
	
	
	String line = "";
	try {
		line = buffer.readLine();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	do {
		String[] campos = line.split(";");
		
		float renda = Float.parseFloat(campos[2]);
		//float contribuicao = Float.parseFloat(campos[3]);
		
		Alunos a = new Alunos(campos[0], campos[1], renda);
		
		if (alunos == null) 
			alunos = new LinkedList<Alunos>();
		
		resposta = alunos.add(a);
		
		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} while (line != null);
	
	return resposta;
	}

}


