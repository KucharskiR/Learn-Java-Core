package com.itbulls.learnit.javacore.jcf.collections.list.hw;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DefaultMyList implements MyList {

	/**
	 * An iterator over a collection.
	 * 
	 */

	private class IteratorImpl<T> implements Iterator<T> {

		int cursor;
		int lastRet = -1; // index of last element returned; -1 if no such

		public boolean hasNext() {
			// returns true if the iteration has more elements

			// …
			return cursor != size;
		}

		@SuppressWarnings("unchecked")
		public T next() {
			// returns the next element in the iteration

			// …
			int i = cursor;
			if (i >= size)
				throw new NoSuchElementException();
			Object[] elementData = DefaultMyList.this.toArray();
			if (i >= elementData.length)
				throw new ConcurrentModificationException();
			cursor = i + 1;
			return (T) elementData[lastRet = i];

		}

		public void remove() {
			// removes from the underlying collection the last element returned by this
			// iterator

			// …
			if (lastRet < 0)
				throw new IllegalStateException();

			try {
				DefaultMyList.this.remove(getNodeByIndex(lastRet));
				cursor = lastRet;
				lastRet = -1;
			} catch (IndexOutOfBoundsException e) {
				throw new ConcurrentModificationException();
			}

		}
	}

	transient int size = 0;

	transient Node<Object> first;

	transient Node<Object> last;

//    <write your code here>

	public DefaultMyList() {
		super();
	}

	/*
	 * Iterator method
	 */
	public Iterator<Object> iterator() {

		return new IteratorImpl<Object>();

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
		try {
			for (Node<Object> x = first; x != null; x = x.next) {
				if (o.equals(x.item)) {
					unlink(x);
					return true;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Object is null");
			for (Node<Object> x = first; x != null; x = x.next) {
				if (x.item == null) {
					unlink(x);
					return true;
				}
			}
		}
		return false;
	}

	public Object getNodeByIndex(int index) {
		int i = 0;
		try {
			for (Node<Object> x = first; x != null; x = x.next) {
				if (i == index) {
					return (Object) x.item;
				}
				i++;
			}
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
			for (Node<Object> x = first; x != null; x = x.next) {
				i++;
				if (i == index) {
					return x.item;
				}
			}
		}
		return null;
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
		try {
			return indexOf(o) >= 0;
		} catch (NullPointerException e) {
			System.out.println("Object is null");
			return false;
		}
	}

	public boolean containsAll(MyList c) {
		Object[] myListArray = c.toArray();
		try {
			for (Object object : myListArray) {
				if (contains(object) != true)
					return false;
			}
		} catch (NullPointerException e) {
			System.out.println("Object is null");
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
