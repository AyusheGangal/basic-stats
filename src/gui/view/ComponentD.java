package gui.view;
import javax.swing.JTextArea;

import model.BasicStatsModel;

public class ComponentD implements View{
    private JTextArea jtaNumbers;
    
    public ComponentD()
    {
        jtaNumbers = new JTextArea(10,50);
        jtaNumbers.setEditable(false);
    }

    @Override
    public void update(BasicStatsModel model) {
        double num = model.getArrayDouble()[model.getArrayDouble().length - 1];
	    jtaNumbers.append(num + ","); 
    }

}
