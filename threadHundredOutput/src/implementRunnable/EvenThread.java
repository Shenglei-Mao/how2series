package implementRunnable;

public class EvenThread implements Runnable{
	private int val = 2;
	public void run() {
		synchronized(Thread.class) {
			while(val <= 100) {
				System.out.println(val);
				Thread.class.notify();
				try {
					Thread.class.wait();
				}catch(Exception e) {
					e.printStackTrace();
				}
				val = val + 2;
			}
			System.out.println(this);
			
		}
	}

}
