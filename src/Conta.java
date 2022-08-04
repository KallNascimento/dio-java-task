public abstract class Conta implements IConta {

    private static int SEQUENCIAL = 1;
    private static final int AGENCIA_PADRAO = 1;
    protected int agencia;
    protected int numeroConta;
    protected double saldo;

    public Conta() {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo+=valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }
    protected void imprimirInfosComuns() {
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Conta: %d", numeroConta));
        System.out.println(String.format("Saldo: %.2f",saldo));
    }
}
