package ic.doc;


import javax.swing.*;

public class GuiApp {

  public static void main(String[] args) {
    new GuiApp().display();
  }

  private void display() {
    JFrame frame = new JFrame("Reverse Polish Calculator");
    frame.setSize(300, 200);

//    create panel
    JPanel panel = new JPanel();

//    create buttons
    J


    panel.add(new JButton("1"));
    panel.add(new JButton("2"));
    panel.add(new JButton("3"));
    panel.add(new JButton("4"));
    panel.add(new JButton("+"));
    panel.add(new JButton("-"));
    panel.add(new JTextField(10));



    frame.add(panel);



    frame.setVisible(true);
  }

}
