package day10.solutions.crt;

public class Crt {

    private static final int SIZE = 40;
    private static final String LIT = "#";
    private static final String DARK = ".";
    
    private StringBuilder buffer = new StringBuilder();
    
    private int pixel = 0;
    
    public void draw(int spritePos) {
        buffer.append(getPixelState(spritePos));
        
        if(++pixel % SIZE == 0) {
            buffer.append("\n");
            pixel = 0;
        }
    }
    
    private String getPixelState(final int spritePos) {
        return pixel >= spritePos -1 && pixel <= spritePos + 1 ? LIT : DARK;
    }
    
    @Override
    public String toString() {
        return buffer.toString();
    }
}
