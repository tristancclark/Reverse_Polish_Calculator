package ic.doc;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.*;

public class GuiApp {

  Stack<Integer> stack = new Stack<>();

  public static void main(String[] args) {
    new GuiApp().display();
  }





  private void display() {

//    create jframe and set size
    JFrame frame = new JFrame("Reverse Polish Calculator");
    frame.setSize(300, 120);

//    create panel
    JPanel panel = new JPanel();

//    create buttons and add to panel
    JButton[] button_numbers = new JButton[4];
    for(Integer i = 1; i < 5; i++) {
      button_numbers[i - 1] = new JButton(i.toString());
      panel.add(button_numbers[i - 1]);
    }

    JButton button_plus = new JButton("+");
    JButton button_minus = new JButton("-");
    panel.add(button_plus);
    panel.add(button_minus);

//    create text field and add to panel
    JTextField textField_answer = new JTextField(10);
    panel.add(textField_answer);

//    add button listeners
    for(Integer i = 1; i < 5; i++) {
      button_numbers[i - 1].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
          textField_answer.setText("hello");
        }
      });
    }


//    add panel to frame and display
    frame.add(panel);
    frame.setVisible(true);
  }

}
