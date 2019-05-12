package br.ufla.sistemas.cinema.classesBase;


public class Funcionario {
    private String nome;
    private int cpf;
    private int idade;
    private float salario;
    private String funcao;

    public Funcionario(String nome, int cpf, int idade, float salario, String funcao) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.salario = salario;
        this.funcao = funcao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public String getFuncao() {
        return funcao;
    }
    
    
}