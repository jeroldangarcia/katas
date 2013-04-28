package kata;

class FizzBuzz {

	public String generate(int number) {

		if (number % 3 == 0 && number % 5 == 0) {
			return "fizzbuzz";
		}

		if (number % 3 == 0)
			return "fizz";

		if (number %5  == 0)
			return "buzz";

		return String.valueOf(number);
	}

}