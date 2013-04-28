package kata;

class FizzBuzzApp {
	
	public static void main(String[] args) {
		FizzBuzz fizzbuzz = new FizzBuzz();
		for (int i=1; i<=100; i++) {
			System.out.println("number "+i+" --> "+fizzbuzz.generate(i));
		}
	}
}