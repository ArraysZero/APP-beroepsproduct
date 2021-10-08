package nl.han.ica.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Stack implements IHANStack {

	List<Object> stack = new ArrayList<>();

	@Override
	public void push(Object value) {
		stack.add(value);
	}

	@Override
	public Object pop() {
		Object object = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);
		return object;
	}

	@Override
	public Object peek() {
		return stack.get(stack.size() - 1);
	}
}
