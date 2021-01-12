package banco_superior.modelo;

public class ContaPoupanca implements IConta{
	
	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	public ContaPoupanca(String numeroConta, String agencia, String dataAbertura) {
		
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
				this.saldo >= (valorSacado+(valorSacado*TAXA_SACAR_CONTA_POUPANCA))) {
			this.saldo -= (valorSacado+(valorSacado*TAXA_SACAR_CONTA_POUPANCA));
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
		if(contaDestino instanceof ContaInvestimento)
		{
			this.sacar(valorTransferido+(valorTransferido*TAXA_ADM_CONTA_INVESTIMENTO));
			contaDestino.depositar(valorTransferido);
			
		}
		else if (contaDestino instanceof ContaCorrente) {
			this.sacar(valorTransferido+(valorTransferido*TAXA_ADM_CONTA_CORRENTE));
			contaDestino.depositar(valorTransferido);
		}
		else if(contaDestino instanceof ContaSalario) {
			this.sacar(valorTransferido+(valorTransferido*TAXA_ADM_CONTA_SALARIO));
			contaDestino.depositar(valorTransferido);
		}
		else {
			this.sacar(valorTransferido);
			contaDestino.depositar(valorTransferido);
		
		}
	}


	@Override
	public String toString() {
		return "ContaPoupanca [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo + ", status="
				+ status + ", dataAbertura=" + dataAbertura + "]";
	}
	
}