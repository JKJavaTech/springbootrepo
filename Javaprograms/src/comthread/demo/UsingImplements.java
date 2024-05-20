package comthread.demo;

public class UsingImplements implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		UsingImplements usingImplements=new UsingImplements();
		Thread t=new Thread(usingImplements);
		t.start();
	}
}
