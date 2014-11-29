package hw01;

import java.awt.Color;

/**
 * @author said
 * @version 1.0
 * @created 21-Feb-2014 12:01:18 AM
 */
public class ListBasedVisual implements Visual {

	public VisualData m_VisualData;
	public ParsedFormat m_ParsedFormat;

	public ListBasedVisual(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param vd
	 */
        @Override
	public void addNewVisualData(VisualData vd){

	}

        @Override
	public void loadData(){

	}

	/**
	 * 
	 * @param line
	 */
        @Override
	public ParsedFormat parser(String line){
		return null;
	}

    @Override
    public String parseFunc(String str1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color parseColor(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double[] parseRange(String str1, String str2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VisualData[] getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}