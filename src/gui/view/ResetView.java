package gui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.BasicStatsModel;

public class ResetView implements View {
    private JTextField jtfCount;
    private JTextField jtfMedian;
    private JTextField jtfMean;
    private JTextArea jtaNumbers;
	private JTextField jtfNumber;
    protected BasicStatsModel model;

    public ResetView()
    {
    }

    @Override
    public void update(BasicStatsModel model) {
        jtfNumber.setText("");
        jtaNumbers.setText("");
        jtfCount.setText("");
        jtfMedian.setText("");
        jtfMean.setText("");
    }
}
