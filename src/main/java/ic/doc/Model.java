package ic.doc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Model {

  private Stack<Integer> stack = new Stack<>();
  private Integer currentOutput;
  private final List<Updatable> views = new ArrayList<>();

  public void addObserver(Updatable view) {
    views.add(view);
  }

  public void addNumberToStack(Integer i) {
    stack.push(i);
    currentOutput = i;
    updateUI();
  }

  private void updateUI() {
    for (int i = 0; i < views.size(); i++) {
      views.get(i).update(currentOutput);
    }
  }

  public void evaluate(String operation) {

    if (stack.size() < 2) {
      return;
    }

    Integer firstOperand = stack.pop();
    Integer secondOperand = stack.pop();
    if (operation == "+") {
      currentOutput = stack.push(firstOperand + secondOperand);
    } else {
      currentOutput = stack.push(secondOperand - firstOperand);
    }
    updateUI();
  }
}
