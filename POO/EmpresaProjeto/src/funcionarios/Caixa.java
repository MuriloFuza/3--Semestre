package funcionarios;
public class Caixa extends Empregado{
    private double salario;
    private double bonus;

    public Caixa(){
        super();
        this.salario = 0.0;
        this.bonus = 0.0;
    }
    public Caixa(String nome, String cargo, Double sal, Double bon){
        super(nome,cargo);
        this.salario = sal;
        this.bonus = bon;
    }

    //GET and SET
    public double getSalario() {
        return this.salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getBonus() {
        return this.bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    //Fim GET and SET

    public String toString(){
        String saida = "";
        saida = super.toString()+String.format("\nSalario: $%,.2f \nBonus: $%,.2f \nBonificacao: $%,.2f",this.salario,this.bonus,this.calcBonificaocao());
        return saida;
    }

    public  double calcBonificaocao(){
        double bonificacao = this.salario + this.bonus;
        return bonificacao;
    }
}
