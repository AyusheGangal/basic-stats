package gui.view;
import javax.swing.JTextField;

import gui.BasicStats;
import model.BasicStatsModel;

/**
 * Class MeanView implements View interface.
 * has methods update(), getView() and reset()
 * to manipulate the MeanView which returns the mean of
 * the elements in the list of numbers in the App.
 * Is a leaf in the Composite Design Pattern.
 */
public class MeanView implements View{
    private JTextField jtfMean;

    public MeanView()
    {
        jtfMean = new JTextField(5);
        jtfMean.setEditable(false);
    }

    /* (non-Javadoc)
     * Updates the MeanView
     */
    @Override
    public void update(BasicStatsModel model) {
        double mean = BasicStats.mean(model.getArrayDouble());
	    jtfMean.setText("" + mean);
    }

    /* (non-Javadoc)
     * Returns the text value of mean value which 
     * is found using the update method.
     */
    @Override
    public JTextField getView(){
        return this.jtfMean;
    }

    /* (non-Javadoc)
     * Resets the text value of the mean value which 
     * is found using the update method.
     */
    @Override
    public void reset(){
        jtfMean.setText("");
    }
}
