package banco_superior.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Cliente {

	String cpf;
	String nome;
	String dataNascimento;
	String email;
	
	HashSet<String> telefones = new HashSet<String>();
	
	private List<IConta> contas = new ArrayList<IConta>();
	
	public Cliente(String nome, String cpf, String dataNascimento, String email) {
		
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", email=" + email
				+ ", telefones=" + telefones + ", contas=" + contas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	protected void adicionarConta(IConta contaCliente) {
		this.contas.add(contaCliente);
		System.out.println("conta adicionada com sucesso");
	}
	
	public boolean contemConta(IConta contaCliente) {
		return this.contas.contains(contaCliente);
	}
	
	public void removerConta(IConta conta) {
		if(contas.contains(conta)) {
			contas.remove(conta);
			System.out.println("conta removida com sucesso!");
		}
		else
		{
			System.out.println("conta inexistente!");
		}
		
	}
	
	public void adicionarTelefone(String telefone) {
		this.telefones.add(telefone);
		System.out.println("telefone adicionado com sucesso!");
	}
	
	public void removerTelefone(String telefone) {
		if (telefones.contains(telefone)) {
			telefones.remove(telefone);
			System.out.println("telefone removido com sucesso");
		}
		else 
		{
			System.out.println("Este número de telefone não está na lista de telefones do cliente");
		}
	}
}
