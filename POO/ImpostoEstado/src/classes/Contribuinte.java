package classes;

public abstract class Contribuinte {
  
  private Double rendaBrutaAnual;
  private String nome;

  public Contribuinte(){
    nome ="";
    rendaBrutaAnual=0.0;
  }

  public Contribuinte(String name, Double rendaBA){
    this.nome = name;
    this.rendaBrutaAnual = rendaBA;
  }

  public String getNome() {
    return this.nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  public Double getRendaBrutaAnual() {
    return this.rendaBrutaAnual;
  }
  public void setRendaBrutaAnual(Double rendaBrutaAnual) {
    this.rendaBrutaAnual = rendaBrutaAnual;
  }

  @Override
  public String toString() {
    return String.format("Nome: %s\nRenda Bruta Anual: R$%,.2f",this.getNome(),
    this.getRendaBrutaAnual());
  }
}

