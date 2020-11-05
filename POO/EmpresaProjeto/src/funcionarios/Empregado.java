package funcionarios;
public abstract class Empregado {
    private String nome;
    private String cargo;

    public Empregado(){
        nome="";
        cargo="";
    }

    public Empregado(String n, String c){//Construtor
        this.nome = n;
        this.cargo = c;
    }

    //metodo abstrato quero sera reescrito pelas subclasses
    public abstract double calcBonificaocao();

    //Get and set
    public void setNome( String n){
        this.nome = n;
    }
 
    public void setCargo( String c){
        this.cargo = c;
    }    

    public String getNome() {
        return this.nome;
    }

    public String getCargo() {
        return this.cargo;
    }
    //fim get and set

    //Metodo toString - apresentar nome e cargo
    public String toString(){
        String saida;
        saida = String.format("\n\nNome: %s\nCargo: %s",this.getNome(),this.getCargo());
        return saida;
    }
}
