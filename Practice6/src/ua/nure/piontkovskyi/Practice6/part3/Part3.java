package ua.nure.piontkovskyi.Practice6.part3;

public class Part3 {
	
	public static void main(String[] args) {
		Parking p = new Parking(10);
		System.out.println(p.toString());
		p.arrive(2);
		System.out.println(p.toString());
		p.arrive(8);
		p.arrive(1);
		System.out.println(p.toString());
		p.arrive(1);
		System.out.println(p.toString());
	}
}
