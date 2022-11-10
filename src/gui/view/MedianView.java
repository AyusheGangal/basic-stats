package gui.view;
import javax.swing.JTextField;

import gui.BasicStats;
import model.BasicStatsModel;

public class MedianView implements View{
    private JTextField jtfMedian;

    public MedianView()
    {
        super();
        jtfMedian = new JTextField(5);
        jtfMedian.setEditable(false);
    }

    @Override
    public void update(BasicStatsModel model) {
        double median = BasicStats.median(model.getArrayDouble());
	    jtfMedian.setText("" + median);	
    }
}
