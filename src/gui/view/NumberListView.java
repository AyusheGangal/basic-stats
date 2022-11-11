package gui.view;
import javax.swing.JTextArea;

import model.BasicStatsModel;

/**
 * Class NumberListView implements View interface.
 * has methods update(), getView() and reset()
 * to manipulate the NumberListView which displays all
 * the elements in the list of numbers added in the App.
 * Is a leaf in the Composite Design Pattern.
 */
public class NumberListView implements View{
    private JTextArea jtaNumbers;
    
    public NumberListView()
    {
        jtaNumbers = new JTextArea(10,50);
        jtaNumbers.setEditable(false);
    }

    /* (non-Javadoc)
     * Updates the NumberListView
     */
    @Override
    public void update(BasicStatsModel model) {
        double num = model.getArrayDouble()[model.getArrayDouble().length - 1];
	    jtaNumbers.append(num + ","); 
    }

    /* (non-Javadoc)
     * Returns the text area of the numbers added 
     * to the app using the update method.
     */
    @Override
    public JTextArea getView(){
        return this.jtaNumbers;
    }

    /* (non-Javadoc)
     * Resets the text area of the numbers added 
     * to the app using the update method.
     */
    @Override
    public void reset(){
        jtaNumbers.setText("");
    }
}
