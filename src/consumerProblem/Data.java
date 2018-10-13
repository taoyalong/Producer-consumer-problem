package consumerProblem;

import java.util.LinkedList;


public class Data {
	private int maxsize=5;
	private int count=0;
	private static Object mutex;
	private LinkedList<Object> list = new LinkedList<Object>();
	
	public LinkedList<Object> getList() {
		return list;
	}
	public void setList(LinkedList<Object> list) {
		this.list = list;
	}
	public int getMaxsize() {
		return maxsize;
	}
	public void setMaxsize(int maxsize) {
		this.maxsize = maxsize;
	}

	public static Object getMutex() {
		return mutex;
	}
	public void setMutex(Object mutex) {
		Data.mutex = mutex;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
}
