package waitandnotify;

public class Data {
    private String packet;
    private String[] packets;
    private boolean isDataTransferred = false;

    public synchronized String receive() {
        while (!isDataTransferred) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }

        isDataTransferred = false;
        notifyAll();

        return packet;
    }

    public synchronized String[] receiveAll() {
        while (!isDataTransferred) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }

        isDataTransferred = false;
        notifyAll();

        return packets;
    }

    public synchronized void send(String packet) {
        while (isDataTransferred) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }

        isDataTransferred = true;
        this.packet = packet;

        notifyAll();
    }

    public synchronized void sendAll(String[] packet) {
        while (isDataTransferred) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }

        isDataTransferred = true;
        this.packets = packet;

        notifyAll();
    }
}
