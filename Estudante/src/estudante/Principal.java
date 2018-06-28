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

static final String[] opcoesCategoria = {
	"-------Selecione uma categoria--------",
	"Residência (Água, luz, aluguel...)",
	"Telecomunicações",
	"Alimentação",
	"Lazer",
	"Outros"
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
		if(opcao == "Cadastrar aluno")
			cadastrarAluno();
	    if (opcao == "Remover aluno")
			removerAluno();
	    if(opcao == "Cadastrar despesa")
	    	cadastrarDespesa();
	    if(opcao =="Pesquisar aluno" )
	    	pesquisarAluno();
		if(opcao == "Remover despesa")
			removerDespesa();
		if(opcao == "Pesquisar despesa")
			pesquisarDespesa();
		if(opcao =="Ler em arquivo")
			lerEmArquivo();
		if(opcao =="Gravar em arquivo")
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
		int opcao=0;
		do{
		Object categoria = JOptionPane.showInputDialog(null, 
				"Selecione uma categoria", 
				"Menu de categoria", 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				opcoesCategoria,
				opcoesCategoria[0]);
		if(categoria == "Outros"){
			categoria = JOptionPane.showInputDialog("Digite o nome da categoria a ser cadastrada");
			JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso!");
		}
		String descricao = JOptionPane.showInputDialog("Descrição da despesa");
		float valor = Float.parseFloat(JOptionPane.showInputDialog("Valor da despesa"));
		
		
		Despesas d = new Despesas(descricao, valor,(String)categoria);
		resposta  = c.cadastrarDespesa(d);
		
		if (resposta){
			JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso");
			System.out.println(d);
		
		opcao = JOptionPane.showConfirmDialog(null, 
					"Deseja cadastrar outra despesa?", 
					"Cadastrar", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE);
		}
		}while(opcao != JOptionPane.NO_OPTION);
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
		int opcao=0;
		do{
		String nome = JOptionPane.showInputDialog("Nome");
		String email = JOptionPane.showInputDialog("Email");
		float renda = Float.parseFloat(JOptionPane.showInputDialog("Renda"));
		
		Alunos a = new Alunos(nome, email,renda);
		resposta= c.cadastrarAluno(a);
		
		if(resposta)
			JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
			System.out.println(a);
			
		 opcao = JOptionPane.showConfirmDialog(null, 
						"Deseja cadastrar outro aluno?", 
						"Cadastrar?", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE);
			
		}while(opcao != JOptionPane.NO_OPTION);
		
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
