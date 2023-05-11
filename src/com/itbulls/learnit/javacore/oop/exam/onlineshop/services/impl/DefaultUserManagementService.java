package com.itbulls.learnit.javacore.oop.exam.onlineshop.services.impl;

import java.util.Arrays;
import java.util.regex.Pattern;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.User;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.services.UserManagementService;

public class DefaultUserManagementService implements UserManagementService {

	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "New user created";
	private static final String USER_EMPTY = "User is empty";
	private static final String EMAIL_REGEX = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

	private static final int DEFAULT_USERS_CAPACITY = 10;
	private User[] users;

	private static DefaultUserManagementService instance;
	private int lastUserIndex;

	// <write your code here> OK!
	{
		users = new User[DEFAULT_USERS_CAPACITY];
	}

	private DefaultUserManagementService() {
	}

	@Override
	public String registerUser(User user) {
		// <write your code here> OK!
		if (user == null) {
			return USER_EMPTY;
		}
		if (user.getEmail() == null) {
			return EMPTY_EMAIL_ERROR_MESSAGE;
		}
		
		if (user.getEmail().isEmpty()) {
			return EMPTY_EMAIL_ERROR_MESSAGE;
		}

		for (User userInArray : users) {
			if (userInArray == null) {
				continue;
			}
			if (userInArray.getEmail().toLowerCase().equals(user.getEmail().toLowerCase())) {
				return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
			}
		}

		final Pattern EMAIL = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
		if (EMAIL.matcher(user.getEmail()).matches() == false) {
			return EMPTY_EMAIL_ERROR_MESSAGE;
		}
		
		if (users.length <= lastUserIndex) {
			users = Arrays.copyOf(users, users.length << 1);
		}
		users[lastUserIndex++] = user;
		

		return NO_ERROR_MESSAGE;
	}

	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}

	@Override
	public User[] getUsers() {
		// <write your code here> OK!
		int nonNullUsersAmount = 0;
		for (User user : users) {
			if (user != null) {
				nonNullUsersAmount++;
			}
		}

		User[] outputUsers = new User[nonNullUsersAmount];

		int index = 0;
		for (User user : users) {
			if (user != null) {
				outputUsers[index++] = user;
			}
		}
		return outputUsers;
	}

	@Override
	public User getUserByEmail(String userEmail) {
		// <write your code here> OK!
		for (User user : users) {
			if (user.getEmail().toLowerCase().equals(userEmail)) {
				return user;
			}
		}
		return null;
	}

	void clearServiceState() {
		// <write your code here>
		lastUserIndex = 0;
		users = new User[DEFAULT_USERS_CAPACITY];
//		User[] clearUsers = new User[DEFAULT_USERS_CAPACITY];
//		for (User user : users) {
//			user = clearUsers[0];
//		}
	}
}
