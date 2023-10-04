package com.itbulls.learnit.javacore.jcf.collections.list.hw.parametrized;

/**
 * Implementing this interface allows an object to returns
 * object of ListIterator.
 * 
 * @author Andrii Piatakha
 *
 */

public interface ListIterableParametrized<T> {
	
	/**
	 * Returns object of ListIterator.
	 * 
	 * @return object of ListIterator
	 */
	ListIteratorParametrized listIterator();
}
