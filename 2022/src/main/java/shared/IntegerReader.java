package shared;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class IntegerReader {

    public static List<Integer> readAllIntegers(final String line) {
        
        List<Integer> values = new ArrayList<>();
        
        CharacterIterator charIter = new StringCharacterIterator(line);
        char prev = '\0';
        while(charIter.current() != CharacterIterator.DONE) {
         
            char c = charIter.next();
            if(Character.isDigit(c)) {
                
                boolean negate = prev == '-';
                
                int i = Character.digit(c, 10);
                c = charIter.next();
                while(Character.isDigit(c)) {
                    i = (i * 10) + Character.digit(c, 10);
                    c = charIter.next();
                }                
                values.add(negate ? -i : i);
            }
            prev = c;
        }
        return values;
    }
    
    /** 
     * Read pairs of integers from the input line and parse into co-ordinate values
     */
    public static List<Coordinate> readCoordinates(final String line) {
        
        final List<Coordinate> coordinates = new ArrayList<>();
        
        final List<Integer> ints = readAllIntegers(line);
        assert ints.size() % 2 == 0;
        
        for(int i = 0; i < ints.size(); i+=2) {
            coordinates.add(new Coordinate(ints.get(i), ints.get(i+1)));
        }
        
        return coordinates;
    }
}
