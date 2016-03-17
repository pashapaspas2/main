package gui;

import java.util.ArrayList;

public class Main {

	public static void merge2(ArrayList a, ArrayList b) {
		long t2, t1 = System.currentTimeMillis();
		// a.ensureCapacity(2 * b.size());
		ArrayList tmp = new ArrayList(a);
		a.addAll(b);
		for (int i = 0; i < b.size(); i++) {
			a.set(2 * i, tmp.get(i));
		}
		for (int i = 0; i < b.size(); i++) {
			a.set((2 * i) + 1, b.get(i));
		}
		for (int i = 0; i < a.size(); i++) {
			// System.out.print(a.get(i) + " ");
		}
		t2 = System.currentTimeMillis();
		System.out.println("time merge 2 = " + (t2 - t1));
	}

	public static void merge(ArrayList a, ArrayList b) {
		long t2, t1;
		t1 = System.currentTimeMillis();
		a.ensureCapacity(2 * b.size());
		for (int i = 0; i < b.size(); i++) {
			a.add((2 * i) + 1, b.get(i));
		}

		for (int i = 0; i < a.size(); i++) {
			// System.out.print(a.get(i) + " ");
		}
		t2 = System.currentTimeMillis();
		long t3 = t2 - t1;
		System.out.println("time merge 1 = " + t3);

	}

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		int ar[] = { 1, 2, 3 };
		int br[] = { 4, 5, 6 };
		ArrayList a1 = new ArrayList();
		ArrayList b1 = new ArrayList();
		// a1.add(1);
		// a1.add(2);
		// a1.add(3);
		// b1.add(4);
		// b1.add(5);
		// b1.add(6);
		for (int i = 0; i < 100000; i++) {
			a1.add(i + 1);
			b1.add(100000 + i);
		}
		ArrayList a2 = new ArrayList(a1);
		ArrayList b2 = new ArrayList(b1);
		merge(a2, b2);
		merge2(a1, b1);
		System.out.println("Уже при n=10_000 видна значительная разница.");
	}

}
