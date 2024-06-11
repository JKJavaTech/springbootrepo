  package comthread.demo;

class Account{
	
	public double amount=10000;
	
	public synchronized void withdraw(double withdrawamount) {
		System.out.println("Withdraw Amount Process Has Been Started....");
		if(amount<withdrawamount) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		amount=this.amount-withdrawamount;
		System.out.println("After Withdraw The Amount Was >>>>> "+amount);
	}//withdraw
	
	public synchronized  void deposit(double deposit) {
		System.out.println("Deposit the Amount Please make sufficient balence");
		amount=amount+deposit;
		System.out.println("After Deposit The Amount Was "+amount);
		notify();
	}//deposit
	
}
public class InterThreadCommu {
	
	public static void main(String[] args) {
		Account account=new Account();
		new Thread() {
			public void run() {
				account.withdraw(15000.00);
			};
		}.start();
		
		new Thread() {
			public void run() {
				account.deposit(12000);
			};
		}.start();
		
	}

}
