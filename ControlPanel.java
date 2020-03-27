package lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The ControlPanel class is for managing the image being created.
 * This panel contains the buttons: Load, Save, Reset, Exit
 */
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }

    /** @init
     * Se initializeaza Control Panel ce va avea butoanele de Load, Save, Reset si Exit.
     * adaugam butoanele;
     * configuram listeners pentru toate butoanele;
     */
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
}

    /**@save
     * Salveaza imaginea intr-o locatie predefinita
     */
    private void save(ActionEvent e) {
        try{
            ImageIO.write(frame.canvas.image,"PNG", new File("d:/test.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**@load
     * cu JFileChooser alegem fisierul pe care vrem sa il incarcam
     */
    private void load(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                BufferedImage image = ImageIO.read(selectedFile);
                this.frame.canvas.image = image;
                this.frame.canvas.graphics = image.createGraphics();
            }
            } catch(IOException ex){
                System.err.println(ex);
            }
        }

        /**@reset
     * Aceasta metoda initializeza si umple canvas-ul cu alb
     */
    private void reset(ActionEvent e) {
        try {
            this.frame.canvas.image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
            this.frame.canvas.graphics = this.frame.canvas.image.createGraphics();
            this.frame.canvas.graphics.setColor(Color.WHITE);
            this.frame.canvas.graphics.fillRect(0, 0, 800, 600);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    /**@exit
     * Inchide fereastra.
     */
        private void exit(ActionEvent e) {
        try{
            System.exit(0);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    }

