package classes;

import interfaces.*;
public class Juridica extends Contribuinte implements Estado{
  String CGC;
  Double gastoPessoal;
  Double gastoEquipamento;

  public Juridica(){
    super();
    CGC="";
    gastoPessoal=0.0;
    gastoEquipamento=0.0;
  }

  public Juridica(String nome, Double rendaBA, String cgc, Double gastoP, 
  Double gastoE){
    super(nome,rendaBA);
    this.CGC = cgc;
    this.gastoPessoal = gastoP;
    this.gastoEquipamento = gastoE;
  }

  public String getCGC() {
    return this.CGC;
  }
  public void setCGC(String cGC) {
    this.CGC = cGC;
  }

  public Double getGastoPessoal() {
    return this.gastoPessoal;
  }
  public void setGastoPessoal(Double gastoPessoal) {
    this.gastoPessoal = gastoPessoal;
  }

  public Double getGastoEquipamento() {
    return this.gastoEquipamento;
  }
  public void setGastoEquipamento(Double gastoEquipamento) {
    this.gastoEquipamento = gastoEquipamento;
  }
  
  @Override
  public String toString() {
    return super.toString()+String.format(
      "CGC: %s"+
      "\nGasto pessoal: R$%,.2f"+
      "\nGasto com equipamento: R$%,.2f",
      this.CGC,this.gastoPessoal,this.gastoEquipamento);
  }

  public Double arrecadaImpostos(){
    Double imposto = (this.getRendaBrutaAnual() - this.gastoPessoal - 
    this.gastoEquipamento);
    return imposto;
  }
}
