/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JPanel;

/**
 *
 * @author said
 */
public class Canvas extends JPanel{

    private final Visual vs;
    private final VisualData[] vd;
    public static int ORIGINX = 325;
    public static int ORIGINY = 200;
    
    public Canvas(Visual vs) {
        super();
        this.vs = vs;
        vd = vs.getData();
    }
    
    
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        Graphics2D g2d = (Graphics2D) g;
        setLayout(null);
        draw_crnt_panel(g2d); // Draw a coordinate panel
        draw_functions(g2d);
    }

    public void draw_functions(Graphics2D g2d) {
                
                        
        for(int i = 0; i < vd.length; i++){
            if(vd[i].getFunction().equals("sin(x)")){
                drawSin(vd[i].getRanges(), vd[i].getColor(), g2d);
            }else if (vd[i].getFunction().equals("cos(x)")){
                drawCos(vd[i].getRanges(), vd[i].getColor(), g2d);
            }else if (vd[i].getFunction().equals("x")) {
                drawX(vd[i].getRanges(), vd[i].getColor(), g2d);
            }else if (vd[i].getFunction().equals("x^2")){
                drawX2(vd[i].getRanges(), vd[i].getColor(), g2d);
            }else if (vd[i].getFunction().equals("log(x)")){
                drawLog(vd[i].getRanges(), vd[i].getColor(), g2d);
            }else if (vd[i].getFunction().equals("e^x")){
                drawEX(vd[i].getRanges(), vd[i].getColor(), g2d);
            }else if (vd[i].getFunction().equals("ln(x)")){
                drawLn(vd[i].getRanges(), vd[i].getColor(), g2d);
            }
        }
    }

  
    private void drawSin(double[] ranges, Color color, Graphics2D g2d) {
        g2d.setPaint(color);
        Polygon p = new Polygon(); 
        
        for(int x = (int) (ranges[0]*180.0/3); x <= (ranges[1]*180.0/3) ; x++){
            p.addPoint(ORIGINX + x, ORIGINY-(int)(100*Math.sin(x*Math.PI/180.0)));
            //System.out.println((int)(100*Math.sin(x*Math.PI/180.0)));
        }
        
        g2d.drawPolyline(p.xpoints, p.ypoints, p.npoints);
        
    }

    private void drawCos(double[] ranges, Color color, Graphics2D g2d) {
        g2d.setPaint(color);
        Polygon p = new Polygon(); 
        
        for(int x = (int)(ranges[0]*180.0/3); x <= (int)(ranges[1]*180.0/3) ; x++){
            p.addPoint(ORIGINX+x, ORIGINY-(int)(100*Math.cos(x*Math.PI/180.0)));
        }
        
        g2d.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }

    private void drawX(double[] ranges, Color color, Graphics2D g2d) {
        g2d.setPaint(color);
        Polygon p = new Polygon();
        
        for(int x = (int)ranges[0]; x <= (int)ranges[1] ; x++){
            p.addPoint(ORIGINX+(x*2), ORIGINY-(x*2));
            //System.out.println(x);
        }
        
        g2d.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }

    private void drawX2(double[] ranges, Color color, Graphics2D g2d) {
        
        g2d.setPaint(color);
        Polygon p = new Polygon();
        
        for(int x = (int)ranges[0]; x <= (int)ranges[1]; x++){
            p.addPoint(ORIGINX+x, ORIGINY-x);
        }
        
        g2d.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }

    private void drawLog(double[] ranges, Color color, Graphics2D g2d) {
        g2d.setPaint(color);
        Polygon p = new Polygon();        
        
        if(ranges[0] <= 0){
            ranges[0] = 1;
        }
        
        for (int x = (int)ranges[0]; x <= (int)ranges[1]; x++) {            
            p.addPoint( ORIGINX+(x*2), ORIGINY-(int)(Math.log10(x)*30) ); 
            //System.out.println(200-(int)(Math.log10(x)*10));
        }
        g2d.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }

    private void drawEX(double[] ranges, Color color, Graphics2D g2d) {
        g2d.setPaint(color);
        Polygon p = new Polygon();
        
        for(int x = (int)ranges[0]; x <= (int)ranges[1]; x++){
            p.addPoint( ORIGINX + 10*x, ORIGINY - (int)(Math.pow(Math.E, x)*5));
            //System.out.println( (int)(Math.pow(Math.E, x)*5) );
        }
        
        g2d.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }

    private void drawLn(double[] ranges, Color color, Graphics2D g2d) {
        g2d.setPaint(color);
        Polygon p = new Polygon();
        
        for(int x = (int)ranges[0]; x <= (int)ranges[1]; x++){
            p.addPoint( ORIGINX + 10*x, ORIGINY - (int)(Math.log(x)*5));
            //System.out.println( (int)(Math.pow(Math.E, x)*5) );
        }
        
        g2d.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }

    private void draw_crnt_panel(Graphics2D g2d) {
        g2d.drawLine(0, ORIGINY, 650, ORIGINY);
        g2d.drawLine(ORIGINX, 0, ORIGINX, 480);
    }
    
}

    