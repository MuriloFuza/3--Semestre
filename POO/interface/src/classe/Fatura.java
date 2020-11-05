package classe;

import interfaces.*;
public class Fatura implements Pagamento{
    private String ptNUmero,ptDesc;
    private int qtd;
    private double precoPorItem;

    public Fatura(){
        this.ptNUmero = "";
        this.ptDesc = "";
        this.qtd = 0;
        this.precoPorItem = 0.0;
    }

    public Fatura(String ptN, String ptD, int cont, double preco){
        this.ptNUmero = ptN;
        this.ptDesc = ptD;
        this.qtd = cont;
        this.precoPorItem = preco;
    }

    //GET and SET
    public void setPtNUmero(String ptNUmero) {
        this.ptNUmero = ptNUmero;
    }
    public String getPtNUmero() {
        return  this.ptNUmero;
    }

    public void setPtDesc(String ptDesc) {
        this.ptDesc = ptDesc;
    }
    public String getPtDesc() {
        return this.ptDesc;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public int getQtd() {
        return this.qtd;
    }

    public void setPrecoPorItem(double precoPorItem) {
        this.precoPorItem = precoPorItem;
    }
    public double getPrecoPorItem() {
        return this.precoPorItem;
    }

    //ToString - APresentação
    public String toString(){
        return String.format("%s %s: %s (%s) %s: %d %s: $%,.2f",
        "\nFatura ","\nNumero: ",getPtNUmero(), getPtDesc(),
        "\nquantidade: ",getQtd(),"\nPreco por Item: ",getPrecoPorItem());
    }

    public double getPagamento(){
        return getQtd() * getPrecoPorItem();
    }
}
