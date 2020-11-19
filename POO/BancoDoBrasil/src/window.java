import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class window extends JFrame{
  

  public static void main (String[] args){
    window x = new window();
    x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    x.setLocationRelativeTo(null);
    x.pack();
    x.setVisible(true);
  }
}
