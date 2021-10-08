package nl.han.ica.datastructures;

public class LinkedList<T>/* implements IHANLinkedList*/ {
	/*private LinkedList<T> next;
	private int index;
	private T value;

	public LinkedList(LinkedList<T> next, int index, T value) {
		this.next = next;
		this.index = index;
		this.value = value;
	}

	public LinkedList(LinkedList<T> next, T value) {
		this.next = next;
		this.value = value;
		this.index = 0;
	}

	public LinkedList(T value, int index) {
		this.value = value;
		this.index = index;
	}

	public LinkedList<T> getNext() {
		return next;
	}

	public int getIndex() {
		return index;
	}

	public T getValue() {
		return value;
	}

	public void setNext(LinkedList<T> next) {
		this.next = next;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public void addFirst(Object value) {
		next = new LinkedList<>(this.next, this.index++, this.value);
		this.value = (T) value;
	}

	@Override
	public void clear() {
		//maak gebruik van garbage collection
		this.next = null;
		this.value = null;
	}

	@Override
	public void insert(int index, Object value) {
		if(index == this.index){
			addFirst(value);
		} else {
			this.next.insert(index, value);
		}
	}

	@Override
	public void delete(int pos) {
		if(this.index - pos == 1){
			this.next = this.next.
		}
	}

	@Override
	public Object get(int pos) {
		return null;
	}

	@Override
	public void removeFirst() {

	}

	@Override
	public Object getFirst() {
		return null;
	}

	@Override
	public int getSize() {
		return 0;
	}*/
}
