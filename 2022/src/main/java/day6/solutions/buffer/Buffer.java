package day6.solutions.buffer;

public class Buffer {

    private char[] buffer;
    
    public Buffer(int size) {
        buffer = new char[size];
    }
    
    public int size() {
        return buffer.length;
    }
    
    public void set(int pos, char c) {
        buffer[pos] = c;
    }
    
    public void shift(char c) {
        System.arraycopy(buffer, 1, buffer, 0, size()-1);
        buffer[size()-1] = c;
    }
    
    public boolean hasDuplicate() {
        for(int i = 0; i < size()-1; ++i) {
            for(int j = i+1; j < size(); ++j) {
                if(buffer[i] == buffer[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean contains(char c) {
        for(int i = 0; i < size(); ++i) {
            if(buffer[i] == c) {
                return true;
            }
        }
        return false;
    }
}
