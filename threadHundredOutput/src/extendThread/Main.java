package extendThread;

public class Main {

	public static void main(String[] args) {

		OddThread t1 = new OddThread();
		EvenThread t2 = new EvenThread();
		t1.start();
		t2.start();

	}

}
