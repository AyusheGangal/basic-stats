package gui.view;

import java.awt.Component;

import javax.swing.JTextField;

import model.BasicStatsModel;


/**
 * The View interface represents a visualization of the BasicStatsModel.
 * This interface supports the MVC architecture pattern.
 */
public interface View
{


    /**
     * Updates this View to visualize the current BasicStatsModel.
     *
     * @param model The current BasicStatsModel to be visualized
     */
    public void update(BasicStatsModel model);

    public Component getView();

    public void reset();
}
