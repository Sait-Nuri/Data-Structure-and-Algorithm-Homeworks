package hw01;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * @author said
 * @version 1.0
 * @created 21-Feb-2014 12:01:18 AM
 */
public class VisualConsole implements VisualUserInterface {
        	
    private final JFrame frame = new JFrame("Visual Application via GUI");
    private static Visual visual;
    private static int ScreenWidth;
    private static int ScreenHeight;    
    private static final int FRAME_WIDTH = 650;    //Screen FRAME_WIDTH
    private static final int FRAME_HEIGHT = 480;   //Screen height   
    private BufferedReader br;
    private FileReader rd;
    private String line;
    private Canvas cnvs;
    
    public VisualConsole(){
        visual = new ArrayBasedVisual();
        drawPanel();

    }	

    public static void main(String[] args){
        //visual = new ArrayBasedVisual();
        //visual.loadData();
        VisualUserInterface vui = new VisualConsole();
        vui.command(); 
    }
    /**
     * 
     */
    @Override
    public void command(){
        Scanner ob=new Scanner(System.in);
        boolean flag = true;

        while(flag){
            System.out.println("Type your Commands: ");
            System.out.println("1-) load");
            System.out.println("2-) print");
            System.out.println("3-) clear");
            System.out.println("4-) exit");
            
            while(flag){
                System.out.print("Command: ");
                String cmd=ob.nextLine();
                
                if(cmd.equals("load")){
                    System.out.println("File has been read");
                    readFile();                    
                }else if(cmd.equals("print") ){
                    visualise();
                }else if(cmd.equals("clear") ){
                    clear();
                }else if(cmd.equals("exit") ){
                    
                    flag = false;
                }else{
                    System.out.println("\nInvalid command, try again...\n");
                }                   
            }
            System.exit(1);
        }
    }
    
    private void readFile() {
        try {        
            rd = new FileReader("file.txt");
            br = new BufferedReader(rd);

            while ((line = br.readLine()) != null) {
                    ArrayBasedVisual.pf = visual.parser(line);
                    visual.loadData();
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(VisualConsole.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\nFile couldn't found! Check the file location!\n");            
            System.exit(-1);
        } catch (IOException ex) {
            Logger.getLogger(VisualConsole.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
            
    }
    
    private void visualise() {
        
        if(rd == null){
            System.out.println("\nFile not loaded yet!\n");
        }else{
            cnvs = new Canvas(visual);
            frame.add(cnvs);
            cnvs.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
            cnvs.setVisible(true);     
        }
    }
    
    private void clear() {
        if(cnvs == null){
            System.out.println("\nFile not printed yet!\n");
        }else{
            cnvs.setVisible(false);
        }
    }
    
    private void drawPanel() {

// ******************* Detect Screen Resolution ***********************
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        ScreenWidth = gd.getDisplayMode().getWidth();
        ScreenHeight = gd.getDisplayMode().getHeight();
        
// ************************* Main Screen ******************************
        
        // Openning a new window
        frame.setBounds( (ScreenWidth/2)+150 - (FRAME_WIDTH/2), (ScreenHeight/2)-(FRAME_HEIGHT/2), FRAME_WIDTH, FRAME_HEIGHT);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }

}