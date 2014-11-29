package hw01;

import java.awt.Color;

/**
 * @author said
 * @version 1.0
 * @created 21-Feb-2014 12:01:18 AM
 */
public class VisualData {

	private Color color;
	private String function;
	private double[] ranges = new double[2];
        private String[] parts;
        
	public VisualData(ParsedFormat pf){
            color = pf.getColor();
            function = pf.getFunction();
            ranges = pf.getRanges();            
	}

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the function
     */
    public String getFunction() {
        return function;
    }

    /**
     * @param function the function to set
     */
    public void setFunction(String function) {
        this.function = function;
    }

    /**
     * @return the ranges
     */
    public double[] getRanges() {
        return ranges;
    }

    /**
     * @param ranges the ranges to set
     */
    public void setRanges(double[] ranges) {
        this.ranges = ranges;
    }

    /**
     * @return the parts
     */
    public String[] getParts() {
        return parts;
    }

    /**
     * @param parts the parts to set
     */
    public void setParts(String[] parts) {
        this.parts = parts;
    }

}