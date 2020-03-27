package lab6;

import javax.swing.*;

import static java.awt.BorderLayout.*;

/**
 * Se initializeaza aplicatia cu toate componentele ei:
 * Configuration Panel
 * Control Panel
 * Drawing Panel
 */

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame(){
        super("My Drawing Application");
        init();
    }

    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);

        add(canvas, CENTER);
        add(controlPanel,SOUTH);
        add(configPanel,NORTH);

        pack();
    }
}
