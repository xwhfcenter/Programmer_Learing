public class TestPrintCharacter {
	public static void main(String[] args) {
		printChars('1', 'Z', 10);
	}

	public static void printChars(char ch1, char ch2, int numberPerLine) {
		int i = 0;
		for (char ch = ch1; ch <= ch2; ch++) {
			System.out.print(ch + "\t");
			i++;
			if (i == numberPerLine) {
				System.out.print("\n");
				i = 0;
			}
		}
	}
}