package com.itbulls.learnit.javacore.jcf.collections.list.hw;

public class DefaultMyList implements MyList {

	transient int size = 0;

	transient Node<Object> first;

	transient Node<Object> last;

//    <write your code here>

	public DefaultMyList() {
		super();
	}

	public void linkLast(Object e) {
		final Node<Object> l = last;
		final Node<Object> newNode = new Node<>(l, e, null);
		last = newNode;

		if (l == null)
			first = newNode;
		else
			l.next = newNode;
		size++;
	}

	public void add(Object e) {
		linkLast(e);
	}

	public void clear() {
		for (Node<Object> x = first; x != null;) {
			Node<Object> next = x.next;
			x.item = null;
			x.next = null;
			x.prev = null;
			x = next;
		}
		first = last = null;
		size = 0;
	}

	public boolean remove(Object o) {
		if (o == null) {
			for (Node<Object> x = first; x != null; x = x.next) {
				if (x.item == null) {
					unlink(x);
					return true;
				}
			}
		} else {
			for (Node<Object> x = first; x != null; x = x.next) {
				if (o.equals(x.item)) {
					unlink(x);
					return true;
				}
			}
		}
		return false;
	}

	public Object[] toArray() {
		Object[] result = new Object[size];
		int i = 0;
		for (Node<Object> x = first; x != null; x = x.next)
			result[i++] = x.item;
		return result;
	}
	/*
	 * unlink method
	 */

	Object unlink(Node<Object> x) {
		final Object element = x.item;
		final Node<Object> next = x.next;
		final Node<Object> prev = x.prev;

		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
			x.prev = null;
		}

		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
			x.next = null;
		}

		x.item = null;
		size--;
		return element;
	}

	public int size() {
		return size;
	}

	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	public boolean containsAll(MyList c) {
		Object[] myListArray = c.toArray();
		for (Object object : myListArray) {
			if (contains(object) != true)
				return false;
		}
		return true;
	}

	/*
	 * indexOf
	 */
	public int indexOf(Object o) {
		int index = 0;
		if (o == null) {
			for (Node<Object> x = first; x != null; x = x.next) {
				if (x.item == null)
					return index;
				index++;
			}
		} else {
			for (Node<Object> x = first; x != null; x = x.next) {
				if (o.equals(x.item))
					return index;
				index++;
			}
		}
		return -1;
	}

	/*
	 * Node static inner class
	 */
	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}

}
