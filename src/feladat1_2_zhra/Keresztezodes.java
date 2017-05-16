package feladat1_2_zhra;

public class Keresztezodes implements Runnable {
	public volatile boolean isLampaZold = false;
	public Object lampaLock = new Object();

	public void run() {
		System.out.println("piros a lampa");
		while (true) {
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.isLampaZold = !this.isLampaZold;
			if (this.isLampaZold) {
				System.out.println("zold a lampa");
				synchronized (this.lampaLock) {
					System.out.println("zold lampa notify");
					this.lampaLock.notifyAll();
				}
			} else {
				System.out.println("piros a lampa");
			}
			
		}
	}
}
