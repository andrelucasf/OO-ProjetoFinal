package estudante;

import javax.swing.JOptionPane;

public class Principal {
static Cadastramento c;
	
static final String[] opcoes = {
	"-------Selecione uma opção--------",
	"Cadastrar aluno",
	"Remover aluno",
	"Pesquisar aluno",
	"Cadastrar despesa",
	"Remover despesa",
	"Pesquisar despesa",
	"Ler em arquivo",
	"Gravar em arquivo",
	"Sair"
};
	public static void main(String[] args) {
		c = new Cadastramento();
		 
		Object opcao = JOptionPane.showInputDialog(
				null, 
				"Selecione uma opção", 
				"Menu de cadastro", 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				opcoes,
				opcoes[0]);
		while(opcao != "Sair"){
		if(opcao.toString() == "Cadastrar aluno")
			cadastrarAluno();
	    if (opcao == "Remover aluno")
			removerAluno();
	    if(opcao == "Cadastrar despesa")
	    	cadastrarDespesa();
	    if(opcao=="Pesquisar aluno" )
	    	pesquisarAluno();
		if(opcao == "Remover despesa")
			removerDespesa();
		if(opcao == "Pesquisar despesa")
			pesquisarDespesa();
		if(opcao=="Ler em arquivo")
			lerEmArquivo();
		if(opcao=="Gravar em arquivo")
			gravarEmArquivo();
	    opcao = JOptionPane.showInputDialog(
				null, 
				"Selecione uma opção", 
				"Menu de cadastro", 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				opcoes,
				opcoes[0]);
		};
		
		}
	
	private static Despesas pesquisarDespesa(){
		String descricao = JOptionPane.showInputDialog("Descrição");
		Despesas d = c.pesquisarDespesa(descricao);
		if(d==null)
			JOptionPane.showMessageDialog(null, "Despesa não encontrada!\n");
		else
			JOptionPane.showMessageDialog(null, "Despesa encontrada!\n" + d);
		return d;
	}
	private static void cadastrarDespesa() {//incluir o tipo e subtipo de despesa
		boolean resposta;
		String descricao = JOptionPane.showInputDialog("Descrição");
		float valor = Float.parseFloat(JOptionPane.showInputDialog("Valor"));
		
		Despesas d = new Despesas(descricao, valor);
		resposta  = c.cadastrarDespesa(d);
		
		if (resposta){
			JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso");
			System.out.println(d);
		}
	}
	private static void removerDespesa(){
		Despesas d = pesquisarDespesa();
		boolean remocao = false;
		if(d != null){
			int opcao = JOptionPane.showConfirmDialog(null, 
					"Deseja mesmo deletar a despesa?", 
					"Deletar?", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE);
			if(opcao==JOptionPane.YES_OPTION){
				remocao=c.removerDespesa(d);
				if(remocao)
					JOptionPane.showMessageDialog(null,"Despesa removida com sucesso!");
				else
					JOptionPane.showMessageDialog(null, "Não foi possivel remover a despesa");
		}else
			JOptionPane.showMessageDialog(null,"Operação cancelada");
		}
	}
	private static void cadastrarAluno() {
		boolean resposta;
		String nome = JOptionPane.showInputDialog("Nome");
		String email = JOptionPane.showInputDialog("Email");
		float renda = Float.parseFloat(JOptionPane.showInputDialog("Renda"));
		
		Alunos a = new Alunos(nome, email,renda);
		resposta= c.cadastrarAluno(a);
		
		if(resposta)
			JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
			System.out.println(a);
		
	}
	private static Alunos pesquisarAluno(){
		String nome = JOptionPane.showInputDialog("Qual o nome do aluno?");
		Alunos a = c.pesquisarAluno(nome);
		if(a == null)
			JOptionPane.showMessageDialog(null, "Aluno  não encontrado!\n");
		else
			JOptionPane.showMessageDialog(null, "Aluno encontrado!\n" + a);
		
		return a;
		
	}
   private static void removerAluno(){
	   Alunos a = pesquisarAluno();
	   if (a != null){
		boolean remocao = false;
	   int opcao = JOptionPane.showConfirmDialog(null, 
				"Deseja mesmo deletar o aluno?", 
				"Deletar?", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE);
	   if(opcao == JOptionPane.YES_OPTION){
	       remocao = c.removerAluno(a);
	  
		if(remocao)
		   JOptionPane.showMessageDialog(null,"Aluno removido com sucesso!");
	   	else
	   		JOptionPane.showMessageDialog(null,"Não foi possível remover aluno");
	   }else 
		   JOptionPane.showMessageDialog(null,"Operação cancelada");
   }
   }
   private static void lerEmArquivo() {
		boolean resposta; 
		resposta = c.lerArquivo();
		if (resposta)
			JOptionPane.showMessageDialog(null, "Alunos lidos com sucesso");
	}

	private static void gravarEmArquivo() {
		boolean resposta = c.gravarAlunosEmArquivo();
		if (resposta) 
			JOptionPane.showMessageDialog(null, "Alunos gravados com sucesso");
	}
}
