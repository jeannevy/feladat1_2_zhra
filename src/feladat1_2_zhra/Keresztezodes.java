package feladat1_2_zhra;

public class Keresztezodes implements Runnable {
	public volatile Boolean isLampaZold = false;
	
	public synchronized void belep() {
		
		try {
			while (this.isLampaZold == false) {
				this.wait();
				System.out.println("felebredt");
			}
			System.out.println("valaki bejott a keresztezodesbe");

			Thread.sleep(2000);

			System.out.println("vegigment");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
	}
		
	
	
	public void run() {
		while (true) {
			this.isLampaZold = !this.isLampaZold;
			if (isLampaZold == false) { //piros
				System.out.println("piros a lampa");
				continue;
			}
			System.out.println("zold a lampa");
			
			synchronized (this) {
				System.out.println("zold lampa notify");
				this.notifyAll();
			}
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
