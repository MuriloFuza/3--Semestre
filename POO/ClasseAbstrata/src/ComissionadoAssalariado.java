public class ComissionadoAssalariado extends Comissionado{
    private double salarioBase;

    public ComissionadoAssalariado(){
        super();
        this.salarioBase = 0.0;
    }

    public ComissionadoAssalariado(String  nome, String nomeDep, double brutoVenda, double taxaComis, double bonusV, double salarioB){
        super(nome,nomeDep,brutoVenda,taxaComis,bonusV);
        this.salarioBase = salarioB;
    } 

    //get and set
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    public double getSalarioBase() {
        return this.salarioBase;
    }

    public String toString(){
        String saida = "";
        saida = "\n\nComissionado Assalariado:"+super.toString()+"\n"+String.format("Salario base: $%,.2f - Salario Final: $%,.2f"
        ,this.salarioBase,this.calculaSalario());
        return saida;
    }

    public double calculaSalario(){
        double salario;
        salario = super.calculaSalario()+this.salarioBase;
        return salario;
    }
}