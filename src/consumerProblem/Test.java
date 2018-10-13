package consumerProblem;

import java.util.LinkedList;

public class Test {
	public static void main(String args[]) {
		Data data=new Data();
		LinkedList<Object> list=data.getList();
		Cunsumer p1=new Cunsumer(list);
		new Thread(p1).start();
		Producer p2=new Producer(list);
		new Thread(p2).start();
	}

}
