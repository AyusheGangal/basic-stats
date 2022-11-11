package gui.view;
import javax.swing.JTextField;

import gui.BasicStats;
import model.BasicStatsModel;

/**
 * Class MaxView implements View interface.
 * has methods update(), getView() and reset()
 * to manipulate the MaxView which returns the max of
 * the elements in the list of numbers in the App.
 * Is a leaf in the Composite Design Pattern.
 */
public class MaxView implements View{
    private JTextField jtfMax;

    public MaxView()
    {
        jtfMax = new JTextField(5);
        jtfMax.setEditable(false);
    }

    /* (non-Javadoc)
     *  Updates the MaxView
     */
    @Override
    public void update(BasicStatsModel model) {
        double max = BasicStats.max(model.getArrayDouble());
	    jtfMax.setText("" + max);
    }

    /* (non-Javadoc)
     * Returns the text value of max value which 
     * is found using the update method.
     */
    @Override
    public JTextField getView(){
        return this.jtfMax;
    }

    /* (non-Javadoc)
     * Resets the text value of the max value which 
     * is found using the update method.
     */
    @Override
    public void reset(){
        jtfMax.setText("");
    }
}
