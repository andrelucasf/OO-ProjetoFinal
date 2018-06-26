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


public class Cadastramento {
	List<Alunos> alunos;
	//List<Despesas>despesa;
	public Cadastramento(){
		alunos = new LinkedList<Alunos>();
		//despesa = new LinkedList<Despesas>();
	}

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


