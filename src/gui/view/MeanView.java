package gui.view;
import javax.swing.JTextField;

import gui.BasicStats;
import model.BasicStatsModel;

public class MeanView implements View{
    private JTextField jtfMean;

    public MeanView()
    {
        jtfMean = new JTextField(5);
        jtfMean.setEditable(false);
    }

    @Override
    public void update(BasicStatsModel model) {
        double mean = BasicStats.mean(model.getArrayDouble());
	    jtfMean.setText("" + mean);
    }

    @Override
    public JTextField getView(){
        return this.jtfMean;
    }

    @Override
    public void reset(){
        jtfMean.setText("");
    }
}
