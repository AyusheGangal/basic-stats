package gui.view;
import javax.swing.JTextField;

import model.BasicStatsModel;

public class CountView implements View{
    private JTextField jtfCount;

    public CountView()
    {
        jtfCount = new JTextField(5);
	    jtfCount.setEditable(false);
    }

    @Override
    public void update(BasicStatsModel model) {
        int count = model.getArrayDouble().length;
	    jtfCount.setText("" + count);	
    }
}
