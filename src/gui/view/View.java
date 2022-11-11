package gui.view;

import java.awt.Component;

import model.BasicStatsModel;


/**
 * The View interface represents a visualization of the BasicStatsModel.
 * This interface supports the MVC architecture pattern with a Composite Design.
 * The views have been separated from the controllers using the Composite Design Pattern.
 * View interface is the Component class of the Composite Design Pattern. It has an update method,
 * a getView method of the type Component, and a reset method.
 */
public interface View
{


    /**
     * Updates this View to visualize the current BasicStatsModel.
     *
     * @param model The current BasicStatsModel to be visualized
     */
    public void update(BasicStatsModel model);

    /**
     * @return View Component
     */
    public Component getView();

    /**
     * Resets the View Component
     */
    public void reset();
}
