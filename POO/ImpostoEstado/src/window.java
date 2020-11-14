
/***************************************************************
* Students: Murilo Fuza da Cunha & Ivo Henrique 
* Course: Bachelor of Computer Science
*
* POO Project - Tax collection
*
* Compiler: openjdk 14.0.2 2020-07-14
* Operacional System: Manjaro - Kernel: Linux 5.4.74-1-MANJARO
*
* Use the code at will, we just ask you to reference us the creators in their academic work
***************************************************************/
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import components.*;
import interfaces.Estado;

public class window extends JFrame{
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private JMenuBar barramenu;
  private JMenu inserir, relatorio, sair;
  private JMenuItem insFisica,insJurica,insIPVA, sairP, cancelar, relatorioImp;
  private JDesktopPane aJanela;
  private ArrayList<Estado> lista = new ArrayList<Estado>();
  private JPanel fisica, juridica, ipva, painelf, painelj, paineli;
  public  Field cpf, gastoS, gastoE, cgc, gastoP, gastoEq, placa, marca, valorA;



  public window(){
    super("Calculadora de impostos");
    setLayout(new BorderLayout());
    aJanela = new JDesktopPane();
    aJanela.setLayout(new BorderLayout());

    barramenu = new JMenuBar();
    setJMenuBar(barramenu);

    inserir = new JMenu("Inserir");
    relatorio = new JMenu("Relatorio");
    sair = new JMenu("Sair");

    insFisica = new JMenuItem("Inserir P.Fisica");
    insJurica = new JMenuItem("Inserir P.Juridica");
    insIPVA = new JMenuItem("Inserir IPVA");
    inserir.add(insFisica);
    inserir.add(insJurica);
    inserir.add(insIPVA);

    sairP = new JMenuItem("Sair");
    cancelar = new JMenuItem("Cancelar");
    sair.add(sairP);
    sair.add(cancelar);

    relatorioImp = new JMenuItem("Gerar Relatorio");
    relatorio.add(relatorioImp);

    barramenu.add(inserir);
    barramenu.add(relatorio);
    barramenu.add(sair);

    eventosCadastro funcC = new eventosCadastro();
    insFisica.addActionListener(funcC);
    insJurica.addActionListener(funcC);
    insIPVA.addActionListener(funcC);

    eventosSair funcS = new eventosSair();
    sairP.addActionListener(funcS);

    eventosRelat funcR = new eventosRelat();
    relatorioImp.addActionListener(funcR);
  }

  private class eventosCadastro implements ActionListener{

    public void actionPerformed(ActionEvent event) {
      getContentPane().removeAll();
      if(event.getSource()==insFisica){
        fisica = new criaPainelF();
        getContentPane().add(fisica);
        pack();

      }
      else if(event.getSource()==insJurica){
        juridica = new criaPainelJ();
        getContentPane().add(juridica);
        pack();
      }
      else if(event.getSource()==insIPVA){
        ipva = new criaPainelIpva();
        getContentPane().add(ipva);
        pack();
      }
      revalidate();
      repaint();
    }
  }

  private class eventosSair implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent event) {
      if(event.getSource()==sairP){
        System.exit(0);
      }
      else if(event.getSource()==cancelar){
      }
    }
  }

  private class eventosRelat implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent event) {
      String saida = "";
      String titulo = "Relatorio Anual de Impostos";
      if(event.getSource()==relatorioImp){
        if(lista.isEmpty()){
          saida = "Lista Vazia";
      }else{

      }
      JTextArea textArea = new JTextArea(saida);
                textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);  
                scrollPane.setPreferredSize( new Dimension(300,180));
                JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.PLAIN_MESSAGE);
      }
    }

  }

  private class criaPainelF extends JPanel{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public criaPainelF() {
      painelf = new JPanel();
      painelf.setLayout(new BoxLayout(painelf, BoxLayout.Y_AXIS));
      cpf = new Field("CPF: ",12);
      gastoS = new Field("Gastos com Saude: ",10);
      gastoE = new Field("Gastos com Educacao: ",10);
      painelf.add(cpf);
      painelf.add(gastoS);
      painelf.add(gastoE);
      add(painelf, BorderLayout.CENTER);
    }
  }

  private class criaPainelJ extends JPanel{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public criaPainelJ() {
      painelj = new JPanel();
      painelj.setLayout(new BoxLayout(painelj, BoxLayout.Y_AXIS));
      cgc = new Field("CGC: ",12);
      gastoP = new Field("Gastos Pessoais: ",10);
      gastoEq = new Field("Gastos com Equipamento: ",10);
      painelj.add(cgc);
      painelj.add(gastoP);
      painelj.add(gastoEq);
      add(painelj, BorderLayout.CENTER);
    }
  }

  private class criaPainelIpva extends JPanel{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public criaPainelIpva() {
      paineli = new JPanel();
      paineli.setLayout(new BoxLayout(paineli, BoxLayout.Y_AXIS));
      placa = new Field("Placa: ",8);
      marca= new Field("Marca: ",1);
      valorA = new Field("Valor anual: ",10);
      paineli.add(placa);
      paineli.add(marca);
      paineli.add(valorA);
      add(paineli, BorderLayout.CENTER);
    }
  }

  public static void main(String[] args){
    window f = new window();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.pack();
      f.setLocationRelativeTo(null);
      f.setVisible(true);
  }
}
