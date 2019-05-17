package extendThread;

public class OddThread extends Thread{
	private int val = 1;
	
	@Override
	public void run() {
		synchronized(Thread.class) {
			while (val <= 99) {
				System.out.println(val);
				Thread.class.notify();
				try {
					Thread.class.wait();
				}catch(Exception e) {
					e.printStackTrace();
				}
				val = val + 2;
				
			}
			Thread.class.notify();
			System.out.println(this);
		}
	}
}
