package classe;

import interfaces.*;
public class Empregado implements Pagamento{
    private String matricula,nome;
    private double salario;

    public Empregado(){
        this.matricula = "";
        this.nome = "";
        this.salario = 0.0;
    }
    public Empregado(String matr, String nome, Double sal){
        this.matricula = matr;
        this.nome = nome;
        this.salario = sal;
    }

    //GET and SET
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMatricula() {
        return this.matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    public double getSalario() {
        return this.salario;
    }

    @Override
    public double getPagamento() {
        return getSalario();
    }

    @Override
    public String toString() {
        return String.format("\nMatricula: %s \nNome: %s \nSalario: $%,.2f",
        getMatricula(),getNome(),getSalario());
    }
}
