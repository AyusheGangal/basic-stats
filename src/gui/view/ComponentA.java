package gui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.BasicStatsModel;

public class ComponentA implements View
{
    private JTextField jtfNumber;
    protected BasicStatsModel model;

    public ComponentA()
    {
        jtfNumber = new JTextField(5);
        jtfNumber.setEditable(true);
        JButton jbAdd = new JButton("Add number");
        jbAdd.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) 
        {
            Double num = Double.parseDouble(jtfNumber.getText());
            model.addNumber(num);
    }
        });
    }


    /* (non-Javadoc)
     * @see gui.view.View#update(model.BasicStatsModel)
     */
    @Override
    public void update(BasicStatsModel model)
    {
        // As there is nothing to update apart from resetting this textField
    }

    
}




