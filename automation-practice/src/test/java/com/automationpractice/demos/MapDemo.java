package com.automationpractice.demos;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;

public class MapDemo {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "apple");
		map.put(2, "pear");
		map.put(3, "strawberry");
		map.put(4, "plum");

		for (Map.Entry<Integer, String> map1 : map.entrySet()) {
			System.out.println(map1.getKey() + " - " + map1.getValue());

		}
		
		Assert.assertEquals(map.get(4), "plum", "Assertion is passed");
		
		System.out.println(map.get(3));
		System.out.println("map size before removing is " + map.size());
		map.remove(3);
		System.out.println("map size after removing is " + map.size());

		for (Map.Entry<Integer, String> map1 : map.entrySet()) {
			System.out.println(map1.getKey() + " - " + map1.getValue());

		}
		
		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			System.out.println(key);
		}
		
		
		
	}
	
	}
