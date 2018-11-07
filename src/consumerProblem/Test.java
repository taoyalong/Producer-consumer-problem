package consumerProblem.copy;

import java.util.LinkedList;

public class Test {
	public static void main(String args[]) {
		Data data = new Data();
		LinkedList<Object> list = data.getList();
		for (int i = 1; i < 4; i++) {
			Consumer p1 = new Consumer(list, i);
			new Thread(p1).start();
			Producer p2 = new Producer(list, i);
			new Thread(p2).start();
		}
	}
}
