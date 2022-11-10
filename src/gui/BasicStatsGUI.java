package gui;

import java.util.*;
import java.util.List;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import model.BasicStatsModel;
import gui.view.*;


/**
 * Create a simple GUI that includes:
 * - a text field and a button that allows the user to enter numbers.
 * - a button that allows the user to clear all entered numbers.
 * - a panel with labels and text fields for count, median, and mean.
 * - a text area that shows all numbers.
 *
 * For the MVC architecture pattern, these are the views and controllers.
 */
public class BasicStatsGUI
{
    public static final String APP_TITLE = "Simple stats";
    private static BasicStatsModel model = new BasicStatsModel();
    private JFrame jfMain = new JFrame(APP_TITLE);
	private List<View> Views = new ArrayList<View>();
	private AddNumberView addNumberView;

    public BasicStatsGUI() {	

	// Create the main frame of the application, and set size and position
	jfMain.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	jfMain.setSize(600,400);
	jfMain.setLocationRelativeTo(null);
	
	// Panel that shows stats about the numbers
	
	JPanel jpInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
	addNumberView = new AddNumberView();
	JButton jbAdd = new JButton("Add number");

	jbAdd.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
		{
			addNumberView.update(model);	
			update(model);
		}
	});

	jpInput.add(addNumberView.getView());
	jpInput.add(jbAdd);


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

	jpInput.add(jbReset);

	JPanel jpStats = new JPanel(new FlowLayout(FlowLayout.CENTER));
	View countView = new CountView();
	View meanView = new MeanView();
	View medianView = new MedianView();
	View maxView = new MaxView();

	jpStats.add(new JLabel("Numbers:"));
	jpStats.add(countView.getView());

	jpStats.add(new JLabel("Median:"));
	jpStats.add(medianView.getView());

	jpStats.add(new JLabel("Mean:"));
	jpStats.add(meanView.getView());

	jpStats.add(new JLabel("Max:"));
	jpStats.add(maxView.getView());

	jfMain.getContentPane().add(jpStats, BorderLayout.CENTER);
	
	// TextArea that shows all the numbers
	View numberListView = new NumberListView();
	jfMain.getContentPane().add(numberListView.getView(), BorderLayout.SOUTH);

	
	jfMain.getContentPane().add(jpInput, BorderLayout.NORTH);

	Views.add(countView);
	Views.add(meanView);
	Views.add(medianView);
	Views.add(numberListView);
	Views.add(maxView);
    }


	public void update(BasicStatsModel model) {
	if (model.getArrayDouble().length == 0) {
		for(View view: Views)
		{
			view.reset();
		}

		addNumberView.reset();
		
	}
	else {
		//
		for(View view: Views)
		{
			view.update(model);
		} 
	}
    }

    public void show() {
	// Show the frame
	jfMain.setVisible(true);
    }
    
}
