package gui.view;
import javax.swing.JTextField;

import model.BasicStatsModel;

public class CountView implements View{
    private JTextField jtfCount;

    public CountView()
    {
        this.jtfCount = new JTextField(5);
	    this.jtfCount.setEditable(false);
    }

    @Override
    public void update(BasicStatsModel model) {
        int count = model.getArrayDouble().length;
	    jtfCount.setText("" + count);	
    }

    @Override
    public JTextField getView(){
        return this.jtfCount;
    }

    @Override
    public void reset(){
        jtfCount.setText("");
    }
}
