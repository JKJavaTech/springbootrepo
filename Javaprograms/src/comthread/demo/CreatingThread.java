package comthread.demo;

public class CreatingThread extends Thread {

	@Override
	public void run() {
		System.out.println("This is run() calling");
	}
	public static void main(String[] args) {
		CreatingThread createThread=new CreatingThread();
		createThread.run();
	}
}
