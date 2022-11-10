package gui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.BasicStatsModel;

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
     * @see gui.view.View#update(model.BasicStatsModel)
     */
    @Override
    public void update(BasicStatsModel model)
    {
        Double num = Double.parseDouble(jtfNumber.getText());
        model.addNumber(num);
    }

    @Override
    public JTextField getView(){
        return this.jtfNumber;
    }

    @Override
    public void reset(){
        jtfNumber.setText("");
    }
}




