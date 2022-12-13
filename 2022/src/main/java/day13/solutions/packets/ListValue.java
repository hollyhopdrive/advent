package day13.solutions.packets;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListValue implements Value {

    private final List<Value> values;

    /**
    public void add(Value value) {
        values.add(value);
    }
    **/
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((values == null) ? 0 : values.hashCode());
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
        ListValue other = (ListValue) obj;
        if (values == null) {
            if (other.values != null)
                return false;
        } else if (!values.equals(other.values))
            return false;
        return true;
    }
    
    
}
