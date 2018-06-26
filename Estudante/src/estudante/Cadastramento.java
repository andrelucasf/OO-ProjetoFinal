package estudante;

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
	boolean resposta =alunos.add(a);
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
	}


