/**
* 
*/
package com.collection.develop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

	public static <T> List<T> getCastedList(List<Object> objList, Class<T> clazz) {
		List<T> newList = new ArrayList<T>();
		if (objList != null) {
			for (Object object : objList) {
				if (object != null && clazz.isAssignableFrom(object.getClass())) {
					newList.add((T) object);
				}
			}
		}
		return newList;
	}

	// For Development purpose
	public static void main(String[] args) throws Exception {
		List<Object> myList = new ArrayList<Object>();
		Hello h= new Hello();
		myList.add(h);
		List<Hello> castedList = (List<Hello>) getCastedList(myList, Class.forName("Hello"));
		
	}

}
