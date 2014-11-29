package hw01;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * @author said
 * @version 1.0
 * @created 21-Feb-2014 12:01:18 AM
 */
public class ArrayBasedVisual implements Visual {

        private VisualData[] m_visualData;
	   private ParsedFormat m_ParsedFormat;
        public static ParsedFormat pf;
        
	public ArrayBasedVisual(){
            
	}
        
        @Override
        public VisualData[] getData() {
            return m_visualData;
        }
        
	/**
	 * 
	 * @param vd
	 */
        @Override
	public void addNewVisualData(VisualData vd){
            if(m_visualData == null){
                m_visualData = new VisualData[1];
                m_visualData[0] = vd;
            }else{
                realloc();
                m_visualData[m_visualData.length-1] = vd;
            }               
	}

	/**
	 * 
	 * @param line
	 */
        @Override
	public ParsedFormat parser(String line){
            String[] parts = line.split(",");
            m_ParsedFormat = new ParsedFormat();
            
            try {
                String getFunction = parseFunc(parts[0]);    
                m_ParsedFormat.setFunction(getFunction);

                double[] getRanges = parseRange(parts[1], parts[2]);
                m_ParsedFormat.setRanges(getRanges);

                Color getColor = parseColor(parts[3]);
                m_ParsedFormat.setColor(getColor);
                
            } catch (NullPointerException e) {
                System.out.println("Any ParsedFormat object not created! ");
                System.exit(-1);
            }catch(IllegalArgumentException ex){
                System.out.println("Detected an illegal statement !");
                System.exit(-1);
            }            

            return m_ParsedFormat;
	}

    @Override
    public String parseFunc(String foo) {
        
        if(foo.equals("sin(x)") || foo.equals("cos(x)") || foo.equals("e^x") || 
           foo.equals("ln(x)") || foo.equals("log(x)")  || 
           foo.equals("x") || foo.equals("x^2"))
            return foo;
        else
            throw new IllegalArgumentException();
    }

    @Override
    public double[] parseRange(String preParsedRange1, String preParsedRange2) {
            
        double ranges[] = new double[2];  
        boolean neg1 = false;
        boolean neg2 = false;
        
        preParsedRange1 = preParsedRange1.substring(1);
        preParsedRange2 = preParsedRange2.substring(1);
        
        if(preParsedRange1.charAt(0) == '-'){
            preParsedRange1 = preParsedRange1.substring(1);
            neg1 = true;
        }
        
        if(preParsedRange2.charAt(0) == '-'){
            preParsedRange2 = preParsedRange2.substring(1);
            neg2 = true;
        }
        
        try {
            ranges[0] = Double.parseDouble(preParsedRange1);
            ranges[1] = Double.parseDouble(preParsedRange2);
                        
            if(neg1)
               ranges[0] = -ranges[0]; 
            if(neg2)
                ranges[1] = -ranges[0];
                        
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Illegal format for ranges of function!");
            System.exit(-1);
        }
        
        return ranges;
    }

    @Override
    public Color parseColor(String preParsedColor) {
        
        Field f;
        try {
            f = Color.class.getField(preParsedColor.substring(1));
            return (Color) f.get(null);
        } catch (    NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(ArrayBasedVisual.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return null;
           
    }

    private void realloc() {
        VisualData[] newVd = new VisualData[m_visualData.length+1];
        
        try {
            for(int i = 0; i < m_visualData.length; i++){
            newVd[i] = m_visualData[i];
        }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("reallocation failed!");
        }
        finally{
            m_visualData = newVd;
        }
                
    }
    
    @Override
    public String toString(){
        String context = null;
        
        for(int i = 0; i < m_visualData.length; i++){
            context += m_visualData[0].getFunction() + "\n" + m_visualData[0].getRanges() + 
                    "\n" + m_visualData[0].getColor().toString() + "\n\n";
        }
        
        return context;
    }

    @Override
    public void loadData() {
        addNewVisualData(new VisualData(pf));
    }

   
}