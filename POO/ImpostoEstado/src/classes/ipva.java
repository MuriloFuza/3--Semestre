package classes;

import interfaces.Estado;

public class ipva implements Estado {
  String placaCarro;
  Character marcaCarro;
  Double valorAnual;

  public ipva(){
    this.placaCarro = "";
    this.marcaCarro = null;
    this.valorAnual = 0.0;
  }

  public ipva(String placa, Character marca, Double valorA){
    this.placaCarro = placa;
    this.marcaCarro = marca;
    this.valorAnual = valorA;
  }

  public String getPlacaCarro() {
    return this.placaCarro;
  }
  public void setPlacaCarro(String placaCarro) {
    this.placaCarro = placaCarro;
  }

  public Character getMarcaCarro() {
    return this.marcaCarro;
  }
  public void setMarcaCarro(Character marcaCarro) {
    this.marcaCarro = marcaCarro;
  }

  public Double getValorAnual() {
    return this.valorAnual;
  }
  public void setValorAnual(Double valorAnual) {
    this.valorAnual = valorAnual;
  }

  @Override
  public String toString() {
    return String.format("\n\nPlaca: %s\nMarca: %c\nValor Anual: %,.2f",this.placaCarro,this.marcaCarro,this.valorAnual);
  }

  @Override
  public Double arrecadaImpostos() {
    double imposto = 0;
    if(getMarcaCarro().equals("W")){
      imposto = 1000.00;
    }else if(getMarcaCarro().equals("G")){
      imposto = 1200.00;
    }else if(getMarcaCarro().equals("F")){
      imposto = 900.00;
    }else{
      imposto = 1500.00;
    }
    return imposto;
  }
  
}
