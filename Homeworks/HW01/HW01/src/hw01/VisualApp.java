package hw01;

import java.awt.Button;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author said
 * @version 1.0
 * @created 21-Feb-2014 12:01:18 AM
 */
public class VisualApp {

    //private static final JFrame window = new JFrame("Visual Application");
    //private static final Button buttonGUI = new Button("via GUI");
    //private static final Button buttonConsole = new Button("via Console");
    private static int ScreenWidth;
    private static int ScreenHeight;
    private static int BUTTONBOUNDWIDTH;
    private static final int FRAME_WIDTH = 640;    //Screen FRAME_WIDTH
    private static final int FRAME_HEIGHT = 480;   //Screen height
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 40;
    private static final String OS = System.getProperty("os.name").toLowerCase();
    
    public static void main(String[] args){
                
        // Main menu 
        final JFrame window = new JFrame("Visual Application");
        mainScreen(window);

//*********  Buttons to choosing running type **************
        
        BUTTONBOUNDWIDTH = (FRAME_WIDTH/2)-200;
                
        // Button to start the application via GUI                
        // Button to start the application via GUI
        final Button buttonGUI = new Button("via GUI");  
        buttonGUI.setBounds( (int) ((3/4.0)*BUTTONBOUNDWIDTH), (FRAME_HEIGHT-BUTTON_HEIGHT)/2, BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonGUI.setBackground(Color.GRAY);
        window.add(buttonGUI);  // Display buttonGUI on "window"
        
        final Button buttonConsole = new Button("via Console");
        buttonConsole.setBackground(Color.GRAY);
        buttonConsole.setBounds( (int) (1/4.0)*BUTTONBOUNDWIDTH + FRAME_WIDTH/2, 
                                 (FRAME_HEIGHT-BUTTON_HEIGHT)/2, BUTTON_WIDTH, BUTTON_HEIGHT);
       
        window.add(buttonConsole); // Display buttonConsole on "window"
        
        buttonGUI.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);

                String command;
                if (OS.indexOf("win") >= 0) {
                    command = "start gui.bat";
                }else if (OS.indexOf("nux") >= 0) {
                    command = "sh gui.sh";
                    Runtime run = Runtime.getRuntime();
                    try {
                        Process pr = run.exec(command);
                        pr.waitFor();
                    } catch (            IOException | InterruptedException ex) {
                        Logger.getLogger(VisualApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    run.exit(1);
                }
            }
        });

        // Button to start the application via Console
        
        
        buttonConsole.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);   
                String command;
                if (OS.indexOf("win") >= 0) {
                    command = "start console.bat";
                }else if (OS.indexOf("nux") >= 0) {
                    command = "sh console.sh";
                    Runtime run = Runtime.getRuntime();
                    try {
                        Process pr = run.exec(command);
                        pr.waitFor();
                    } catch (            IOException | InterruptedException ex) {
                        Logger.getLogger(VisualApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    run.exit(-1);                    
                }
                  
            }
        });
    }   
    
    /**
     * @param window 
     * Main frame in which choosing running type 
     */
    public static void mainScreen(JFrame window){

        // Get the screen resolutions
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        ScreenWidth = gd.getDisplayMode().getWidth();
        ScreenHeight = gd.getDisplayMode().getHeight();        

        // Openning a new window
        window.setBounds( (ScreenWidth/2) - (FRAME_WIDTH/2), (ScreenHeight/2)-(FRAME_HEIGHT/2), FRAME_WIDTH, FRAME_HEIGHT);
        window.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Selection of running type (via GUI or Console)
        JLabel mainJLabel = new JLabel("Select Running Type");
        mainJLabel.setBounds((FRAME_WIDTH/2)-(FRAME_WIDTH/6), (FRAME_HEIGHT/24), BUTTON_WIDTH, BUTTON_HEIGHT/2);
        mainJLabel.setForeground(Color.red);
        window.add(mainJLabel);

    }

}