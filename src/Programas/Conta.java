package Programas;

import Ultilitarios.Utils;

import javax.swing.*;

public class Conta {
    private static int contadorDeContas = 1;
    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public String toString(){
        return  "\nNúmero da conta: " + this.getNumeroConta() +
                "\nNome: " + this.pessoa.getNome() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nCPF: " + this.pessoa.getCPF() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            JOptionPane.showMessageDialog(null,"Seu deposito foi realizado com sucesso!");
        } else {
        JOptionPane.showMessageDialog(null,"Não foi possível realizar o seu deposito");
        }

    }
    public  void sacar(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() -  valor);
            JOptionPane.showMessageDialog(null,"Saca realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null,"Não foi possível realizar o saque");
        }
    }
    public  void  transferir(Conta coontaParaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            coontaParaDeposito.saldo = coontaParaDeposito.getSaldo() + valor;
            JOptionPane.showMessageDialog(null,"Transferência realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null,"Não foi possível realizar a transferência!");
        }
    }
}
