public class ColorHSB {
	private final int hue;   //  Integer between 0 and 359. represents a pure color on the color wheel, with 0° for red, 120° for green, and 240° for blue.
    private final int saturation;        // Integer between 0 and 100. It represents the purity of the hue
	private final int brightness   //Integer between 0 and 100. It represents the percentage of white that is mixed with the hue.
	
    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
		
		// Throw an IllegalArgumentException in the constructor if any component is outside its prescribed range (0 to 359 for the hue, 0 to 100 for the saturation and brightness)
		if ((h<0) || (h>259)) || (s<0) || (s>100) || (b<0) || (b>100) {
        throw new IllegalArgumentException("arguments out of range");
    }
		hue=h;
		saturation=s;
		brightness=b;
		
	}

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString(){
		
		return "( h =" + hue + ", " +"s =" +saturation+", "+"b =" +brightness+" )";
		
	}

    // Is this color a shade of gray?
    public boolean isGrayscale(){
		return ( saturation == 0 ) ||  ( brightness == 0 );
		
		
	}

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that){
		
		if (that == null){
			
			 throw new IllegalArgumentException("has not the object");
		}
		
		ColorHSB a=this;
		
		return Math.min ( Math.pow((a.hue−that.hue),2) ,Math.pow((360 - Math.abs(a.hue−that.hue),2)))+Math.pow((a.saturation−that.saturation),2)+Math.pow((a.brightness−that.brightness),2);
		
	}

    // Sample client (see below).
    public static void main(String[] args) {
		
		int h = Integer.parseInt(args [0]);
		int s = Integer.parseInt(args [1]);
		int b = Integer.parseInt(args [2]);
		
		ColorHSB testColor = new ColorHSB (h,s,b);
		
		if (testColor.isGrayscale){
			
		Sys.out.println("Grey "+testColor.toString);
		break;
		
		}
		else {
		int minimumCurrent=0;
		
		// maximum distance between two HSB colors
		int minimum=149600;
		
		String colorNearest;
		String colorData;
		String colorNearestData;
		
		while (!StdIn.isEmpty()) {
            
			String col = StdIn.readString();
			int h2 = StdIn.readInt();
            int s2 = StdIn.readInt();
			int b2 = Std.readInt();
			
			ColorHSB that = new ColorHSB(h2,s2,b2);
			
			minimumCurrent=testColor.distanceSquaredTo(that);
			
			colorData = that.toString;
			
			if (minimumCurrent < minimum) {
				
				minimum = minimumCurrent;
				colorNearest = col;
				colorNearestData = colorData;
						
			}
        }
		System.out.println (colorNearest+" "+colorNearestData);
	  }
		
	}

}