import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class Janela extends JFrame implements ActionListener, ItemListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField vlSalM, vlDesc, vlBruto, vlTaxa,vlBonus, name, namedep,vlBase,vlHora,vlSalHora;
    private JLabel label1, label2, lbSalM,lbDesc,lbBrutoV,lbTxComi,lbBonus, lbSalBase, lbSalHora, lbHora;
    private JButton insere, exAssalariado, exComissionado,exHorista,exTodos,exComissionadoAssal;
    private JPanel norte, centro, sul;
    private JPanel horista, assalariado, comissionado, comissionadoAssal, empregado;
    private JRadioButton rdAssalariado, rdComissionado, rdComissionadoAssal,rdHorista;
    private ButtonGroup grupo, gruposul;
    private ArrayList<Empregado> lista = new ArrayList<Empregado>();

    public Janela(){

        super("Ficha Salarial");

        setLayout( new BorderLayout());
        norte = new JPanel(new FlowLayout());
        grupo = new ButtonGroup();
            rdAssalariado = new JRadioButton("Assalariado",true);
            rdComissionado = new JRadioButton("Comissionado",false);
            rdComissionadoAssal = new JRadioButton("Comissionado Assalariado",false);
            rdHorista = new JRadioButton("Horista",false);
        grupo.add(rdAssalariado);   grupo.add(rdComissionado);  grupo.add(rdComissionadoAssal); grupo.add(rdHorista);
        norte.add(rdAssalariado);   norte.add(rdComissionado);  norte.add(rdComissionadoAssal); norte.add(rdHorista);
        add(norte,BorderLayout.NORTH);

        centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));

        empregado = new JPanel( new GridLayout(2,2));
        label1 = new JLabel("Nome: ");
        label2 = new JLabel("Departamento: ");
        name = new JTextField(30);//nome
        namedep = new JTextField(30);//nome departamento
        empregado.add(label1); empregado.add(name); 
        empregado.add(label2); empregado.add(namedep);


        assalariado = new JPanel(new GridLayout(3,2));
        
        lbSalM = new JLabel("Salario Mensal: ");
        lbDesc = new JLabel("Desconto: ");

        vlSalM = new JTextField(10);//Salario mensal
        vlDesc = new JTextField(10);//desconto

        assalariado.add(lbSalM); assalariado.add(vlSalM);
        assalariado.add(lbDesc); assalariado.add(vlDesc);

        comissionado = new JPanel(new GridLayout(3,2));
        lbBrutoV = new JLabel("Vl bruto da Venda: ");
        lbTxComi = new JLabel("Taxa de comicao: ");
        lbBonus = new JLabel("Bonus: ");
        vlBruto = new JTextField(10);//Valor bruto da Venda
        vlTaxa = new JTextField(10);//Taxa de comicao
        vlBonus = new JTextField(10);//Bonus
        comissionado.add(lbBrutoV); comissionado.add(vlBruto);
        comissionado.add(lbTxComi); comissionado.add(vlTaxa);
        comissionado.add(lbBonus); comissionado.add(vlBonus);

        comissionadoAssal = new JPanel(new GridLayout(1,2));
        lbSalBase = new JLabel("Sal Base: ");
        vlBase = new JTextField(10);//Salario Base
        comissionadoAssal.add(lbSalBase); comissionadoAssal.add(vlBase);

        horista = new JPanel(new GridLayout(3,2));
        lbHora = new JLabel("Horas Trabalhadas: ");
        lbSalHora = new JLabel("Salario hora: ");
        vlHora = new JTextField(10);//Horas Trabalhadas
        vlSalHora = new JTextField(10);//Salario hora
        horista.add(lbHora); horista.add(vlHora);
        horista.add(lbSalHora); horista.add(vlSalHora);

        centro.add(empregado);
        centro.add(assalariado);
        centro.add(comissionado);
        comissionado.setVisible(false);
        centro.add(comissionadoAssal);
        comissionadoAssal.setVisible(false);
        centro.add(horista);
        horista.setVisible(false);

        add(centro,BorderLayout.CENTER);

        sul = new JPanel(new FlowLayout());
        gruposul = new ButtonGroup();
            insere = new JButton("Inserir");
            exAssalariado = new JButton("Ex Assalariado");
            exComissionado = new JButton("Ex Comissionado");
            exComissionadoAssal = new JButton("Ex Comissi.Assalariado");
            exHorista = new JButton("Ex Horista");
            exTodos = new JButton("Ex Todos");
            
            gruposul.add(insere); gruposul.add(exAssalariado);gruposul.add(exComissionado);
            gruposul.add(exComissionadoAssal);gruposul.add(exHorista);gruposul.add(exTodos);
        sul.add(insere);
        sul.add(exAssalariado);
        sul.add(exComissionado);
        sul.add(exComissionadoAssal);
        sul.add(exHorista);
        sul.add(exTodos);

        add(sul,BorderLayout.SOUTH);
        //JRadioButton
        rdAssalariado.addItemListener(this);
        rdComissionado.addItemListener(this);
        rdComissionadoAssal.addItemListener(this);
        rdHorista.addItemListener(this);
        //JButton
        insere.addActionListener(this);
        exAssalariado.addActionListener(this);
        exComissionado.addActionListener(this);
        exComissionadoAssal.addActionListener(this);
        exHorista.addActionListener(this);
        exTodos.addActionListener(this);

        centro.setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10));

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==rdAssalariado){
            assalariado.setVisible(true);
            comissionado.setVisible(false);
            comissionadoAssal.setVisible(false);
            horista.setVisible(false);
        }
        if(e.getSource()==rdComissionado){
            assalariado.setVisible(false);
            comissionado.setVisible(true);
            comissionadoAssal.setVisible(false);
            horista.setVisible(false);
        }
        if(e.getSource()==rdComissionadoAssal){
            assalariado.setVisible(false);
            comissionado.setVisible(true);
            comissionadoAssal.setVisible(true);
            horista.setVisible(false);
        }
        if(e.getSource()==rdHorista){
            assalariado.setVisible(false);
            comissionado.setVisible(false);
            comissionadoAssal.setVisible(false);
            horista.setVisible(true);
        }
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent arg) {
        String saida = "";
        String titulo = "";
        if(arg.getSource() == insere){
            String nome, nomedep;
            Double sal, desc, bruto, taxa, bonus, salBase, salHora;
            int horas;
            Assalariado a = new Assalariado();
            Comissionado c = new Comissionado();
            ComissionadoAssalariado ca = new ComissionadoAssalariado();
            Horista h = new Horista();
            nome = name.getText();
            nomedep = namedep.getText();
          

            if(rdAssalariado.isSelected()){
                    String salmensal, descontos;
                    salmensal = vlSalM.getText();
                    descontos = vlDesc.getText();
                    try{
                        sal = Double.parseDouble(salmensal);
                        }catch(NumberFormatException erro){
                        sal = 1045.00;
                    }   
                    try{
                        desc = Double.parseDouble(descontos);
                        }catch(NumberFormatException erro){
                        desc = 100.0;
                    }  
                    a = new Assalariado(nome,nomedep,sal,desc);
                    lista.add(a);
                    JOptionPane.showMessageDialog(null, "Inserido com sucesso");

            }else if(rdComissionado.isSelected()){
                String vendaBruto,taxaComissao,bonusVenda;
                vendaBruto = vlBruto.getText();
                taxaComissao = vlTaxa.getText();
                bonusVenda = vlBonus.getText();

                try{
                    bruto = Double.parseDouble(vendaBruto);
                    }catch(NumberFormatException erro){
                    bruto = 0.0;
                }   
                try{
                    taxa = Double.parseDouble(taxaComissao);
                    }catch(NumberFormatException erro){
                    taxa = 0.0;
                }  
                try{
                    bonus = Double.parseDouble(bonusVenda);
                    }catch(NumberFormatException erro){
                    bonus = 0.0;
                }  
                c = new Comissionado(nome,nomedep,bruto,taxa,bonus);
                lista.add(c);
                JOptionPane.showMessageDialog(null, "Inserido com sucesso");
            }
            else if(rdComissionadoAssal.isSelected()){
                String vendaBruto,taxaComissao,bonusVenda, salarioB;
                vendaBruto = vlBruto.getText();
                taxaComissao = vlTaxa.getText();
                bonusVenda = vlBonus.getText();
                salarioB = vlBase.getText();

                try{
                    bruto = Double.parseDouble(vendaBruto);
                    }catch(NumberFormatException erro){
                    bruto = 0.0;
                }   
                try{
                    taxa = Double.parseDouble(taxaComissao);
                    }catch(NumberFormatException erro){
                    taxa = 0.0;
                }  
                try{
                    bonus = Double.parseDouble(bonusVenda);
                    }catch(NumberFormatException erro){
                    bonus = 0.0;
                }
                try{
                    salBase = Double.parseDouble(salarioB);
                    }catch(NumberFormatException erro){
                        salBase = 1045.0;
                }    
                ca = new ComissionadoAssalariado(nome,nomedep,bruto,taxa,bonus,salBase);
                lista.add(ca);
                JOptionPane.showMessageDialog(null, "Inserido com sucesso");
            }
            else if(rdHorista.isSelected()){
                String horasTrabalhadas, SalarioHora;
                horasTrabalhadas = vlHora.getText();
                SalarioHora = vlSalHora.getText();
                try{
                    horas = Integer.parseInt(horasTrabalhadas);
                    }catch(NumberFormatException erro){
                    horas = 0;
                }   
                try{
                    salHora = Double.parseDouble(SalarioHora);
                    }catch(NumberFormatException erro){
                    salHora = 0.0;
                }  
                h = new Horista(nome,nomedep,horas,salHora);
                lista.add(h);
                JOptionPane.showMessageDialog(null, "Inserido com sucesso");
            }
            limpar();
        }


        if(arg.getSource() == exAssalariado){
            titulo = "Registro de Assalariados";
            if(lista.isEmpty()){
                saida = "A lista está vazia";
            }else{
                for(int i = 0; i < lista.size(); i++){
                    if(lista.get(i) instanceof Assalariado){
                        saida += lista.get(i).toString();
                    } 
                }
            }

            JOptionPane.showMessageDialog(null, saida, titulo, JOptionPane.PLAIN_MESSAGE);
        }
        if(arg.getSource() == exComissionado){
            titulo = "Registro de Comissionados";
            if(lista.isEmpty()){
                saida = "A lista está vazia";
            }else{
            for(int i = 0; i < lista.size(); i++){
                if(lista.get(i) instanceof Comissionado){
                    saida += lista.get(i).toString();
                } 
            }
        }
            JOptionPane.showMessageDialog(null, saida, titulo, JOptionPane.PLAIN_MESSAGE);
        }
        if(arg.getSource() == exComissionadoAssal){
            titulo = "Registro de Comissionados Assalariados";
            if(lista.isEmpty()){
                saida = "A lista está vazia";
            }else{
            for(int i = 0; i < lista.size(); i++){
                if(lista.get(i) instanceof ComissionadoAssalariado){
                    saida += lista.get(i).toString();
                } 
            }
        }
            JOptionPane.showMessageDialog(null, saida, titulo, JOptionPane.PLAIN_MESSAGE);
        }
        if(arg.getSource() == exHorista){
            titulo = "Registro de Horistas";
            if(lista.isEmpty()){
                saida = "A lista está vazia";
            }else{
            for(int i = 0; i < lista.size(); i++){
                if(lista.get(i) instanceof Horista){
                    saida += lista.get(i).toString();
                } 
            }
        }
        JOptionPane.showMessageDialog(null, saida, titulo, JOptionPane.PLAIN_MESSAGE);
        }
        if(arg.getSource() == exTodos){
            titulo = "Todos Funcionarios cadastrados";
            if(lista.isEmpty()){
                saida = "A lista está vazia";
            }else{
            for(int i = 0; i < lista.size(); i++){
                    saida += lista.get(i).toString();
            }
        }
            JOptionPane.showMessageDialog(null, saida, titulo, JOptionPane.PLAIN_MESSAGE);
        }



    }

    public void limpar(){
        vlSalM.setText("");
        vlDesc.setText("");
        vlBruto.setText("");
        vlTaxa.setText("");
        vlBonus.setText("");
        name.setText("");
        namedep.setText("");
        vlBase.setText("");
        vlHora.setText("");
        vlSalHora.setText("");       
    }

    public static void main(String[] args){
        Janela f  = new Janela();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    
}
