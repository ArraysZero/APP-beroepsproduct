package nl.han.ica.datastructures;

public class Queue<T> implements IHANQueue{
	private Queue<T> next;
	private T value;

	public Queue(Queue<T> next, T value) {
		this.next = next;
		this.value = value;
	}

	public Queue(T value) {
		this.value = value;
	}

	public Queue<T> getNext() {
		return next;
	}

	public T getValue() {
		return value;
	}

	@Override
	public void clear() {

	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void enqueue(Object value) {
		if (this.next != null){
			this.next.enqueue(value);
		} else {
			this.next = new Queue(value);
		}
	}

	@Override
	public Object dequeue() {
		T result = this.value;
		this.value = this.next.getValue();
		this.next = this.next.getNext();
		return result;
	}

	@Override
	public Object peek() {
		return getValue();
	}

	@Override
	public int getSize() {
		if(this.next != null){
			return this.next.getSize() + 1;
		} else {
			return 1;
		}
	}
}
