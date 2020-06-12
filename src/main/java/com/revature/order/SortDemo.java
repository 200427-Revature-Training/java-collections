package com.revature.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * Interfaces associated with sorting:
 * * Comparable - Natural Ordering - compareTo(b) {}
 * * Comparator - Alternative Ordering - compare(a, b) {}
 * 
 * Both compare and compareTo return an integer value, where negative, zero, and positive values
 * indicate whether they are sorted, equal, or out of order.
 * 
 * To sort a collection, there may be a sort method on the specific kind of collection, or you can
 * use the Collections utility class which has a .sort function. For natural order, you simply provide
 * the collection, for alternative orders provide the collection with an instance of a comparator.
 * 
 * Comparators themselves can be reversed with the Collections utility class.  They can also be
 * implemented using a lambda function as they are a functional interface. (Technically, comparable
 * is also a functional interface, but if you were to implement with a lambda it would have no state
 * to sort, so kind of pointless).
 * 
 * PriorityQueues are a kind of queue which always produces the 'next' item based on the defined
 * order for the type of objects placed in the queue. They can be used when you have a predefined order
 * that you need to process things in. You can use natural ordering or a comparator to define the order
 * when the priority queue is created. After creation, you can treat it like a normal queue.  Note: PQs
 * are implemented using a binary tree data structure.
 */
public class SortDemo {
	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		
		users.add(new User(3, "Jordon", "Hill", LocalDate.of(2000, 12, 12)));
		users.add(new User(5, "Ryan", "Clayton", LocalDate.of(1990, 4, 1)));
		users.add(new User(1, "Natasha", "Poser", LocalDate.of(2001, 6, 5)));
		users.add(new User(6, "Hugh", "Thornhill", LocalDate.of(1980, 1, 30)));
		users.add(new User(7, "Henry", "Thornhill", LocalDate.of(2005, 1, 1)));
		users.add(new User(2, "Ryan", "Howard", LocalDate.of(2002, 2, 2)));
		
		users.forEach(System.out::println);
		
		System.out.println("Sorting...");	
		
		// We can apply a sort without providing any sorting rules here, because our class
		// has implemented Comparable and therefore has a defined natural order
		Collections.sort(users);
		
		users.forEach(System.out::println);
		
		System.out.println("Sort by last login");
		Collections.sort(users, new LastLoginOrder());
		
		users.forEach(System.out::println);
		
		Comparator<User> loginOrderDesc = Collections.reverseOrder(new LastLoginOrder());
		Collections.sort(users, loginOrderDesc);
		System.out.println("Ordering by last login descending...");
		
		users.forEach(System.out::println);
		
		Comparator<User> lastNameFirstNameComparator = (userA, userB) -> {
			// If there last names are the same, then compare first names
			if (userA.getLastName().compareToIgnoreCase(userB.getLastName()) == 0) {
				return userA.getFirstName().compareToIgnoreCase(userB.getFirstName());
			}
			// Otherwise, compare last names
			return userA.getLastName().compareToIgnoreCase(userB.getLastName());
		};
		
		System.out.println("Order by names, last name, then first Name");
		Collections.sort(users, lastNameFirstNameComparator);
		
		users.forEach(System.out::println);
		
		// Priority Queue is a data structure that allows queue like operation but maintains
		// an order, so the item you get when polling is the most 'fit' given the comparison
		// a "heap" structure
		PriorityQueue<User> pq = new PriorityQueue<>(new LastLoginOrder());
		pq.addAll(users);
		
		System.out.println("Adding all users to priority queue");
		
		while(!pq.isEmpty()) {
			System.out.println("Next customer: " + pq.poll());
		}
	}
}
