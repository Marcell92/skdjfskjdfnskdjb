package cucumber;

import java.util.Stack;

public class StackExamples {

	@SuppressWarnings("rawtypes")
	private Stack stack = new Stack();

	public Object pop() {
		return stack.pop();
	}

	@SuppressWarnings("unchecked")
	public void push(Object o) {
		stack.push(o);
	}

	public int size() {
		return stack.size();
	}

}
