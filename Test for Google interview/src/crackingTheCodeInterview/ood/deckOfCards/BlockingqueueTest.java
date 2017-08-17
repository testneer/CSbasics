package crackingTheCodeInterview.ood.deckOfCards;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingqueueTest {
	
	static class Producer implements Runnable {
		private final BlockingQueue queue;

		Producer(BlockingQueue q) {
			queue = q;
		}

		public void run() {
		     try {
		       while (true) { 
		    	   queue.put(produce());
		    	   System.out.println("enqued an Item");
		    	   Thread.sleep(100);
		    	   }
		     } catch (InterruptedException ex){
		    	 System.out.println(ex);
		     }
		   }

		Object produce() {
			return new Integer(4);
		}
	}

	static class Consumer implements Runnable {
		private final BlockingQueue queue;

		Consumer(BlockingQueue q) {
			queue = q;
		}

		public void run() {
		     try {
		       while (true) {
		    	   consume(queue.take());
		    	   System.out.println("dequeued an Item");
		    	   Thread.sleep(2000);
		    	   }
		     } catch (InterruptedException ex) {
		    	 System.out.println(ex);
		     }
		   }

		void consume(Object x) { System.out.println(x);}
	}

	public static void main(String[] args) {
		
		BlockingQueue q = new LinkedBlockingQueue<>(3);
		Producer p = new Producer(q);
		Consumer c1 = new Consumer(q);
//		Consumer c2 = new Consumer(q);
		new Thread(p).start();
		new Thread(c1).start();
//		new Thread(c2).start();
		
	}
}
