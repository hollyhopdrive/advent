package day13.solutions.packets;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class PacketParser {

    private static final char OPEN_LIST = '[';
    private static final char CLOSE_LIST = ']';
    private static final char DELIMITER = ',';
    
    private boolean inList = false;
    
    private boolean inInteger;
    private int integer;
    
    public Packet parsePacket(final String line) {
        
        final List<Value> values = new ArrayList<>();
        CharacterIterator charIter = new StringCharacterIterator(line);
        parseList(charIter, values);
        return new Packet(values);
    }
    
    public void parseList(final CharacterIterator charIter, final List<Value> values) {
    
        while(charIter.current() != CharacterIterator.DONE) {
            boolean done = process(charIter, values);
            
            if(done) {
                break;
            }
            
            charIter.next();
        }
    }
    
    private boolean process(final CharacterIterator charIter, final List<Value> values) {
        
        char c = charIter.current();
        switch(c) {
            
            case OPEN_LIST: 
                openList(charIter, values); 
                return false;
            
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                consumeDigit(c);
                return false;
                
            case DELIMITER:
                closeValue(values);
                return false;
                
            case CLOSE_LIST:  
                closeList(values);
                return true;
                
            default:
                throw new RuntimeException("Parse error. No rule for " + c);
        }
    }
    
    private void openList(final CharacterIterator charIter, final List<Value> values) {
        if(!inList) {
            inList = true;
        } else {
            // A nested list
            List<Value> nestedListValues = new ArrayList<>();
            new PacketParser().parseList(charIter, nestedListValues);
            values.add(new ListValue(nestedListValues));
        }
    }
    
    private void consumeDigit(final char c) {
        if(inInteger) {
            integer = (integer * 10) + Character.digit(c, 10);
        } else {
            inInteger = true;
            integer = Character.digit(c, 10);
        }
    }
    
    private void closeValue(final List<Value> values) {
        if(inInteger) {
            inInteger = false;
            values.add(new IntegerValue(integer));
        }
    }
    
    private void closeList(final List<Value> values) {
        closeValue(values);
    }
}
