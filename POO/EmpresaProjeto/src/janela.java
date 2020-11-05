/***************************************************************
* Students: Murilo Fuza da Cunha & Ivo Henrique 
* Course: Bachelor of Computer Science
*
* POO Project - Registration of company members
*
* Compiler: openjdk 11.0.8 2020-07-14
* Operacional System: Manjaro - Kernel: Linux 5.8.16-2-MANJARO
*
* Use the code at will, we just ask you to reference us the creators in their academic work
***************************************************************/

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import funcionarios.*;
import components.*;

public class janela extends JFrame implements ActionListener, ItemListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JPanel pnCadastroF, pnBotoesF, padraoF, pnEngenheiro, pnDiretor, pnCaixa;//Paineis dos componentes
    JButton btCadastrar, btExibe;//Botões para exibir e cadastrar
    JComboBox<String> cbCargos;//Componente com a lista dos cargos
    JLabel lbCargos;
    Field txNome,txQtdVistorias,txVlVistorias, txSalario, txBonus, txSalFixo, txTxRendimento, txGratificacao;
    private ArrayList<Empregado> lista = new ArrayList<Empregado>();
    JScrollPane scrollPane;
    JTextArea textArea;
    String[] cargos = {"<Selecione um Cargo>","Engenheiro","Diretor","Caixa"};//Conteudo do ComboBox - Cargos 

    public janela(){
        super("Controle empresarial");
        setLayout(new BorderLayout());

        //Configuração dos paineis
        pnCadastroF = new JPanel();// Painel onde os funcionarios são cadastrados
        pnCadastroF.setLayout(new BoxLayout(pnCadastroF, BoxLayout.Y_AXIS));// Layout do painel funcionarios
        pnCadastroF.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        pnBotoesF = new JPanel(new FlowLayout());
        padraoF = new JPanel();
        padraoF.setLayout(new BoxLayout(padraoF, BoxLayout.Y_AXIS));
        pnEngenheiro = new JPanel();
        pnEngenheiro.setLayout(new BoxLayout(pnEngenheiro, BoxLayout.Y_AXIS));
        pnDiretor = new JPanel();
        pnDiretor.setLayout(new BoxLayout(pnDiretor, BoxLayout.Y_AXIS));
        pnCaixa = new JPanel();
        pnCaixa.setLayout(new BoxLayout(pnCaixa, BoxLayout.Y_AXIS));
        //FechaPaineis

        //Botões
        btCadastrar = new JButton("Cadastrar");
        btExibe = new JButton("Exibir Bonificacoes");
        //Fecha Botões

        //Painel Padrão
        cbCargos = new JComboBox<String>(cargos);
        cbCargos.setPreferredSize(new Dimension(9,18));
        cbCargos.setFont(new Font("Arial",Font.BOLD,11));
        txNome = new Field("Nome", 30);
        lbCargos = new JLabel("Cargo: ");
        JPanel comboBox = new JPanel(new GridLayout(1,2));
        comboBox.add(lbCargos);
        comboBox.add(cbCargos);
        padraoF.add(txNome);
        padraoF.add(comboBox);

        //Fim Painel Padrão

        //Painel engenheiro
        txQtdVistorias = new Field("Qtdade Vistorias", 30);
        txVlVistorias = new Field("Valor da Vistoria", 30);
        pnEngenheiro.add(txQtdVistorias);
        pnEngenheiro.add(txVlVistorias);
        //Fim Painel engenheiro

        //Painel Diretor
        txSalario = new Field("Salario", 30);
        txBonus = new Field("Bonus", 30);
        pnCaixa.add(txSalario);
        pnCaixa.add(txBonus);
        //Fim Painel Diretor

        //Painel Caixa
        txSalFixo = new Field("Salario Fixo: ", 30);
        txTxRendimento = new Field("Taxa de Rendimentos: ", 30);
        txGratificacao = new Field("Gratificacoes: ", 30);
        pnDiretor.add(txSalFixo);
        pnDiretor.add(txTxRendimento);
        pnDiretor.add(txGratificacao);
        //Fim Painel Caixa

        //Painel Botões
        pnBotoesF.add(btCadastrar);
        pnBotoesF.add(btExibe);
        //Fim Painel Botões

        //Adicionando Paineis a tela
        pnCadastroF.add(padraoF);
        pnCadastroF.add(pnEngenheiro); pnEngenheiro.setVisible(false);
        pnCadastroF.add(pnDiretor); pnDiretor.setVisible(false);
        pnCadastroF.add(pnCaixa); pnCaixa.setVisible(false);
        add(pnCadastroF,BorderLayout.NORTH);
        add(pnBotoesF, BorderLayout.SOUTH);

        //Ações dos botões
        cbCargos.addItemListener(this);
        btCadastrar.addActionListener(this);
        btExibe.addActionListener(this);
        //Fim Ações dos botões
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(cbCargos.getSelectedItem().equals("Engenheiro")){
            pnEngenheiro.setVisible(true);
            pnDiretor.setVisible(false);
            pnCaixa.setVisible(false);
        }
        if(cbCargos.getSelectedItem().equals("Diretor")){
            pnEngenheiro.setVisible(false);
            pnDiretor.setVisible(true);
            pnCaixa.setVisible(false);
        }
        if(cbCargos.getSelectedItem().equals("Caixa")){
            pnEngenheiro.setVisible(false);
            pnDiretor.setVisible(false);
            pnCaixa.setVisible(true);
        }
        if(cbCargos.getSelectedItem().equals("<Selecione um Cargo>")){
            pnEngenheiro.setVisible(false);
            pnDiretor.setVisible(false);
            pnCaixa.setVisible(false);
        }
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent arg) {
        String saida = "";
        String titulo = "";

        if(arg.getSource() == btCadastrar){
            String nome, cargo;
            int qtdVisto;
            Double valorVisto, sal, bonus, salFixo, txRendi, gratificacao;
            Engenheiro e = new Engenheiro();
            Caixa c = new Caixa();
            Diretor d = new Diretor();
            nome = txNome.getValue();
            cargo = cbCargos.getSelectedItem().toString();

            //Inserir sem cargo -- ERRO
            if(cbCargos.getSelectedItem()=="<Selecione um Cargo>"){
                titulo = "ERRO";
                saida = "ERRO - selecione um cargo!";
                limpar();
                JOptionPane.showMessageDialog(null, saida, titulo,JOptionPane.PLAIN_MESSAGE);
            }else{//Cargo Inserido
                    //Inserir um engenheiro
                    if(cbCargos.getSelectedItem()=="Engenheiro"){
                        if(txNome.getValue().equals("") | txQtdVistorias.getValue().equals("") | txVlVistorias.getValue().equals("")){
                            titulo = "ERRO";
                            saida = "ERRO - Preencha todos os campos!";
                            JOptionPane.showMessageDialog(null, saida, titulo,JOptionPane.PLAIN_MESSAGE);
                        }else{
                            String qtdVistori, vlVistori;
                            qtdVistori = txQtdVistorias.getValue();
                            vlVistori = txVlVistorias.getValue();
                            try {
                                qtdVisto = Integer.parseInt(qtdVistori); 
                            } catch (Exception erro) {
                                qtdVisto = 0;
                            }
                            try {
                                valorVisto = Double.parseDouble(vlVistori); 
                            } catch (Exception erro) {
                                valorVisto = 0.0;
                            }
                            e = new Engenheiro(nome,cargo,qtdVisto,valorVisto);
                            lista.add(e);
                            JOptionPane.showMessageDialog(null, "Engenheiro Inserido com sucesso");
                            limpar();
                        }
                    }
                    else if(cbCargos.getSelectedItem()=="Caixa"){
                        String salario, bon;
                        salario = txSalario.getValue();
                        bon = txBonus.getValue();
                        if(txNome.getValue().equals("") || txSalario.getValue().equals("") || txBonus.getValue().equals("")){
                            titulo = "ERRO";
                            saida = "ERRO - Preencha todos os campos!";
                            JOptionPane.showMessageDialog(null, saida, titulo,JOptionPane.PLAIN_MESSAGE);
                        }else{
                            try {
                                sal = Double.parseDouble(salario);
                            } catch (Exception erro) {
                                sal = 0.0;
                            }
                            try {
                                bonus = Double.parseDouble(bon);
                            } catch (Exception erro) {
                                bonus = 0.0;
                            }
                        c = new Caixa(nome,cargo,sal,bonus);
                        lista.add(c);
                        JOptionPane.showMessageDialog(null, "Caixa Inserido com sucesso");
                        limpar();
                        }  
                    }
                    else if(cbCargos.getSelectedItem()=="Diretor"){
                        String salarioFixo, taxaRendimento, gratificar;
                        salarioFixo = txSalFixo.getValue();
                        taxaRendimento = txTxRendimento.getValue();
                        gratificar = txGratificacao.getValue();
                        if(txNome.getValue().equals("") || txSalFixo.getValue().equals("")|| txTxRendimento.getValue().equals("") || txGratificacao.getValue().equals("")){
                            titulo = "ERRO";
                            saida = "ERRO - Preencha todos os campos!";
                            JOptionPane.showMessageDialog(null, saida, titulo,JOptionPane.PLAIN_MESSAGE);
                        }else{
                            try {
                                salFixo = Double.parseDouble(salarioFixo);
                            } catch (Exception erro) {
                                salFixo = 0.0;
                            }
                            try {
                                txRendi = Double.parseDouble(taxaRendimento);
                            } catch (Exception erro) {
                                txRendi = 0.0;
                            }
                            try {
                                gratificacao = Double.parseDouble(gratificar);
                            } catch (Exception erro) {
                                gratificacao = 0.0;
                            }
                        d = new Diretor(nome,cargo,salFixo,txRendi,gratificacao);
                        lista.add(d);
                        JOptionPane.showMessageDialog(null, "Diretor Inserido com sucesso");
                        limpar();
                        }
                    }
                }
            }
        //Exibir todos os funcionarios
        if(arg.getSource()==btExibe){
            titulo = "Bonificacoes";
            if(lista.isEmpty()){
                saida = "Lista Vazia";
            }else{
                for(int i =0; i < lista.size();i++){
                    saida += lista.get(i).toString();
                }
            }
            JTextArea textArea = new JTextArea(saida);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);  
            scrollPane.setPreferredSize( new Dimension(120,300));
            JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void limpar(){
        
        txNome.resetValue();
        txQtdVistorias.resetValue();
        txVlVistorias.resetValue();
        txSalario.resetValue();
        txBonus.resetValue();
        txSalFixo.resetValue();
        txTxRendimento.resetValue();
        txGratificacao.resetValue();  
    }

    public static void main(String[] args){
        janela f = new janela();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
