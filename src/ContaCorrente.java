import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ContaCorrente {

    private double saldo;
    private List<Double> transacoes; // adicionar no projeto da conta bancaria
    private Map<String, String> chavesPix;
    private double limite;
    private String cor;

    public ContaCorrente(double saldoInicial, int idade) {
        this.saldo = saldoInicial;
        this.transacoes = new ArrayList<>();
        this.chavesPix = new HashMap<>();
        this.verificarIdade(idade);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setLimite(double limite) {
        if(limite < 0){
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void deposita(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
            }
            saldo += valor;
            transacoes.add(+valor);
            }

    public void saca(double valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para saque.");
            }
            saldo -= valor;
            transacoes.add(-valor);
            }

    
    public void exibirTransacoes() {
        System.out.println("Transações realizadas:");
        for (double transacao : transacoes) {
            System.out.println(transacao);
        }
    }

    public void adicionarChavePix(String chave, String descricao) {
        chavesPix.put(chave, descricao);
        System.out.println("Chave Pix adicionada: " + descricao);
    }

    public void removerChavePix(String chave) {
        if (chavesPix.containsKey(chave)) {
            chavesPix.remove(chave);
            System.out.println("Chave Pix removida.");
        } else {
            System.out.println("Chave não encontrada.");
        }
    }

    public void exibirChavesPix() {
        System.out.println("Chaves Pix cadastradas:");
        for (Map.Entry<String, String> chave : chavesPix.entrySet()) {
            System.out.println("Chave: " + chave.getKey() + " - " + chave.getValue());
        }
    }

    public void enviaPix(double valor, String chavePix) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Saldo insuficiente para envio.");
            }
        if (chavePix.length() == 11) {
            if (valor <= saldo + limite) {
                saldo -= valor;
                chavePix = "  ";
            }
        }
        transacoes.add(-valor);
    }

    public void verificarIdade(int idade) throws IllegalArgumentException {
        if (idade < 18) {
        throw new IllegalArgumentException("Idade deve ser maior que 18.");
        }
        }

    public String getCor() {
        return this.cor;
    }
}
