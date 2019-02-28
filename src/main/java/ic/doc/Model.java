package ic.doc;

import ic.doc.GuiApp.View;
import java.util.Stack;

public class Model {
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
    view.updateUI(currentOutput);
  }

  public void evaluate(String operation) {

    if (stack.size() < 2) { return; }

    Integer firstOperand = stack.pop();
    Integer secondOperand = stack.pop();
    if(operation == "+") {
      currentOutput = stack.push(firstOperand + secondOperand);
    } else {
      currentOutput = stack.push(secondOperand - firstOperand);
    }
    updateUI();
  }
}
