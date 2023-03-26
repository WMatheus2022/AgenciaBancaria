package Programas;

import javax.swing.*;
import java.util.ArrayList;


public class AgenciaBancaria {
  //  static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }
    public static void operacoes(){

        int operacao =
                Integer.parseInt(JOptionPane.showInputDialog("--- Selecione uma operação: ---" +
                        "|   Opção 1 - Criar conta   |" +
                        "|   Opção 2 - Depositar     |" +
                        "|   Opção 3 - Sacar         |" +
                        "|   Opção 4 - Transferir    |" +
                        "|   Opção 5 - Listar        |" +
                        "|   Opção 6 - Sair          |"
        ));
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
                JOptionPane.showInputDialog(null, "Obrigado por usar a nossa agência!");
                System.out.println("Valeu por usar nossa Agência!");
                System.exit(0);
            default:
                System.out.println("Essa Opção não é valida!");
                operacoes();
                break;
        }
    }
    public static void criarConta(){
        Pessoa pessoa = new Pessoa(null, null,null);

        pessoa.setNome(JOptionPane.showInputDialog("Nome:"));
        pessoa.setCPF(JOptionPane.showInputDialog("CPF:"));
        pessoa.setEmail(JOptionPane.showInputDialog("Email:"));

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        JOptionPane.showInputDialog(null,"Sua conta foi criada com sucesso!");

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
             int numeroConta =
                     Integer.parseInt(JOptionPane.showInputDialog("Número da conta para depósito!"));

        Conta conta = encontarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor você deseja depositar? ");
            Double valorDeposito =
                    Double.parseDouble(JOptionPane.showInputDialog(null,"Valor depósitado com sucesso!"));
            conta.depositar(valorDeposito);
            JOptionPane.showMessageDialog(null,"Valor depositado com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null,"Conta Não foi encontrada!");
        }
        operacoes();
    }
    public static void Sacar() {
        int numeroConta =
                Integer.parseInt(JOptionPane.showInputDialog("Número da conta de saque: "));

        Conta conta = encontarConta(numeroConta);

        if(conta != null){
            Double valorSaque =
                    Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar?"));
            conta.sacar(valorSaque);
        }else {
            JOptionPane.showMessageDialog(null,"Conta não encontrada!");
        }
        operacoes();
    }
public static void Transferir() {
        int numeroContaRemetente =
                Integer.parseInt(JOptionPane.showInputDialog("Número da conta do remetente: "));

        Conta contaRemetente = encontarConta(numeroContaRemetente);

        if(contaRemetente != null){
            int numeroContaDestinatario =
                    Integer.parseInt(JOptionPane.showInputDialog("Qual é número da conta do destinatário: "));

            Conta contaDestinatario = encontarConta(numeroContaDestinatario);

            if(contaDestinatario != null){
                Double valor =
                        Double.parseDouble(JOptionPane.showInputDialog("Qual é o valor da transferência: "));

                contaRemetente.transferir(contaDestinatario, valor);

            } else {
                JOptionPane.showMessageDialog(null,"A conta para depósito não foi localizada!");
            }
        } else {
            JOptionPane.showMessageDialog(null,"Conta para transferência não foi localizada!");
        }
        operacoes();
     }
     public static void ListarContas() {
        if(contasBancarias.size() > 0){
            for (Conta conta: contasBancarias){
              JOptionPane.showMessageDialog(null,conta);
            }
        }else {
            JOptionPane.showMessageDialog(null,"Não há contas cadastradas!");
        }
        operacoes();
     }
}

