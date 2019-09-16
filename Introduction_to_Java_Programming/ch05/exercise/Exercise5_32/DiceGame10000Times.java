public class DiceGame10000Times {
	public static void main(String[] args) {
		int number1, number2;
		int winCount = 0;

        for (int i = 0; i < 10000; i++) {
	        number1 = (int)(Math.random() * 10) % 6 + 1;
		    number2 = (int)(Math.random() * 10) % 6 + 1;

            //System.out.println("You rolled " + number1 + " + "
        	//	+ number2 + " = " + (number1 + number2));
        	//System.out.print("You ");
        	if (WinOrLose(number1, number2)) {
                winCount++;
        	}
        }	
        System.out.print("You win " + winCount + " times");
	}

	public static boolean WinOrLose(int number1, int number2) {
        if (number1 + number2 == 2 || 
        	number1 + number2 == 3 || 
        	number1 + number2 == 12)
        	return false;
        else if (number1 + number2 == 7 || number1 + number2 == 11) 
        	return true;
        else {
        	int point = number1 + number2;
        	//System.out.print("point is " + point + "\n");
        	do {
            	number1 = (int)(Math.random() * 10) % 6 + 1;
            	number2 = (int)(Math.random() * 10) % 6 + 1; 
            	//System.out.println("You rolled " + number1 + " + "
        	        //+ number2 + " = " + (number1 + number2));       
        	} while (number1 + number2 != 7 && number1 + number2 != point);
        	if (number1 + number2 == 7)
        		return false;
        	else 
        		return true;
        }
	}
}