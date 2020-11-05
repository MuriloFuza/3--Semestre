package funcionarios;
public class Diretor extends Empregado{
    private double salarioFixo;
    private double txRendimento;
    private double gratificacoes;

    public Diretor(){
        super();
        this.salarioFixo = 0.0;
        this.txRendimento = 0.0;
        this.gratificacoes = 0.0;
    }
    public Diretor(String nome, String cargo, Double salfixo, double txRendi, double grati){
        super(nome,cargo);
        this.salarioFixo = salfixo;
        this.txRendimento = txRendi;
        this.gratificacoes = grati;
    }

    //GET and SET
    public double getSalarioFixo() {
        return this.salarioFixo;
    }
    public void setSalarioFixo(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public double getTxRendimento() {
        return this.txRendimento;
    }
    public void setTxRendimento(double txRendimento) {
        this.txRendimento = txRendimento;
    }

    public double getGratificacoes() {
        return this.gratificacoes;
    }
    public void setGratificacoes(double gratificacoes) {
        this.gratificacoes = gratificacoes;
    }

    public String toString(){
        String saida = "";
        saida = super.toString()+String.format("\nSalario: $%,.2f \nTaxa de Rendimento: $%,.2f%% \nGratificacoes: $%,.2f \nBonificacao: $%,.2f",this.salarioFixo,this.txRendimento,this.gratificacoes,this.calcBonificaocao());
        return saida;
    }

    public  double calcBonificaocao(){
        double bonificacao = this.salarioFixo + ((this.txRendimento/100) * gratificacoes);
        return bonificacao;
    }
}
