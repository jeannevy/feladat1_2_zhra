package feladat1_2_zhra;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	
	ArrayList<Car> autok = new ArrayList<Car>();
	
	public static void main(String[] args) {
		Keresztezodes keri = new Keresztezodes();
		Thread t = new Thread(keri);
		t.start();
		for (int i=0; i<150; i++) {
			Random random = new Random();
			Car car = new Car(i, random.nextInt(900000)+100000, keri);
			Thread thread = new Thread(car);
			thread.start();
		}
	}

}
