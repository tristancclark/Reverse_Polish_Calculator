package ic.doc;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class ModelTest {

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  Updatable view = context.mock(Updatable.class);

  private Model polishCalc = new Model();

  @Test
  public void addingNumberToStackUpdatesOneObserverInObserverList() {

    context.checking(new Expectations() {{
      exactly(1).of(view).updateUI(5);
    }});

    polishCalc.addObserver(view);
    polishCalc.addNumberToStack(5);
  }

  @Test
  public void addingNumberToStackUpdatesMultipleObserversInObserverList() {

    context.checking(new Expectations() {{
      exactly(3).of(view).updateUI(5);

    }});

    polishCalc.addObserver(view);
    polishCalc.addObserver(view);
    polishCalc.addObserver(view);
    polishCalc.addNumberToStack(5);
  }

  @Test
  public void nothingHappensWhenUsingOperandsOnEmptyList() {

    context.checking(new Expectations() {{
      never(view);

    }});

    polishCalc.addObserver(view);
    polishCalc.evaluate("+");
  }

  @Test
  public void passingPlusSignToEvaluateUpdatesViewerWithSumOfTopTwoNumberOnStack() {

    context.checking(new Expectations() {{
      exactly(1).of(view).updateUI(5);
      exactly(1).of(view).updateUI(3);
      exactly(1).of(view).updateUI(8);
    }});

    polishCalc.addObserver(view);
    polishCalc.addNumberToStack(5);
    polishCalc.addNumberToStack(3);
    polishCalc.evaluate("+");
  }




}
