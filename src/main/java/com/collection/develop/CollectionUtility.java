/**
* 
*/
package com.collection.develop;

import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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

	public static <T, K, V> void myFunction(Class<T> keyClass, Map<K, V> map)
			throws InstantiationException, IllegalAccessException {

	}

	public static File readTimeOut(final String filePath, int timeOutInMillis) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService executor = Executors.newFixedThreadPool(1);
		FutureTask<File> futureFile = new FutureTask<File>(new Callable<File>() {

			public File call() throws Exception {
				System.out.println("I am called");
				return new File("/usr/mohamed");
			}

		});
		executor.execute(futureFile);
		return futureFile.get(3, TimeUnit.NANOSECONDS);
	}

	// For Development purpose
	public static void main(String[] args) throws Exception {
		System.out.println(readTimeOut(null, 20));
		
	}
	
	public static void hangTheThread() {
	    while(true){
	      
	    }
	}

  public static<T> ArrayList<T> createArrayList(T class1) {
    return new ArrayList<? extends T>();
  }

}
