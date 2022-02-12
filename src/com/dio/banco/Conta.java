package com.dio.banco;

public abstract class Conta implements IConta {

	private static int AGENCIA_PADRAO = 0001;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public void sacar(double valor) {
		saldo = saldo - valor;

	}

	@Override
	public void depositar(double valor) {
		saldo = saldo + valor;

	}

	@Override
	public void transferir(Conta contaDestino, double valor) {
		this.sacar(valor);
		contaDestino.depositar(valor);

	}

	@Override
	public void encerrarConta(Conta conta) {
		if (conta.getSaldo() < 0) {
			System.out.println("A conta não pode ser encerrada com saldo negativo");
		} else if (conta.getSaldo() > 0) {
			System.out.println("Retire todo saldo para poder encerrar sua conta");
		} else {
			System.out.println("Conta encerrada...");
		}

	}
	
	@Override
	public String toString() {
		return "Conta [agencia=" + agencia + ", numero=" + numero + ", saldo=" + saldo + "]";
	}

	protected void ImprimirInfosComuns() {
		System.out.println("Titular: " + cliente.getNome());
		System.out.println(String.format("Agencia: %d", agencia));
		System.out.println(String.format("Numero: %d", numero));
		System.out.println(String.format("Saldo: %.2f", saldo));
	}

}
