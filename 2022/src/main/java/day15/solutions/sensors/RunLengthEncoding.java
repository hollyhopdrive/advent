package day15.solutions.sensors;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RunLengthEncoding {

    @Getter
    private final int start;
    
    @Getter
    private final int end;
    
    public boolean contains(RunLengthEncoding other) {
        return other.getStart() >= start && other.getEnd() <= end;
    }
    
    public boolean contains(int x) {
        return x >= start && x <= end;
    }
    
    public boolean overlaps(RunLengthEncoding other) {
        return other.getStart() <= start && other.getEnd() >= start ||
                other.getStart() <= end && other.getEnd() >= start;
    }
    
    public List<RunLengthEncoding> split(int value) {
        if(contains(value)) {
            return List.of(new RunLengthEncoding(start, value-1), new RunLengthEncoding(value +1, end));
        } else {
            return List.of(this);
        }
    }
    
    @Override
    public String toString() {
        return start + " -> " + end; 
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + end;
        result = prime * result + start;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RunLengthEncoding other = (RunLengthEncoding) obj;
        if (end != other.end)
            return false;
        if (start != other.start)
            return false;
        return true;
    }
    
    
}
