package gui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.BasicStatsModel;

public class ComponentB implements View {
    private JTextField jtfCount;
    private JTextField jtfMedian;
    private JTextField jtfMean;
    private JTextArea jtaNumbers;
	private JTextField jtfNumber;
    protected BasicStatsModel model;

    public ComponentB()
    {
        JButton jbReset = new JButton("Reset");
        jbReset.addActionListener(new ActionListener() {
        // The interface ActionListener defines a call-back method actionPerformed,
        // which is invoked if the user interacts with the GUI component -- in this
        // case, if the user clicks the button.
        public void actionPerformed(ActionEvent e) {
            // Clear the ArrayList and all text fields
            model.reset();

            update(model);
        }
            });
    }

    @Override
    public void update(BasicStatsModel model) {
        if (model.getArrayDouble().length == 0) {
            jtfNumber.setText("");
            jtaNumbers.setText("");
            jtfCount.setText("");
            jtfMedian.setText("");
            jtfMean.setText("");
        }
    }
}
