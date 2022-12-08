package day06.solutions.buffer;

public class SignalDetector extends Buffer {
    
    public SignalDetector(final int signalLength) {
        super(signalLength-1);
    }
    
    public int process(final String input) {
        init(input);
        
        int i = size();
        char c = input.charAt(i++);
        while(hasDuplicate() || contains(c)) {
            shift(c);
            c = input.charAt(i++);
        }
        return i;
    }
    
    private void init(final String input) {
        for(int i = 0; i < size(); ++i) {
            set(i, input.charAt(i));
        }
    }
}
