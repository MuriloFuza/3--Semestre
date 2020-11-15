package classes;

import interfaces.*;
public class Fisica extends Contribuinte implements Estado{
  String CPF;
  Double gastoSaude;
  Double gastoEducacao;

  public Fisica(){
    super();
    CPF = "";
    gastoSaude = 0.0;
    gastoEducacao = 0.0;
  }

  public Fisica(String nome, Double rendaBA, String cpf, Double gastoS, 
  Double gastoE){
    super(nome,rendaBA);
    this.CPF = cpf;
    this.gastoSaude = gastoS;
    this.gastoEducacao = gastoE;
  }

  public String getCPF() {
    return this.CPF;
  }
  public void setCPF(String cPF) {
    this.CPF = cPF;
  }

  public Double getGastoSaude() {
    return this.gastoSaude;
  }
  public void setGastoSaude(Double gastoSaude) {
    this.gastoSaude = gastoSaude;
  }

  public Double getGastoEducacao() {
    return this.gastoEducacao;
  }
  public void setGastoEducacao(Double gastoEducacao) {
    this.gastoEducacao = gastoEducacao;
  }

  @Override
  public String toString() {
    return super.toString()+String.format(
      "CPF: %s"+
      "\nGasto com Saude: R$%,.2f"+
      "\nGasto com Educacao: R$%,.2f",
      this.CPF,this.gastoSaude,this.gastoEducacao);
  }

  @Override
  public Double arrecadaImpostos() {
    Double imposto = (this.getRendaBrutaAnual() - this.gastoSaude - 
    this.gastoEducacao);
    return imposto;
  }
}
