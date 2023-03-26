package Programas;

public class Pessoa {

    private static int counter = 1;
    private String nome;
    private String cpf;
    private String email;

    public Pessoa(String nome, String cpf, String email) {

        this.nome = nome;
        cpf = cpf;
        this.email = email;
        counter += 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "\nNome: " + this.getNome() +
                "\nCPF: " + this.getCPF() +
                "\nEmail " + this.getEmail();
    }
}
