public class Comissionado extends Empregado{
    private double brutoVendas;
    private double taxaComissao;
    private double bonus;

    public Comissionado(){
        super();
        this.brutoVendas = 0;
        this.taxaComissao = 0;
        this.bonus = 0;
    }

    public Comissionado(String nome, String nomeDepartamento, double brutoVenda, double taxaComis, double bonusV){
        super(nome, nomeDepartamento);
        this.brutoVendas = brutoVenda;
        this.taxaComissao = taxaComis;
        this.bonus = bonusV;
    }

    //get and set
    //brutoVendas
    public void setBrutoVendas(double brutoVendas) {
        this.brutoVendas = brutoVendas;
    }
    public double getBrutoVendas() {
        return this.brutoVendas;
    }

    //taxaComissao
    public void setTaxaComissao(double taxaComissao) {
        this.taxaComissao = taxaComissao;
    }
    public double getTaxaComissao() {
        return this.taxaComissao;
    }

    //Bonus
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public double getBonus() {
        return this.bonus;
    }

    //toString - exibição
    public String toString(){
        String saida = "";
        saida = "\n\nComissionado"+super.toString()+"\n"+String.format("Bruto Vendas: $%,.2f - Taxa de Comissao: $%,.2f%% "+
        "Bonus: %,.2f - Salario: $%,.2f",this.brutoVendas,this.taxaComissao,this.bonus,this.calculaSalario());
        return saida;
    }

    @Override
    public double calculaSalario() {
        double salario = 0;
        salario = (this.brutoVendas * (this.taxaComissao / 100)) + this.bonus;
        return salario;
    }

}
