package com.itbulls.learnit.javacore.oop.hw.books;

public class BookService {
	public Book[] filterBooksByAuthor(Author author, Book[] books) {
//		<write your code here>
		if (author == null || books == null)
			return new Book[0];
		
		int numberForArraySize = 0;
		for (Book book : books) {
				if (book.hasAuthor(author))
					numberForArraySize++;
		}
		
		int index = 0;
		Book[] outputBooks = new Book[numberForArraySize];
		for (Book book : books) {
				if (book.hasAuthor(author)) {
					outputBooks[index++] = book;
				}
			}
		return outputBooks;
	}

	public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
//		<write your code here>
		if (publisher == null || books == null)
			return new Book[0];
		int numberForArraySize = 0;
		for (Book book : books) {
				if (book.getPublisher().equals(publisher))
					numberForArraySize++;
		}
		
		int index = 0;
		Book[] outputBooks = new Book[numberForArraySize];
		
		for (Book book : books) {
			if (book.getPublisher().equals(publisher)) {
					outputBooks[index++] = book;
				}
			}
		return outputBooks;
	}

	public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
//		<write your code here>
		if (Integer.valueOf(yearFromInclusively).equals(null) || books == null)
			return new Book[0];
		
		int numberForArraySize = 0;
		for (Book book : books) {
			if (book.getPublishingYear() >= yearFromInclusively)
					numberForArraySize++;
		}
		
		int index = 0;
		Book[] outputBooks = new Book[numberForArraySize];

		for (Book book : books) {
			if (book.getPublishingYear() >= yearFromInclusively)
				outputBooks[index++] = book;
		}
		return outputBooks;
	}
	
}

