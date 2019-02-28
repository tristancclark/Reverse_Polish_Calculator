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
      exactly(1).of(view).updateUI(4);
    }});

    polishCalc.addObserver(view);
    polishCalc.addNumberToStack(4);
  }

  @Test
  public void addingNumberToStackUpdatesMultipleObserversInObserverList() {

    context.checking(new Expectations() {{
      exactly(3).of(view).updateUI(4);

    }});

    polishCalc.addObserver(view);
    polishCalc.addObserver(view);
    polishCalc.addObserver(view);
    polishCalc.addNumberToStack(4);
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
  public void passingPlusSignToEvaluateFunctionUpdatesObserversWithCorrectNumber() {

    context.checking(new Expectations() {{
      exactly(1).of(view).updateUI(4);
      exactly(1).of(view).updateUI(3);
      exactly(1).of(view).updateUI(7);
    }});

    polishCalc.addObserver(view);
    polishCalc.addNumberToStack(4);
    polishCalc.addNumberToStack(3);
    polishCalc.evaluate("+");
  }

  @Test
  public void plusSignUsedMultipleTimesWorksDownStack() {

    context.checking(new Expectations() {{
      exactly(1).of(view).updateUI(4);
      exactly(1).of(view).updateUI(3);
      exactly(1).of(view).updateUI(2);
      exactly(1).of(view).updateUI(5);
      exactly(1).of(view).updateUI(9);
    }});

    polishCalc.addObserver(view);
    polishCalc.addNumberToStack(4);
    polishCalc.addNumberToStack(3);
    polishCalc.addNumberToStack(2);
    polishCalc.evaluate("+");
    polishCalc.evaluate("+");
  }

  @Test
  public void passingMinusSignToEvaluateFunctionUpdatesObserversWithCorrectNumber() {

    context.checking(new Expectations() {{
      exactly(1).of(view).updateUI(4);
      exactly(1).of(view).updateUI(3);
      exactly(1).of(view).updateUI(1);
    }});

    polishCalc.addObserver(view);
    polishCalc.addNumberToStack(4);
    polishCalc.addNumberToStack(3);
    polishCalc.evaluate("-");
  }

  @Test
  public void minusSignUsedMultipleTimesWorksDownStack() {

    context.checking(new Expectations() {{
      exactly(1).of(view).updateUI(4);
      exactly(1).of(view).updateUI(3);
      exactly(1).of(view).updateUI(2);
      exactly(1).of(view).updateUI(1);
      exactly(1).of(view).updateUI(3);
    }});

    polishCalc.addObserver(view);
    polishCalc.addNumberToStack(4);
    polishCalc.addNumberToStack(3);
    polishCalc.addNumberToStack(2);
    polishCalc.evaluate("-");
    polishCalc.evaluate("-");
  }

  @Test
  public void plusAndMinusUsedInConjunction() {

    context.checking(new Expectations() {{
      exactly(1).of(view).updateUI(4);
      exactly(1).of(view).updateUI(3);
      exactly(1).of(view).updateUI(2);
      exactly(1).of(view).updateUI(5);
      exactly(1).of(view).updateUI(-1);
    }});

    polishCalc.addObserver(view);
    polishCalc.addNumberToStack(4);
    polishCalc.addNumberToStack(3);
    polishCalc.addNumberToStack(2);
    polishCalc.evaluate("+");
    polishCalc.evaluate("-");
  }

  @Test
  public void nothingHappensWhenEvaluatingWithLessThanTwoNumbersOnStack() {

    context.checking(new Expectations() {{
      exactly(1).of(view).updateUI(4);
      exactly(1).of(view).updateUI(3);
      exactly(1).of(view).updateUI(7);
    }});

    polishCalc.addObserver(view);
    polishCalc.addNumberToStack(4);
    polishCalc.addNumberToStack(3);
    polishCalc.evaluate("+");
    polishCalc.evaluate("-");
  }


}
