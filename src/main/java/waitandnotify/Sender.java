package waitandnotify;

public class Sender implements Runnable {
    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    public void run() {
        String packets[] = {
                "First packet",
                "Second packet",
                "Third packet",
                "Fourth packet",
                "End"
        };

        System.out.println("Sending data");

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            System.out.println("Thread Interrupted");
//        }
//
//        this.data.sendAll(packets);


        for (String packet : packets) {
            System.out.println("Data Sent : " + packet);
            data.send(packet);

            //Thread.sleep() to mimic heavy server-side processing of sending data
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }
    }
}
