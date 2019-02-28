package ic.doc;

import ic.doc.GuiApp.View;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class ModelTest {

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  View mockView = context.mock(View.class);

  private Model polishCalc = new Model(mockView);

  @Test
  public void addsNumberToStack() {
    polishCalc
  }


}
