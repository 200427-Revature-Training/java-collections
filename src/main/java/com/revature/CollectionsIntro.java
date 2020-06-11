package com.revature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Collections is an API in Java dedicated to Data Structures. This is often called the "Collections API",
 * the "Collections Framework" or simply "collections".
 * 
 * There are a large number of different collections to fit varying data structures, varying variations
 * on those data structures, and varying use cases regarding concurrent/synchronized/ordered, etc.
 * 
 * Big O, Asymptotic Notation, Time Complexity for various data structures
 *
 * Hashcode-Equals contract
 * --------------------------
 * 		1. If .equals returns true, then two objects MUST have the same hashcode.
 * 		2. If two objects have different hashcodes, then then .equals MUST return false.
 *
 *	What is not being said here?
 *		1. .equals returns true therefore their hashcodes are equal.
 *		2. hashcodes are different, therefore .equals must be false.
 *		3. hashcodes are the same, therefore .equals could be true or false.
 *		4. .equals returns false, therefore could be the same or different.
 *	
 *	1. .equals can be computationally expensive.
 *	2. hashcode is a quick and dirty hash function that produces a number mathematically.
 *
 *	For a Hash-collection
 *	1. First, they calculate the hash and if the hash is not found anywhere else then they can assume
 *		that the item does not exist in the collection.
 *	2. If there exists an item or items with the same hashcode, then evaluate for each one .equals.
 *	3. If any object exists with .equals, then the new item is not unique.  If all items return false,
 *		then the item is consider unique.
 *
 */
public class CollectionsIntro {
	public static void main(String[] args) {
		List<Integer> myInts = new ArrayList<>();
		myInts.add(20);
		myInts.add(1);
		myInts.add(55);
		
		System.out.println(myInts);
		System.out.println(myInts.contains(20));
		System.out.println(myInts.contains(25));
		
		// Sets are used to store unique objects
		Set<String> usernames = new HashSet<>();
		usernames.add("Abby");
		usernames.add("Billy");
		usernames.add("Cindy");
		usernames.add("Cindy");
		System.out.println(usernames);
		
		// Queues are first-in first-out data structures
		Queue<String> myQueue = new LinkedList<>();
		myQueue.addAll(usernames);
		while(!myQueue.isEmpty()) {
			System.out.println("Hello " + myQueue.poll());
		}
		
		Map<Integer, String> users = new HashMap<>();
		
		users.put(1, "Abby");
		users.put(2, "Billy");
		users.put(3, "Cindy");
	
		System.out.println(users.get(2));
	}
}
