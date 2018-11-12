/**
* 
*/
package com.collection.develop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 * @author mohamedanees
 *
 */
public class CollectionUtility {
	/**
	 * 
	 * @param List
	 *            col
	 * @returns first element in List or null if there is no first element
	 */

	public static <T> T getFirstInList(List<T> col) {
		if (col == null || col.isEmpty()) {
			return null;
		} else {
			return col.get(0);
		}
	}

	public static <T> String produceVerboseElementString(Collection<T> col, String delimiter) {
		if (CollectionUtils.isNotEmpty(col)) {
			StringBuilder sb = new StringBuilder();
			for (T colElem : col) {
				sb.append(colElem.toString());
				sb.append(delimiter);
			}
			return sb.toString();
		} else {
			return "";
		}
	}

	private static <T> Collection<T> castStringCollection(Collection<String> collection, Class<T> clazz)
			throws Exception {
		Collection<T> objList = null;
		if (CollectionUtils.isNotEmpty(collection)) {
			objList = collection.getClass().newInstance();
			for (String colObj : collection) {
				if (clazz == Integer.class) {
					objList.add((T) Integer.valueOf(colObj));
				} else if (clazz == Double.class) {
					objList.add((T) Double.valueOf(colObj));
				} else if (clazz == Float.class) {
					objList.add((T) Float.valueOf(colObj));
				} else {
					throw new Exception("Not Implemented Yet!!");
				}
			}
		}
		return objList;
	}

	public static <T> List<T> castStringList(List<String> collection, Class<T> clazz) throws Exception {
		return (List<T>) castStringCollection(collection, clazz);
	}

	// For Development purpose
	public static void main(String[] args) throws Exception {
		List<String> myList = new ArrayList<String>();
		myList.add("1");
		myList.add("2");
		myList.add("3");
		List<Integer> myIntegerList = castStringList(myList, Integer.class);
		System.out.println(myIntegerCollection);
	}

}
