package shared;

import lombok.Getter;

public class Counter {

	@Getter private int value;
	
	public Counter() {
		this(0);
	}
	
	public Counter(int initialValue) {
		this.value = initialValue;
	}
	
	public int increment() {
		return ++value;
	}
	
	public void add(int amount) {
	    value += amount;
    }
}
