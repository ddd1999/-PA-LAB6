package lab6;

import javax.swing.*;

/**
 * This class id used to introduce parameters regarding the shapes that will be drawn: the size, the number of sides, the stroke, etc.
 * I created the colorCombo containing the values: Random and Black
 */

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; //for drawing regular polygons
    JSpinner sidesField; //number of sides
    JComboBox colorCombo; //the color of the shape
    String[] color = new String[] {"Random", "Black"};

    public ConfigPanel(MainFrame frame){
        this.frame=frame;
        init();
    }

    /** @init
     * Se initializeaza Configuration Panel
     * The panel must contain at least one label and one input component for specifying the size of the component.
     */
    private void init(){
        label = new  JLabel("Number if sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        sidesField.setValue(6); //default number of sides
        colorCombo = new JComboBox(color);

        add(label);
        add(sidesField);
        add(colorCombo);
    }
}
