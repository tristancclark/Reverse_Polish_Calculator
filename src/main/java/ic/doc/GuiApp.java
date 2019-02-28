package ic.doc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiApp {

  public static void main(String[] args) {
    new GuiApp();
  }

  private View view = new View();
  private Model polishCalc = new Model();

  public GuiApp() {
    polishCalc.addObserver(view);
  }

  class View implements Updatable {

    private JFrame frame = new JFrame("Reverse Polish Calculator");
    private JPanel panel = new JPanel();
    private JButton[] buttonNumbers = new JButton[4];
    private JButton[] buttonOperands = new JButton[2];
    private JTextField textFieldAnswer = new JTextField(10);

    public View() {

      frame.setSize(300, 120);

      for (Integer i = 1; i < 5; i++) {
        buttonNumbers[i - 1] = new JButton(i.toString());
        panel.add(buttonNumbers[i - 1]);
      }

      buttonOperands[0] = new JButton("+");
      buttonOperands[1] = new JButton("-");

      panel.add(buttonOperands[0]);
      panel.add(buttonOperands[1]);
      panel.add(textFieldAnswer);

      frame.add(panel);
      frame.setVisible(true);


      //From here on the Controller is implemented:

      for (Integer i = 0; i < 4; i++) {
        buttonNumbers[i].addActionListener(e -> {
          polishCalc.addNumberToStack(Integer.valueOf(e.getActionCommand()));
        });
      }

      for (Integer i = 0; i < 2; i++) {
        buttonOperands[i].addActionListener(e -> {
          polishCalc.evaluate(e.getActionCommand());
        });
      }
    }

    @Override
    public void update(Integer currentOutput) {
      textFieldAnswer.setText(currentOutput.toString());
    }

  }

}
