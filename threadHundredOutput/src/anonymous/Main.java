package anonymous;

public class Main {

	public static void main(String[] args) {

		Object someObject = new Object();
		
		//ÄäÃûÀà
		Thread t1 = new Thread() {
			int val = 1;
			@Override
			public void run(){
				synchronized(someObject) {
					while (val <= 99) {
						System.out.println(val);
						someObject.notify();
						try {
							someObject.wait();
						}catch(Exception e) {
							e.printStackTrace();
						}
						val = val + 2;
						
					}
					someObject.notify();
					System.out.println(this);
				}
				
			}
		};
		
		Thread t2 = new Thread() {
			int val = 2;
			@Override
			public void run() {
				synchronized(someObject) {
					while(val <= 100) {
						System.out.println(val);
						someObject.notify();
						try {
							someObject.wait();
						}catch(Exception e) {
							e.printStackTrace();
						}
						val = val + 2;
					}
					System.out.println(this);
					
				}
			}
		};
		
		t1.start();
		
		
		t2.start();
		
		
		

	}

}
