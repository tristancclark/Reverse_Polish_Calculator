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


  class Model {
    private Stack<Integer> stack = new Stack<>();
    private View view;
    private Integer currentOutput;

    public Model(View view) {
      this.view = view;
    }

    public void addNumberToStack(Integer i) {
      stack.push(i);
      currentOutput = i;
      updateUI();
    }

    private void updateUI() {
      view.textField_answer.setText(currentOutput.toString());
    }

    public void evaluate(String operation) {
      Integer firstOperand = stack.pop();
      Integer secondOperand = stack.pop();
      if(operation == "+") {
        currentOutput = stack.push(firstOperand + secondOperand);
      }else {
        currentOutput = stack.push(secondOperand - firstOperand);
      }
      updateUI();
    }
  }


  class View {

    private JFrame frame = new JFrame("Reverse Polish Calculator");
    private JPanel panel = new JPanel();
    private JButton[] button_numbers = new JButton[4];
    private JButton button_plus = new JButton("+");
    private JButton button_minus = new JButton("-");
    private JTextField textField_answer = new JTextField(10);

    public View() {
      frame.setSize(300, 120);

      for(Integer i = 1; i < 5; i++) {
        button_numbers[i - 1] = new JButton(i.toString());
        panel.add(button_numbers[i - 1]);
      }
      panel.add(button_plus);
      panel.add(button_minus);
      panel.add(textField_answer);

      frame.add(panel);
      frame.setVisible(true);


//      CONTROLLER:
      for(Integer i = 1; i < 5; i++) {
        Integer finalI = i;
        button_numbers[i - 1].addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent actionEvent) {
            polishCalc.addNumberToStack(finalI);
          }
        });
      }

      button_plus.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
          polishCalc.evaluate("+");
        }
      });
    }
  }





}
