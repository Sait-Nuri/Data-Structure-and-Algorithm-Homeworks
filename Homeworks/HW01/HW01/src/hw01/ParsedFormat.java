package hw01;

import java.awt.Color;

/**
 * @author said
 * @version 1.0
 * @created 21-Feb-2014 12:01:18 AM
 */
public class ParsedFormat {

	private Color Color;
	private String Function;
	private double[] Ranges;

	public ParsedFormat(){
            
	}

    /**
     * @return the Color
     */
    public Color getColor() {
        return Color;
    }

    /**
     * @param Color 
     * The Color to set
     */
    public void setColor(Color Color) {
        this.Color = Color;
    }

    /**
     * @return the Function
     */
    public String getFunction() {
        return Function;
    }

    /**
     * @param Function the Function to set
     */
    public void setFunction(String Function) {
        this.Function = Function;
    }

    /**
     * @return the Ranges
     */
    public double[] getRanges() {
        return Ranges;
    }

    /**
     * @param Ranges the Ranges to set
     */
    public void setRanges(double[] Ranges) {
        this.Ranges = Ranges;
    }

}