package gui.view;
import javax.swing.JTextField;

import model.BasicStatsModel;


/**
 * Class CountView implements View interface.
 * has methods update(), getView() and reset()
 * to manipulate the CountView which counts 
 * the number of elements added to the list of numbers in the App.
 * Is a leaf in the Composite Design Pattern.
 */
public class CountView implements View{
    private JTextField jtfCount;

    public CountView()
    {
        this.jtfCount = new JTextField(5);
	    this.jtfCount.setEditable(false);
    }

    /* (non-Javadoc)
     * Updates the CountView
     */
    @Override
    public void update(BasicStatsModel model) {
        int count = model.getArrayDouble().length;
	    jtfCount.setText("" + count);	
    }

    /* (non-Javadoc)
     * Returns the text value of the count which 
     * is found using the update method.
     */
    @Override
    public JTextField getView(){
        return this.jtfCount;
    }

    /* (non-Javadoc)
     * Resets the text value of the count which is 
     * found using the update method.
     */
    @Override
    public void reset(){
        jtfCount.setText("");
    }
}
