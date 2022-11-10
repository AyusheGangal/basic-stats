package gui.view;
import javax.swing.JTextField;

import gui.BasicStats;
import model.BasicStatsModel;

public class MaxView implements View{
    private JTextField jtfMax;

    public MaxView()
    {
        jtfMax = new JTextField(5);
        jtfMax.setEditable(false);
    }

    @Override
    public void update(BasicStatsModel model) {
        double max = BasicStats.max(model.getArrayDouble());
	    jtfMax.setText("" + max);
    }

    @Override
    public JTextField getView(){
        return this.jtfMax;
    }

    @Override
    public void reset(){
        jtfMax.setText("");
    }
}
