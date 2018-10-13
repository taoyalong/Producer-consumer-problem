package consumerProblem;

import java.util.LinkedList;

public class Producer implements Runnable {
	Data data = new Data();

	int maxsize = data.getMaxsize();
	LinkedList<Object> list;
	public Producer(LinkedList<Object> list) {
		this.list = list;
	}
	@Override
	public void run() {
		while (true) {
			synchronized (list) {
				// 如果仓库已满
				while (list.size() >= maxsize) {
					System.out.println("生产者暂停生产");
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
				list.add(new Object());
				System.out.println("生产者生产了一个产品\t现库存为" + list.size());
				list.notifyAll();
			}
		}

	}

}
