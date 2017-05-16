package feladat1_2_zhra;

public class Car implements Runnable {
	int rendszam;
	Keresztezodes keresztezodes;
	int id;
	public Car(int id, int r, Keresztezodes ker) {
		this.id = id;
		this.rendszam = r;
		this.keresztezodes = ker;
	}
	

	@Override
	public void run() {
		
		System.out.println(this.id + " " + this.rendszam + " rendszamu auto elindult a keresztezodes fele.");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.id +" " + this.rendszam + " rendszamu auto megerkezett a keresztezodeshez.");
		
		synchronized (this.keresztezodes) {
			try {
				while (this.keresztezodes.isLampaZold == false) {
					this.keresztezodes.wait();
					System.out.println("felebredt");
				}
				System.out.println(this.id + " valaki bejott a keresztezodesbe");

				Thread.sleep(2000);

				System.out.println("vegigment");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(this.id +" " + this.rendszam + " rendszamu auto kijott a keresztezodesbol.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.id +" " + this.rendszam + " rendszamu auto elkoszon.");
		
	}

}
