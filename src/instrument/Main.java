package instrument;

abstract class Instrument{
	public abstract void makeSound();
}

class Erhu extends Instrument{
	public void makeSound() {
		System.out.println("Musician is now playing Erhu.");
	}
}

class Piano extends Instrument{
	public void makeSound() {
		System.out.println("Musician is now playing the Piano.");
	}
}

class Violin extends Instrument{
	public void makeSound() {
		System.out.println("Musician is now playing Violin.");
	}
}

class Musician{
	public void play(Instrument i) {
		i.makeSound();
	}
}

public class Main {
	public static void main(String[] args) {
		Musician m = new Musician();
		Erhu e = new Erhu();
		Violin v = new Violin();
		Piano p = new Piano();
		m.play(e);
		m.play(p);
		m.play(v);
	}
}
