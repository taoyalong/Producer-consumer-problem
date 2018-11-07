package consumerProblem.copy;

import java.util.LinkedList;

public class Consumer implements Runnable {
	Data data = new Data();
	int maxsize = data.getMaxsize();
	LinkedList<Object> list;
	int pi;

	public Consumer(LinkedList<Object> list, int i) {
		this.list = list;
		this.pi = i;
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (list) {
				if (list.size() <= 0) {
					System.out.println("第" + pi + "消费者暂停了一个产品");
					try {
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				list.remove();
				System.out.println("第" + pi + "消费者消费了一个产品\t现库存为" + list.size());
				list.notifyAll();
			}
		}
	}

}