package nl.han.ica.datastructures;

import java.util.ArrayList;
import java.util.List;

public class HANLinkedList<T> implements IHANLinkedList {
	List<Object> nodes = new ArrayList<>();

	public HANLinkedList() {
	}

	public HANLinkedList(List<Object> nodes) {
		this.nodes = nodes;
	}

	@Override
	public void addFirst(Object value) {
		nodes.add(0, value);
	}

	@Override
	public void clear() {

	}

	@Override
	public void insert(int index, Object value) {
		nodes.add(index, value);
	}

	@Override
	public void delete(int pos) {
		nodes.remove(pos);
	}

	@Override
	public Object get(int pos) {
		return nodes.get(pos);
	}

	@Override
	public void removeFirst() {
		nodes.remove(0);
	}

	@Override
	public Object getFirst() {
		return nodes.get(0);
	}

	@Override
	public int getSize() {
		return nodes.size();
	}
}
