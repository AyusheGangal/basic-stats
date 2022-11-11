import org.junit.Test;
import static org.junit.Assert.*;
import model.BasicStatsModel;
import gui.BasicStats;
import gui.view.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class BasicStatsTest {
    private static double EPS = 1e-9;
    BasicStatsModel model = new BasicStatsModel();

    AddNumberView addNumberView = new AddNumberView();
    CountView countView = new CountView();
    MaxView maxView = new MaxView();
    MeanView meanView = new MeanView();
    MedianView medianView = new MedianView();
    NumberListView numberListView = new NumberListView();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCentralTendency() {
        double[] numbers = {2, 2, 3, 3, 3, 4, 4};
        double mean   = BasicStats.mean(numbers);
        assertEquals (3, mean, EPS);
        double median = BasicStats.median(numbers);
        assertEquals (3, median, EPS);
        double mode   = BasicStats.mode(numbers);
        assertEquals (3, mode, EPS);
    }

    @Test
    public void testMedian() {
      //Median should be 8.0 since size is even
      /* double[] numbers = {1, 4, 7, 9, 11, 21}; */
      double[] numbers = {9, 11, 1, 4, 7, 21};

      double median = BasicStats.median(numbers);
      assertEquals(8.0, median, EPS);

      //Median should be 7 since size is odd
      double[] numbers2 = {9, 1, 4, 7, 21};
      median = BasicStats.median(numbers2);
      assertEquals(7, median, EPS);

      //Median should be 3 since size is 1
      double[] numbers3 = {3};
      median = BasicStats.median(numbers3);
      assertEquals(3, median, EPS);

      //Median should be 0 since size is 0
      double[] numbers4 = {};
      median = BasicStats.median(numbers4);
      assertEquals(0, median, EPS);
    }

    @Test
    public void testMode() {
      //Mode should be 1 since we are taking the first mode
      double[] numbers = {1, 4, 7, 9, 11, 21};
      double mode   = BasicStats.mode(numbers);
      assertEquals (1, mode, EPS);

      //Mode should be 4
      double[] numbers2 = {1, 4, 4, 7, 9, 11, 21};
      mode   = BasicStats.mode(numbers2);
      assertEquals (4, mode, EPS);

      //Mode should be 7
      double[] numbers3 = {4, 4, 7, 7, 7, 11, 11};
      mode   = BasicStats.mode(numbers3);
      assertEquals (7, mode, EPS);

      //Mode should be 7
      double[] numbers4 = {7};
      mode   = BasicStats.mode(numbers4);
      assertEquals (7, mode, EPS);

      //Mode should be 0
      double[] numbers5 = {};
      mode   = BasicStats.mode(numbers5);
      assertEquals (0, mode, EPS);
    }

    @Test
    public void testMax() {
      //Median should be 8.0 since size is even
      /* double[] numbers = {12, 23, 100, 3, 0, 11}; */
      double[] numbers = {12, 23, 100, 3, 0, 11};

      double max = BasicStats.max(numbers);
      assertEquals(100.0, max, EPS);

      //Max should be 3 since size is 1
      double[] numbers2 = {12};
      max = BasicStats.max(numbers2);
      assertEquals(12, max, EPS);

      //Median should be 0 since size is 0
      double[] numbers3 = {};
      max = BasicStats.max(numbers3);
      assertEquals(0, max, EPS);
    }

    @Test
    public void testMean() {
      //Median should be 8.0 since size is even
      /* double[] numbers = {12, 12, 22, 234, 102}; */
      double[] numbers = {12, 12, 22, 234, 102};

      double mean = BasicStats.mean(numbers);
      assertEquals(76.4, mean, EPS);

      //Max should be 3 since size is 1
      double[] numbers2 = {12, 12, 12, 12};
      mean = BasicStats.mean(numbers2);
      assertEquals(12, mean, EPS);

      //Max should be 3 since size is 1
      double[] numbers3 = {12};
      mean = BasicStats.mean(numbers3);
      assertEquals(12, mean, EPS);

      //Median should be 0 since size is 0
      double[] numbers4 = {};
      mean = BasicStats.mean(numbers4);
      assertEquals(0, mean, EPS);
    }

    @Test
    public void testInitialConfig()
    {
      // TODO document why this method is empty
      assertEquals("", addNumberView.getView().getText());
      assertEquals("", countView.getView().getText());
      assertEquals("", maxView.getView().getText());
      assertEquals("", meanView.getView().getText());
      assertEquals("", medianView.getView().getText());
      assertEquals("", numberListView.getView().getText());
    }

    @Test
    public void testResetAsInitialConfig()
    {
      // TODO document why this method is empty
      String addNumberViewBeforeReset = addNumberView.getView().getText();
      String countViewBeforeReset = countView.getView().getText();
      String maxViewBeforeReset = maxView.getView().getText();
      String meanViewBeforeReset = meanView.getView().getText();
      String medianBeforeReset = medianView.getView().getText();
      String numberListViewBeforeReset = numberListView.getView().getText();
      
      addNumberView.reset();
      countView.reset();
      maxView.reset();
      meanView.reset();
      medianView.reset();
      numberListView.reset();
      
      assertEquals(addNumberView.getView().getText(), addNumberViewBeforeReset);
      assertEquals(countView.getView().getText(), countViewBeforeReset);
      assertEquals(maxView.getView().getText(), maxViewBeforeReset);
      assertEquals(meanView.getView().getText(), meanViewBeforeReset);
      assertEquals(medianView.getView().getText(), medianBeforeReset);
      assertEquals(numberListView.getView().getText(), numberListViewBeforeReset);
    }

    @Test
    public void testAddNumberCompletes()
    {
      double number = 20.0;
      model.addNumber(number);
      double[] numbers = model.getArrayDouble();
      assertEquals(number, numbers[0], EPS);
    }    
    
    @Test
    public void testAddNumberFailsToCompletes()
    {
      Double number = null;
      exception.expect(IllegalArgumentException.class);
      exception.expectMessage("The number must be non-null.");
      model.addNumber(number);
    }    

    @Test
    public void TestCountView()
    {
      Double[] numbers = {134.0, 234.0, 22.0, 1.0 , 1092.0, 3.0, 23.0};
      //int count = numbers.length;

      for (int i = 0 ; i < numbers.length; i++) {
        model.addNumber(numbers[i]);
        
      
      double[] newNumbers = model.getArrayDouble();
      countView.update(model);
      
      assertEquals(newNumbers.length, Integer.parseInt(countView.getView().getText()));
    }


    }
}
