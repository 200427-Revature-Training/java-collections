package com.revature.order;

import java.util.Comparator;

/*
 * Comparator is an interface which can provide an alternative order.  This will not be the natural
 * order but gives us a chance to provide a variety of different kinds of order.
 */
public class LastLoginOrder implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		return o1.getLastLogin().compareTo(o2.getLastLogin());
	}
}
