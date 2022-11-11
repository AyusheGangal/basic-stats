package gui.view;
import javax.swing.JTextField;

import model.BasicStatsModel;

/**
 * Class AddNumberView implements View interface.
 * has methods update(), getView() and reset()
 * to manipulate the AddNumberView which adds a 
 * number to the list of numbers in the App.
 * Is a leaf in the Composite Design Pattern.
 */
public class AddNumberView implements View
{
    private JTextField jtfNumber;
    protected BasicStatsModel model;

    public AddNumberView()
    { 
        jtfNumber = new JTextField(5);
        jtfNumber.setEditable(true);
    }


    /* (non-Javadoc)
     * Updates the AddNumberView
     */
    @Override
    public void update(BasicStatsModel model)
    {
        Double num = Double.parseDouble(jtfNumber.getText());
        model.addNumber(num);
    }

    /* (non-Javadoc)
     * Returns the text value of number which
     * is added using the update method.
     */
    @Override
    public JTextField getView(){
        return this.jtfNumber;
    }

    /* (non-Javadoc)
     * Resets the text value of number which
     * is added using the update method.
     */
    @Override
    public void reset(){
        jtfNumber.setText("");
    }
}




