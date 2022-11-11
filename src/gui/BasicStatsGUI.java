package gui;

import java.util.*;
import java.util.List;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import model.BasicStatsModel;
import gui.view.*;


/**
 * The BasicStatsModel class stores a list of Views. This class provides
 * the data representation for the Composite Design pattern and stores the controllers
 * of the MVC architecture pattern.
 * 
 * Create a simple GUI that includes:
 * - a text field and a button that allows the user to enter numbers.
 * - a button that allows the user to clear all entered numbers.
 * - a panel with labels and text fields for count, median, and mean.
 * - a text area that shows all numbers.
 *
 * For the MVC architecture pattern, these are the controllers.
 */

public class BasicStatsGUI
{
    public static final String APP_TITLE = "Simple stats";
    private static BasicStatsModel model = new BasicStatsModel();
    private JFrame jfMain = new JFrame(APP_TITLE);

	// List of all the Views or Leaf of the Composite Design Pattern.
	private List<View> Views = new ArrayList<View>();
	private AddNumberView addNumberView;

    public BasicStatsGUI() {	

	// Create the main frame of the application, and set size and position
	jfMain.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	jfMain.setSize(600,400);
	jfMain.setLocationRelativeTo(null);
	
	// Panel that shows stats about the numbers
	JPanel jpInput = new JPanel(new FlowLayout(FlowLayout.CENTER));

	// View which displays the number which is being added
	addNumberView = new AddNumberView();
	// Controller for the addNumberView View
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

	// Controller which resets the app
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
	
	// Panel which displays all the stats, created by adding separate views
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

	// Adding views to the List Views for easy updation
	Views.add(countView);
	Views.add(meanView);
	Views.add(medianView);
	Views.add(numberListView);
	Views.add(maxView);
    }


	/**
	 * Updates different views according to the length
	 * of the array of numbers passed.
	 * Will reset the app to intialConfig if Array length = 0
	 * @param model The BasicStatsModel
	 */
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
