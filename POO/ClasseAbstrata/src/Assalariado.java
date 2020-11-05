public class Assalariado extends Empregado{
    private double salarioMensal;
    private double descontos;

    public Assalariado(){//constructor
        super();
        this.salarioMensal = 0.0;
        this.descontos = 0.0;
    }

    public Assalariado(String nome, String nomeDepartamento, double salMensal, double desconto){
        super(nome,nomeDepartamento);
        this.salarioMensal = salMensal;
        this.descontos = desconto;
    }

    //get and set
    public void setSalarioMensal(double salMensal){
        this.salarioMensal = salMensal;
    }
    public double getSalarioMensal(){
        return this.salarioMensal;
    }

    public void setDescontos(double desconto){
        this.descontos = desconto;
    }
    public double getDescontos(){
        return this.descontos;
    }

    public String toString(){
        String saida = "";
        saida = "\n\nAssalariado"+super.toString()+"\n"+String.format("Salario Mensal: $%,.2f - Descontos: $%,.2f - Salario: $%,.2f"
        ,this.salarioMensal, this.descontos, this.calculaSalario());
        return saida;
    }


    public double calculaSalario(){
        double salario = 0;
        salario = this.salarioMensal - this.descontos;
        return salario;
    }
}//Close Assalariado
