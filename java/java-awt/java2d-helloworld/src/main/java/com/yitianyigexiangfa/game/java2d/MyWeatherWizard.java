package com.yitianyigexiangfa.game.java2d;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * @author Bill Lau
 * @date 2018-03-30
 */
public class MyWeatherWizard extends JApplet implements ChangeListener{

    MyWeatherPainter painter;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Bill Lau WW");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JApplet ap = new MyWeatherWizard();
        ap.init();
        ap.start();

        jFrame.add("Center", ap);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    @Override
    public void init() {
        UIManager.put("swing.boldMetal", Boolean.FALSE);
    }

    @Override
    public void start() {
        initComponents();
    }

    public BufferedImage loadImage(String name){
        String fileName = "images/weather-" + name + ".png";
        ClassLoader classLoader = MyWeatherWizard.class.getClassLoader();
        URL url = classLoader.getResource(fileName);
        BufferedImage image = null;
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public void initComponents(){
        setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("Temperature:"));
        JSlider jSlider = new JSlider(20, 100, 60);
        jSlider.setMinorTickSpacing(5);
        jSlider.setMajorTickSpacing(20);
        jSlider.setPaintLabels(true);
        jSlider.setPaintTicks(true);
        jSlider.addChangeListener(this);

        jPanel.add(jSlider);
        add("North", jPanel);

        painter = new MyWeatherPainter();
        painter.sun = loadImage("sun");
        painter.snow = loadImage("snow");
        painter.rain = loadImage("rain");
        painter.cloud = loadImage("cloud");
        painter.setTemperature(65);
        jPanel.add("Center", painter);
    }

    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider)e.getSource();
        painter.setTemperature(slider.getValue());
    }
}

class MyWeatherPainter extends Component{

    private int temperature = 65;
    String[] conditions = {"Snow", "Rain", "Cloud", "Sun"};
    BufferedImage snow = null;
    BufferedImage rain = null;
    BufferedImage cloud = null;
    BufferedImage sun = null;

    Color textColor = Color.yellow;
    String condStr = "";
    String fells = "";

    Composite alpha0 = null, alpha1 = null;
    BufferedImage image0 = null, image1 = null;


    public void setTemperature(int temperature) {
        this.temperature = temperature;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(450, 125);
    }

    void setupWeatherReport() {
        if (temperature <= 32) {
            setupImages(snow);
            setupText("Snow", null);
        } else if (temperature <= 40) {
            setupImages(32, 40, snow, rain);
            setupText("Snow", "Rain");
        } else if (temperature <= 50) {
            setupImages(rain);
            setupText("Rain", null);
        } else if (temperature <= 58) {
            setupImages(50, 58, rain, cloud);
            setupText("Rain", "Cloud");
        }  else if (temperature <= 65) {
            setupImages(cloud);
            setupText("Cloud", null);
        }  else if (temperature <= 75) {
            setupImages(65, 75, cloud, sun);
            setupText("Cloud", "Sun");
        } else {
            setupImages(sun);
            setupText("Sun", null);
        }
    }

    private void setupText(String text, String text2){
        if (temperature <= 32){
            textColor = Color.blue;
            fells = "Freezing";
        } else if(temperature <= 50){
            textColor = Color.green;
            fells = "Cold";
        } else if(temperature <=65){
            textColor = Color.yellow;
            fells = "Cool";
        } else if (temperature <=75){
            textColor = Color.orange;
            fells = "Warm";
        } else{
            textColor = Color.red;
            fells = "Hot";
        }
        condStr = text;
        if (text2 != null){
            condStr += "/" + text2;
        }
    }

    private void setupImages(BufferedImage image){
        alpha0 = null;
        alpha1 = null;
        image0 = image;
        image1 = null;
    }

    private void setupImages(int min, int max, BufferedImage i0, BufferedImage i1){
        float alpha = (max - temperature) / (float)(max - min);
        alpha0 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        alpha1 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1-alpha);
        image0 = i0;
        image1 = i1;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        Dimension size = getSize();

        Composite origComposite;
        setupWeatherReport();

        origComposite = g2.getComposite();
        if (alpha0 != null) g2.setComposite(alpha0);
        g2.drawImage(image0,
                0, 0, size.width, size.height,
                0, 0, image0.getWidth(null), image0.getHeight(null),
                null);
        if (image1 != null) {
            if (alpha1 != null) g2.setComposite(alpha1);
            g2.drawImage(image1,
                    0, 0, size.width, size.height,
                    0, 0, image1.getWidth(null), image1.getHeight(null),
                    null);
        }
        g2.setComposite(origComposite);

        // Freezing, Cold, Cool, Warm, Hot,
        // Blue, Green, Yellow, Orange, Red
        Font font = new Font("Serif", Font.PLAIN, 36);
        g.setFont(font);

        String tempString = fells + " " + temperature+"F";
        FontRenderContext frc = ((Graphics2D)g).getFontRenderContext();
        Rectangle2D boundsTemp = font.getStringBounds(tempString, frc);
        Rectangle2D boundsCond = font.getStringBounds(condStr, frc);
        int wText = Math.max((int)boundsTemp.getWidth(), (int)boundsCond.getWidth());
        int hText = (int)boundsTemp.getHeight() + (int)boundsCond.getHeight();
        int rX = (size.width-wText)/2;
        int rY = (size.height-hText)/2;

        g.setColor(Color.LIGHT_GRAY);
        g2.fillRect(rX, rY, wText, hText);

        g.setColor(textColor);
        int xTextTemp = rX-(int)boundsTemp.getX();
        int yTextTemp = rY-(int)boundsTemp.getY();
        g.drawString(tempString, xTextTemp, yTextTemp);

        int xTextCond = rX-(int)boundsCond.getX();
        int yTextCond = rY-(int)boundsCond.getY() + (int)boundsTemp.getHeight();
        g.drawString(condStr, xTextCond, yTextCond);
    }

}