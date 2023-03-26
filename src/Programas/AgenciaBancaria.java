package Programas;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }
    public static void operacoes(){

        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                Depositar();
                break;
            case 3:
                 Sacar();
                 break;
                 case 4:
                     Transferir();
                     break;
            case 5:
                ListarContas();
                break;
            case 6:
                System.out.println("Valeu por usar nossa Agência!");
                System.exit(0);
            default:
                System.out.println("Essa Opção não é valida!");
                operacoes();
                break;

        }

    }

    public static void criarConta(){
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);
        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");

        operacoes();
    }

    private static Conta encontarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0){
            for(Conta c: contasBancarias) {
                if(c.getNumeroConta() == numeroConta){
                    conta = c;
                }

            }
        }
        return conta;
    }
    public static void Depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor você deseja depositar? ");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso!");

        } else {
            System.out.println("Conta Não foi encontrada!");

        }
        operacoes();
    }
    public static void Sacar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontarConta(numeroConta);

        if(conta != null){
            System.out.println("Qual valor deseja sacar?");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
        }else {
            System.out.println("Conta não encontrada!");
        }
        operacoes();
    }
public static void Transferir() {
        System.out.println("Número da conta do remetente: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontarConta(numeroContaRemetente);

        if(contaRemetente != null){
            System.out.println("Qual é número da conta do destinatário: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontarConta(numeroContaDestinatario);

            if(contaDestinatario != null){
                System.out.println("Qual é o valor da transferência: ");
                Double valor = input.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);

            } else {
                System.out.println("A conta para depósito não foi localizada!");
            }
        } else {
            System.out.println("Conta para transferência não foi localizada!");
        }
        operacoes();
     }
     public static void ListarContas() {
        if(contasBancarias.size() > 0){
            for (Conta conta: contasBancarias){
                System.out.println(conta);
            }
        }else {
            System.out.println("Não há contas cadastradas!");
        }
        operacoes();
     }
}

