package nl.han.ica.datastructures;

public class Node<T> {
	private Node next;
	private T value;

	public Node(Node next, T value) {
		this.next = next;
		this.value = value;
	}

	public Node(T value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public T getValue() {
		return value;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
