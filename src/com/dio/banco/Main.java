package com.dio.banco;

public class Main {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Jose");
		
		Conta cc = new ContaCorrente(cliente1);
		cc.depositar(150);
		
		Conta cp = new ContaPoupanca(cliente1);
		
		
		cc.transferir(cp, 50);
		
		
		cc.imprimirExtrato();
		cp.imprimirExtrato();
		cc.encerrarConta(cc);

	}

}
