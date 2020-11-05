public class Horista extends Empregado{

    private int horasTrabalhadas;
    private double salarioHora;

public Horista(){ // constructor SEM parâmetros 
        super();
        this.salarioHora=0; this.horasTrabalhadas=0; 
    }

public Horista(String nome, String nd, int horasTrabalhadas, double salarioHora) {
        super(nome,nd);
        this.horasTrabalhadas = horasTrabalhadas;
        this.salarioHora = salarioHora;
    
    }

// metodo OBRIGATORIO devido a heranca da superClasse abstrata Empregado
public double calculaSalario() {
    if (this.horasTrabalhadas <= 40)
        return(horasTrabalhadas * salarioHora);
    else {
        int hsExtras = horasTrabalhadas - 40;
        return((salarioHora * 40) + (hsExtras * (salarioHora * 1.5)));
    }
}

//get and set
public double getSalarioHora() {
        return (this.salarioHora);
    }

public int getHorasTrabalhadas() {
        return(this.horasTrabalhadas);
    }

public void setSalarioHora(double salario) {
        this.salarioHora = salario;
    }
//get and set

public String toString() {
        String temp = "\n\nHorista "+super.toString()+ String.format(
        "\nHoras Trabalhadas = %d - Salario Hora = $%,.2f - Salario final = $%,.2f",
            this.getHorasTrabalhadas(),this.getSalarioHora(),this.calculaSalario());
    return (temp);
    } 
   
}