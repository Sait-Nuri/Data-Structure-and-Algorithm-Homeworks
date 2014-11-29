package hw01;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * @author said
 * @version 1.0
 * @created 21-Feb-2014 12:01:19 AM
 */
public class VisualGUI implements VisualUserInterface {

    private static Visual visual;
    public static JFrame window;
    public static final JButton load = new JButton("Load File");
    private static final JButton visualise = new JButton("Visualise");
    private static final JButton clr = new JButton("Clear"); 
    private static final JPanel cmdPanel = new JPanel();
    private static final JPanel drawPanel = new JPanel();
    private static int ScreenWidth;
    private static int ScreenHeight; 
    private static final int FRAME_WIDTH = 850;    //Screen FRAME_WIDTH
    private static final int FRAME_HEIGHT = 480;   //Screen height
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 40;
    private Canvas cnvs;
    private File file;
    private BufferedReader br;
    private String line = null;
        
    public VisualGUI(){ 
        visual = new ArrayBasedVisual();
        window = new JFrame();
        drawFrame();
    }

    public static void main(String[] args){
        // Load datas from file
        
        VisualUserInterface vui = new VisualGUI();        
        vui.command();
    }
    /**
     * 
     */
    @Override
    public void command(){
   
            load.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
              
                try {
                    JFileChooser fileChooser = new JFileChooser(new File("$HOME"));
                    fileChooser.showOpenDialog(VisualGUI.window);
                    file = fileChooser.getSelectedFile();
                    
                    if(!file.getName().equals("file.txt")){
                        throw new FileNotFoundException();
                    }
                    
                    br = new BufferedReader(new FileReader(file));   

                    while ((line = br.readLine()) != null) {                    
                        ArrayBasedVisual.pf = visual.parser(line);
                        visual.loadData();
                    }               
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found!");
                    System.exit(-1);
                } catch (IOException ex) {
                    Logger.getLogger(VisualGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                }
            });

            visualise.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(file == null){
                        
                    } else {       
                        cnvs = new Canvas(visual);
                        window.add(cnvs);
                        cnvs.setBounds(200, 0, 650, 480);
                        cnvs.setVisible(true);
                    }
                }
            });

            clr.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {                    
                    if(cnvs!=null){
                        cnvs.setVisible(false);
                    }
                }
            });
    }
    
    private void drawFrame() {
                        
        // Get the screen resolutions
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        ScreenWidth = gd.getDisplayMode().getWidth();
        ScreenHeight = gd.getDisplayMode().getHeight();        

        // Openning a new window
        
        window.setTitle("Drawing Panel");
        window.setBounds( (ScreenWidth/2) - (FRAME_WIDTH/2), (ScreenHeight/2)-(FRAME_HEIGHT/2), FRAME_WIDTH, FRAME_HEIGHT);
        window.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(cmdPanel);        
        window.add(drawPanel);
        
        cmdPanel.setLayout(null);
        cmdPanel.add(load);
        cmdPanel.add(visualise);
        cmdPanel.add(clr);
        
        cmdPanel.setBorder(new TitledBorder("Commands"));
        cmdPanel.setBounds(0, 0, 200, 480);
        cmdPanel.setBackground(Color.LIGHT_GRAY);
            
        drawPanel.setBounds(200, 0, 650, 480);
        drawPanel.setBackground(Color.WHITE);
        drawPanel.setLayout(null);
        drawPanel.setVisible(true);
        
        load.setBounds(25, 120, BUTTON_WIDTH, BUTTON_HEIGHT);
        visualise.setBounds(25, 220, BUTTON_WIDTH, BUTTON_HEIGHT);
        clr.setBounds(25, 320, BUTTON_WIDTH, BUTTON_HEIGHT);
        
        load.setBackground(Color.GRAY);
        visualise.setBackground(Color.GRAY);
        clr.setBackground(Color.GRAY);
    }
}