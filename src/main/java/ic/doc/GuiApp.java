package ic.doc;


import java.awt.SystemTray;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.*;

public class GuiApp {

  public static void main(String[] args) {
    new GuiApp();
  }

  private View view = new View();
  private Model polishCalc = new Model(view);


  class View {

    private JFrame frame = new JFrame("Reverse Polish Calculator");
    private JPanel panel = new JPanel();
    private JButton[] button_numbers = new JButton[4];
    private JButton[] button_operands = new JButton[2];
    private JTextField textField_answer = new JTextField(10);

    public View() {
      frame.setSize(300, 120);

      for(Integer i = 1; i < 5; i++) {
        button_numbers[i - 1] = new JButton(i.toString());
        panel.add(button_numbers[i - 1]);
      }

      button_operands[0] = new JButton("+");
      button_operands[1] = new JButton("-");

      panel.add(button_operands[0]);
      panel.add(button_operands[1]);
      panel.add(textField_answer);

      frame.add(panel);
      frame.setVisible(true);


//     From here on the Controller is Implemented:

      for(Integer i = 0; i < 4; i++) {
        button_numbers[i].addActionListener(e -> {
            polishCalc.addNumberToStack(Integer.valueOf(e.getActionCommand()));
        });
      }

      for(Integer i = 0; i < 2; i++) {
        button_operands[i].addActionListener(e -> {
          polishCalc.evaluate(e.getActionCommand());
        });
      }
    }

    public void updateUI(Integer currentOutput) {
      textField_answer.setText(currentOutput.toString());
    }
  }

class Controller {

}




}
