package funcionarios;
public class Engenheiro extends Empregado{
    private int qtdVistoria;
    private double vlVistoria;

    public Engenheiro(){
        super();
        this.qtdVistoria = 0;
        this.vlVistoria = 0.0;
    }
    
    public Engenheiro(String nome, String cargo, int qtd, double valor){
        super(nome,cargo);
        this.qtdVistoria = qtd;
        this.vlVistoria = valor;
    }

    //GET and Set
    public void setQtdVistoria(int qtdVistoria) {
        this.qtdVistoria = qtdVistoria;
    }
    public int getQtdVistoria() {
        return this.qtdVistoria;
    }

    public void setVlVistoria(double vlVistoria) {
        this.vlVistoria = vlVistoria;
    }
    public double getVlVistoria() {
        return vlVistoria;
    }
    //Fim GET and SET

    public String toString(){
        String saida = "";
        saida = super.toString()+"\n"+String.format("Vistorias: %d \nValor Vistorias: $%,.2f \nBonificacao: $%,.2f",this.qtdVistoria,this.vlVistoria,this.calcBonificaocao());
        return saida;
    }

    public  double calcBonificaocao(){
        double bonificacao = this.qtdVistoria * this.vlVistoria;
        return bonificacao;
    }
}
