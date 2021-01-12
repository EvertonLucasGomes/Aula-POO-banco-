package banco_superior.modelo;

public class ContaCorrente implements IConta{
	
	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	public ContaCorrente(String numeroConta, String agencia, String dataAbertura) {
		
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
			System.err.println("Operação inválida, valor insuficiente para deposito");
		}
		else if(this.status == false)
		{
			System.err.println("Operação inválida, a conta está desativada");
		}
		else 
		{
			System.err.println("não foi possível concluira a operação");
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
				this.saldo >= (valorSacado+(valorSacado*TAXA_SACAR_CONTA_CORRENTE))) {
			this.saldo -= (valorSacado+(valorSacado*TAXA_SACAR_CONTA_CORRENTE));
		}
		else if(valorSacado <= 0)
		{
			System.err.println("Operação inválida, valor insuficiente");
		}
		else if(this.status == false)
		{
			System.err.println("Operação inválida, conta inativa");
			
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
		return "ContaCorrente [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo + ", status="
				+ status + ", dataAbertura=" + dataAbertura + "]";
	}
	
}