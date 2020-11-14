  
/***************************************************************
* Students: Murilo Fuza da Cunha
* Course: Bachelor of Computer Science
*
* POO Project - Registration of Invoices and employees
*
* Compiler: openjdk 11.0.8 2020-07-14
* Operacional System: Manjaro - Kernel: Linux 5.8.16-2-MANJARO
*
* Use the code at will, we just ask you to reference us the creators in their academic work
***************************************************************/

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import components.Field;
import classe.*;
import interfaces.*;

public class TelaGrafica extends JFrame implements ActionListener, ItemListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JRadioButton rdFatura, rdEmpregado;
    ButtonGroup grupo;
    JButton btInsere, btLista;
    Field num, desc, qtd, preco, matr, nome, sal;
    JPanel oeste,leste;
    ArrayList<Pagamento> Lista = new ArrayList<Pagamento>();

    public TelaGrafica(){
        super("Pagamentos");
        setLayout(new BorderLayout());
        
        //RadioButton
        rdFatura = new JRadioButton("Fatura");
        rdEmpregado = new JRadioButton("Empregado");
        grupo = new ButtonGroup();
        grupo.add(rdFatura);
        grupo.add(rdEmpregado);

        //Painel norte
        JPanel norte = new JPanel();
            norte.setLayout(new FlowLayout()); 
            norte.add(rdFatura);
            norte.add(rdEmpregado);
        add(norte, BorderLayout.NORTH);

        //Botões
        btInsere = new JButton("Inserir");
        btLista = new JButton("Listar");
        
        //Painel Sul
        JPanel sul = new JPanel();
        sul.setLayout(new FlowLayout());
        sul.add(btInsere);
        sul.add(btLista);
        add(sul, BorderLayout.SOUTH);

        //Painel oeste
        oeste = new JPanel();
        oeste.setLayout(new BoxLayout(oeste, BoxLayout.Y_AXIS));
        num = new Field("Numero da Fatura: ", 5);
        desc = new Field("Descricao: ",15);
        qtd = new Field("Quantidade: ", 5);
        preco = new Field("Preco por item: ", 10);
        oeste.add(num);
        oeste.add(desc);
        oeste.add(qtd);
        oeste.add(preco);
        add(oeste,BorderLayout.EAST);

        //Painel Leste
        leste = new JPanel();
        leste.setLayout(new BoxLayout(leste, BoxLayout.Y_AXIS));
        matr = new Field("Numero da Matricula: ", 5);
        nome = new Field("Nome: ",15);
        sal = new Field("Salario: ", 5);
        leste.add(matr);
        leste.add(nome);
        leste.add(sal);
        add(leste,BorderLayout.WEST);

        //Ações 
        btInsere.addActionListener(this);
        btLista.addActionListener(this);
        rdFatura.addItemListener(this);
        rdEmpregado.addItemListener(this);

        //Visibilidade de inicialização
        oeste.setVisible(false);
        leste.setVisible(false);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(rdFatura.isSelected()){
            oeste.setVisible(true);
            leste.setVisible(false);
        }
        if(rdEmpregado.isSelected()){
            oeste.setVisible(false);
            leste.setVisible(true);
        }
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Inserir
        if(e.getSource() == btInsere){
            if(rdFatura.isSelected()){
                int quant;
                double precos;
                
                try {
                    quant = Integer.parseInt(qtd.getValue());
                    precos = Double.parseDouble(preco.getValue());
                } catch (NumberFormatException erro) {
                    quant = 0;precos = 0.0;
                }
                Fatura f = new Fatura(num.getValue(),desc.getValue(),quant,precos);
                Lista.add(f);
                JOptionPane.showMessageDialog(null, "Fatura inserida com Sucesso!");
                limpar();
            }
            if(rdEmpregado.isSelected()){
                double salario;
                try {
                    salario = Double.parseDouble(sal.getValue());
                } catch (NumberFormatException erro) {
                    salario = 0.0;
                }
                Empregado ep = new Empregado(matr.getValue(),nome.getValue(),salario);
                Lista.add(ep);
                JOptionPane.showMessageDialog(null, "Empregado inserido com Sucesso!");
                limpar();
            }
        }
        //Listar
        if(e.getSource() == btLista){
            String titulo = "Listagem de Pagamentos";
            String saida = "";
            double total = 0.0;
            if(Lista.isEmpty()){
                saida = "Lista Vazia!";
            }else{
                for(Pagamento x:Lista){
                    saida += x.toString()+"\n";
                    total += x.getPagamento();
                }
                saida += "\nTotal de Pagamentos: $"+total;
            }
            JTextArea textArea = new JTextArea(saida);
                textArea.setBackground(Color.YELLOW);
                textArea.setFont(new Font("Arial", Font.BOLD, 12));
                textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);  
                scrollPane.setPreferredSize( new Dimension(120,300));
                JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void limpar(){
        num.resetValue(); 
        desc.resetValue(); 
        qtd.resetValue(); 
        preco.resetValue(); 
        matr.resetValue(); 
        nome.resetValue(); 
        sal.resetValue();
    }

    public static void main(String[] args){
        TelaGrafica f = new TelaGrafica();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
