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
		

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.id + " keresztezodes elott.");
						
		synchronized (this.keresztezodes) {
			
			if (this.keresztezodes.isLampaZold == false) {
				synchronized (this.keresztezodes.lampaLock) {
					while (this.keresztezodes.isLampaZold == false) {
						try {
							System.out.println(this.id + " var a pirosnal");		
							this.keresztezodes.lampaLock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(this.id + " felebredt");
					}
				}
			}
			
			
			System.out.println(this.id + " bement");		
			try {
				Thread.sleep(2000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.id + " kijott a keresztezodesbol");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println(this.id +" " + this.rendszam + " rendszamu auto elkoszon.");
		
	}

}
