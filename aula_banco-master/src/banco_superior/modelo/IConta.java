package banco_superior.modelo;

public interface IConta {

	static final float TAXA_SACAR_CONTA_CORRENTE = 0.01f;
	static final float TAXA_SACAR_CONTA_POUPANCA = 0.02f;
	static final float TAXA_SACAR_CONTA_INVESTIOMENTO = 0.03f;
	static final float RENDIMENTO_CONTA_POUPANCA = 0.03f;
	static final float TAXA_ADM_CONTA_INVESTIMENTO = 0.05f;
	static final float TAXA_ADM_CONTA_POUPANCA = 0.04f;
	static final float TAXA_ADM_CONTA_CORRENTE = 0.035f;
	static final float TAXA_ADM_CONTA_SALARIO = 0.015f;
	

	public void depositar(float valorDepositado);
	
	public void desativarConta();
	
	public void ativarConta();
	
	public void sacar(float valorSacado);
	
	public void transferencia(IConta contaDestino, float valorTransferido);
	
	public String toString();
	
	
	
	
}
