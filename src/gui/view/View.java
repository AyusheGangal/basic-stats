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
    Component jtfNumber = null;
    Component jbReset = null;
    Component jtfCount = null;
    Component jtfMean = null;
    Component jtfMedian = null;
    Component jtaNumbers = null;
    Component jbAdd = null;

    /**
     * Updates this View to visualize the current BasicStatsModel.
     *
     * @param model The current BasicStatsModel to be visualized
     */
    public void update(BasicStatsModel model);
}
