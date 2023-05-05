package home2;


import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessThread extends Thread{

    private int number;

    private final AtomicBoolean isProcessed = new AtomicBoolean(true);

    private final NumberProcessor processor;

    public ProcessThread(NumberProcessor processor) {

        this.processor = processor;
    }

    public void process(int a) {
        this.number = a;
        isProcessed.set(false);
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (isProcessed.get()) {
                continue;
            }

            processor.process(number);
            isProcessed.set(true);
        }
    }

    public AtomicBoolean getIsProcessed() {

        return isProcessed;
    }
}