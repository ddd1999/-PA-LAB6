package lab6;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * This class is for drawing various types of shapes
 * When the users executes mouse pressed operation, a shape is drawn at the mouse location.
 */
public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H=600;
    Color color = new Color(0,0,0,0);

    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }
    private void createOffscreenImage(){
        image= new BufferedImage(W,H,BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //FILLING THE IMAGE WITH WHITE
        graphics.fillRect(0,0,W,H);
    }

    /**@init
     * Initializam canvasul
     */
    public void init(){
        setPreferredSize(new Dimension(W,H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            }
        });
    }

    /**@drawShape
     * Pentru radius generam un numar random
     * Preluam din Configuration Panel numarul de laturi ale poligonului
     * Se creaza o culoare transparenta random pentru fiecare forma
     */
    private void drawShape(int x, int y){
        Random random = new Random();
        int radius= random.nextInt(100)+25;
        int sides= (int) this.frame.configPanel.sidesField.getValue();
        Random randomr = new Random();
        Random randomg = new Random();
        Random randomb = new Random();
        float r = randomr.nextFloat();
        float g = randomg.nextFloat();
        float b = randomb.nextFloat();
        color = new Color(r, g, b, .5f);
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x,y,radius,sides));
    }

    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, this);
    }
}
