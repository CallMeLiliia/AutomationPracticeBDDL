package warm_up_tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import utils.Common;

/**
 * October 15, 2019
 * 
 * @author kulis
 *
 */

public class WarmUpDay77 {

public static void main(String[] args) {
	
	Map<Integer, String> names = new HashMap<Integer, String>();
//	names.put(77, "Nina");
//	names.put(8, "Mia");
//	names.put(6, "Emily");
//	names.put(35, "Ivan");
//	names.put(40, "Luka");
	
	//print each map element
	for(int index = 1; index <=5;index++) {
		names.put(Common.getRandomInt(0, 60), Common.getRandomFirstName());
		
	}//print each keys and sum them
	for (Map.Entry<Integer, String> name: names.entrySet()) {
		System.out.println(name.getKey()+ " - "+ name.getValue());
		
	}
	
    Set <Integer>setOfKeys = names.keySet();
    int sumOfKeys=0;
	for (Integer key: setOfKeys) 
		sumOfKeys+=key;
		System.out.println(sumOfKeys);
	
	

}}
