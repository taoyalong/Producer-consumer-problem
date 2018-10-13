package consumerProblem;

import java.util.LinkedList;

public class Cunsumer implements Runnable {
	Data data = new Data();
	int maxsize = data.getMaxsize();
	LinkedList<Object> list;

	public Cunsumer(LinkedList<Object> list) {
		this.list = list;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (list) {
				if (list.size() <= 0) {
					try {
						Thread.sleep(1000 * 3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("消费者暂停消费");
					try {
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000 * 3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list.remove();
				System.out.println("消费者消费了一个产品\t现库存为" + list.size());
				list.notifyAll();
			}

		}
	}

}