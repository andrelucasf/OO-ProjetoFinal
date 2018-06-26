package estudante;

import javax.swing.JOptionPane;

public class Principal {
static Cadastramento c;
	
static final String[] opcoes = {
	"-------Selecione uma opção--------",
	"Cadastar aluno",
	"Remover aluno",
	"Gravar alunos em arquivo",
	"Ler alunos em arquivo",
	"Sair"
};
	public static void main(String[] args) {
		c = new Cadastramento();
		 
		Object opcao = JOptionPane.showInputDialog(
				null, 
				"Selecione uma opcao", 
				"Menu de cadastro", 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				opcoes,
				opcoes[0]);
		do{
		if(opcao.toString() == "Cadastar aluno")
			cadastrarAluno();
		    
	    if (opcao == "Remover aluno")
			removerAluno();
	    
	    if(opcao == "Gravar alunos em arquivo")
	    	gravarEmArquivo();
	    
	    if(opcao == "Ler alunos em arquivo")
	    	lerAlunosDeArquivo();
		    
	    opcao = JOptionPane.showInputDialog(
				null, 
				"Selecione uma opcao", 
				"Menu de cadastro", 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				opcoes,
				opcoes[0]);
		}while(opcao != "Sair");
		
		}
	private static void cadastrarAluno() {
		boolean resposta;
		String nome = JOptionPane.showInputDialog("Nome");
		String email = JOptionPane.showInputDialog("Email");
		int renda = Integer.parseInt(JOptionPane.showInputDialog("Renda"));
		
		Alunos a = new Alunos(nome, email, renda);
		resposta= c.cadastrarAluno(a);
		
		if(resposta)
			JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
			System.out.print(a);
		
	}
	private static Alunos pesquisarAluno(){
		String nome = JOptionPane.showInputDialog("Qual o nome do aluno?");
		Alunos a = c.pesquisarAluno(nome);
		JOptionPane.showMessageDialog(null, "Aluno encontrado!\n" + a);
		
		return a;
		
	}
   private static void removerAluno(){
	   Alunos a = pesquisarAluno();
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
	   }
	   else 
		   JOptionPane.showMessageDialog(null,"Operação cancelada");
   }
	
   private static void lerAlunosDeArquivo() {
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
