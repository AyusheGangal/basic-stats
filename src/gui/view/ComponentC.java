package gui.view;
import javax.swing.JTextField;

import gui.BasicStats;
import model.BasicStatsModel;

public class ComponentC implements View{
    private JTextField jtfMean;

    public ComponentC()
    {
        jtfMean = new JTextField(5);
        jtfMean.setEditable(false);
    }

    @Override
    public void update(BasicStatsModel model) {
        double mean = BasicStats.mean(model.getArrayDouble());
	    jtfMean.setText("" + mean);
    }
}
