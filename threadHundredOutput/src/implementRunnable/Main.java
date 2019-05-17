package implementRunnable;

public class Main {

	public static void main(String[] args) {

		Thread t1 = new Thread(new OddThread());
		Thread t2 = new Thread(new EvenThread());
		
		t1.start();
		t2.start();
		
		
	}

}
