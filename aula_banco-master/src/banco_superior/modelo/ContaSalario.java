package banco_superior.modelo;

public class ContaSalario implements IConta {
	
	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	public ContaSalario(String numeroConta, String agencia, String dataAbertura) {
		
		this.numeroConta = numeroConta;
		this.dataAbertura = dataAbertura;
		this.saldo = 0f;
		this.status = true;
		this.agencia = agencia;
		
	}
	

	@Override
	public void depositar(float valorDepositado) {
		if (valorDepositado>0 && this.status)
		{
			this.saldo += valorDepositado;
		}
		else if(valorDepositado <= 0)
		{
			System.err.println("Opera��o inv�lida, valor insuficiente para deposito");
		}
		else if(this.status == false)
		{
			System.err.println("Opera��o inv�lida, a conta est� desativada");
		}
		else 
		{
			System.err.println("n�o foi poss�vel concluira a opera��o");
		}
	}
		

	@Override
	public void desativarConta() {
		this.status = false;
		
	}

	@Override
	public void ativarConta() {
		this.status = true;
		
	}

	@Override
	public void sacar(float valorSacado) {
		if(valorSacado > 0 && this.status && 
				this.saldo >= valorSacado) {
			this.saldo -= valorSacado;
		}
		else if(valorSacado <= 0)
		{
			System.err.println("Opera��o inv�lida, valor insuficiente");
		}
		else if(this.status == false)
		{
			System.err.println("Opera��o inv�lida, conta inativa");
			
		}
		else 
		{
			System.err.println("Saldo insuficiente para efetuar saque");
		}
	}

	@Override
	public void transferencia(IConta contaDestino, float valorTransferido) {
		System.err.println("Este tipo de conta n�o faz transfer�ncia");
		
	}


	@Override
	public String toString() {
		return "contaSalario [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo + ", status="
				+ status + ", dataAbertura=" + dataAbertura + "]";
	}
	
	
}
