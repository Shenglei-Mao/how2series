package consumerProducer;

import java.util.LinkedList;

public class MyStack<T> {

    LinkedList<T> values = new LinkedList<T>();

    public synchronized void push(T t) {
        while(values.size()>=200){
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.notifyAll();
        values.addLast(t);

    }

    public T pull() {
        while(values.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.notifyAll();
        return values.removeLast();
    }

}
