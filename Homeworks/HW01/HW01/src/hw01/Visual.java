package hw01;

import java.awt.Color;

/**
 * @author said
 * @version 1.0
 * @created 21-Feb-2014 12:01:18 AM
 */
public interface Visual {

	/**
	 * 
	 * @param vd
	 */
	public void addNewVisualData(VisualData vd);

	public void loadData();
        public VisualData[] getData();
	/**
	 * 
	 * @param line
         * @return 
	 */
        
	public ParsedFormat parser(String line);
        public String parseFunc(String str1);
        public double[] parseRange(String str1, String str2);
        public Color parseColor(String str);
}