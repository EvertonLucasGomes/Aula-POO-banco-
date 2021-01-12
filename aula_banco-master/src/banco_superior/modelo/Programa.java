package banco_superior.modelo;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//System.out.println("Taxa de adm: "+Conta.TAXA_ADMINISTRACAO);
		
		IConta c1 = new ContaCorrente("111", "222", "15/06/2020");

		IConta c2 = new ContaPoupanca("122", "223", "15/08/2020");
		
		IConta c3 = new ContaInvestimento("565", "895", "25/01/2021");
		
		IConta c4 = new ContaSalario("445", "995", "25/12/2020");
		
		Cliente cliente1 = new Cliente("everton", "854561", "25/09/2000", "ellg15@hotmail.com");
		Cliente cliente2 = new Cliente("Gabriel", "415151", "04/08/1996", "grba@hotmail.com");
		
		cliente1.adicionarConta(c1);
		cliente1.adicionarConta(c3);
		cliente2.adicionarConta(c2);
		cliente2.adicionarConta(c4);
		
		cliente1.adicionarTelefone("99999-9888");
		cliente2.adicionarTelefone("98888-8888");

		System.out.println("CONTAS CRIADAS SEM SALDO: ");
		System.out.println(cliente1);
		System.out.println(cliente2);

		c1.depositar(1000f);
		c2.depositar(100f);
		
		System.out.println("CONTAS COM SALDO: ");
		System.out.println(cliente1);
		System.out.println(cliente2);
		
		
		c1.transferencia(c2, 100f);
		
		System.out.println("CONTAS APÓS TRANSFERÊNCIA: ");
		System.out.println(cliente1);
		System.out.println(cliente2);
		
		System.out.println(cliente1.contemConta(c3));
		System.out.println(cliente1.contemConta(c2));
		c4.transferencia(c2, 10f);
		
		

	}

}
