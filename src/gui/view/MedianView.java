package gui.view;
import javax.swing.JTextField;

import gui.BasicStats;
import model.BasicStatsModel;

/**
 * Class MedianView implements View interface.
 * has methods update(), getView() and reset()
 * to manipulate the MedianView which returns the mean of
 * the elements in the list of numbers in the App.
 * Is a leaf in the Composite Design Pattern.
 */
public class MedianView implements View{
    private JTextField jtfMedian;

    public MedianView()
    {
        super();
        jtfMedian = new JTextField(5);
        jtfMedian.setEditable(false);
    }

    /* (non-Javadoc)
     * Updates the MedianView
     */
    @Override
    public void update(BasicStatsModel model) {
        double median = BasicStats.median(model.getArrayDouble());
	    jtfMedian.setText("" + median);	
    }

    /* (non-Javadoc)
     * Returns the text value of median value which 
     * is found using the update method.
     */
    @Override
    public JTextField getView(){
        return this.jtfMedian;
    }

    /* (non-Javadoc)
     * Resets the text value of the median value which 
     * is found using the update method.
     */
    @Override
    public void reset(){
        jtfMedian.setText("");
    }
}
