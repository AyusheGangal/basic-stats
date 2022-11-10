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
public class BasicStatsGUI implements View
{
    public static final String APP_TITLE = "Simple stats";

    private static BasicStatsModel model = new BasicStatsModel();
    //private JTextField jtfCount;
    //private JTextField jtfMedian;
    //private JTextField jtfMean;
    private JTextArea jtaNumbers;
	private JTextField jtfNumber;
    private JFrame jfMain = new JFrame(APP_TITLE);

	public List<View> Views = new ArrayList<View>();

    public BasicStatsGUI() {	

	// for(View view: Views){
	// 	System.out.println(view);
	// 	view.update(model);
	//}

	// Create the main frame of the application, and set size and position
	jfMain.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	jfMain.setSize(600,400);
	jfMain.setLocationRelativeTo(null);
	
	// Panel that shows stats about the numbers
	
	//jtfNumber = new JTextField(5);
	//jtfNumber.setEditable(true);

	//jtfCount = new JTextField(5);
	//jtfCount.setEditable(false);
	
	//jtfMedian = new JTextField(5);
	//jtfMedian.setEditable(false);
	
	//jtfMean = new JTextField(5);
	//jtfMean.setEditable(false);
	JPanel jpInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
	View addNumberView = new AddNumberView();
	JButton jbAdd = new JButton("Add number");
	addNumberView.update(model);
	jbAdd.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
		{
			addNumberView.update(model);	
			update(model);
	}
		});

	jpInput.add(addNumberView.jtfNumber);
	jpInput.add(jbAdd);

	View resetView = new ResetView();
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
	//addNumberView.update(model);
	//resetView.update(model);

	jpInput.add(resetView.jbReset);

	JPanel jpStats = new JPanel(new FlowLayout(FlowLayout.CENTER));
	View countView = new CountView();
	View meanView = new MeanView();
	View medianView = new MedianView();

	jpStats.add(new JLabel("Numbers:"));
	jpStats.add(new JLabel("Median:"));
	jpStats.add(new JLabel("Mean:"));
	

	jpStats.add(countView.jtfCount);
	jpStats.add(meanView.jtfMean);
	jpStats.add(medianView.jtfMedian);

	jfMain.getContentPane().add(jpStats, BorderLayout.CENTER);
	
	// TextArea that shows all the numbers
	View numberListView = new NumberListView();
	//jtaNumbers = new JTextArea(10,50);
	//jtaNumbers.setEditable(false);
	jfMain.getContentPane().add(numberListView.jtaNumbers, BorderLayout.SOUTH);


	
	// Panel with a text field/button to enter numbers and a button to reset the application



	
	
	jfMain.getContentPane().add(jpInput, BorderLayout.NORTH);

	//Views.add(addNumberView);
	Views.add(countView);
	Views.add(meanView);
	Views.add(medianView);
	Views.add(numberListView);
	//Views.add(resetView);
    }


	public void update(BasicStatsModel model) {
	if (model.getArrayDouble().length == 0) {
	 	Views.get(5);
	}
	else {
		//
		for(View view: Views)
		{
			view.update(model);
			System.out.println(Views);
		}
	    // // Update the displayed list of numbers
	    // double num = model.getArrayDouble()[model.getArrayDouble().length - 1];
	    // jtaNumbers.append(num + ",");
	    
	    // // Compute and set the count
	    // int count = model.getArrayDouble().length;
	    // jtfCount.setText("" + count);
	    
	    // // Compute and set the mean
	    // double mean = BasicStats.mean(model.getArrayDouble());
	    // jtfMean.setText("" + mean);
	    
	    // // Compute and set the median
	    // double median = BasicStats.median(model.getArrayDouble());
	    // jtfMedian.setText("" + median);	    
	}
    }

    public void show() {
	// Show the frame
	jfMain.setVisible(true);
    }
    
}
