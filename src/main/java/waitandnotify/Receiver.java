package waitandnotify;

public class Receiver implements Runnable {
    private Data load;

    public Receiver(Data load) {
        this.load = load;
    }

    public void run() {
        for (String receivedMessage = load.receive(); !"End".equals(receivedMessage); receivedMessage = load.receive()) {

            System.out.println("Message received " + receivedMessage);

            //Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }

//        String[] packets = load.receiveAll();
//
//        for (String packet : packets) {
//            System.out.println(packet);
//        }
    }
}
