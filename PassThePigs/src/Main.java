import java.util.Scanner;
import java.util.Random;
public class Main {
	static int i = 0;
	static int playerOneScore = 0;
	static int playerTwoScore = 0;
	static int tempScore = 0;
	static int finalCount = 0;
	public static void main(String[] args) {

		passThePigs();
	}
	static void reset() {
		playerOneScore = 0;
		playerTwoScore = 0;
		i = 0;
		tempScore = 0;
		finalCount = 0;
		passThePigs();
	}
	static void scoreOption() {
		Random random = new Random();
		int firstPig = random.nextInt(3);
		int secondPig = random.nextInt(3);
		switch(firstPig+"|"+secondPig) {
			case "0|0":{
				System.out.println("You got a Sider worth 1 point");
				tempScore++;
				break;
				}
			case "0|1":{
				System.out.println("You got a Razorback worth 5 point");
				tempScore = tempScore +5;
				break;
			}
			case "0|2":{
				System.out.println("You got a Pig Out and lose your points for the turn");
				tempScore = 0;
				if (i == 0) {
					i++;
					break;
				}
				else {
					i--;
					break;
				}
			}
			case "1|0":{
				System.out.println("You got a Razorback worth 5 point");
				tempScore = tempScore +5;
				break;
			}
			case "1|1":{
				System.out.println("You got a Double Razorback worth 20 point");
				tempScore = tempScore + 20;
				break;
			}
			case "1|2":{
				System.out.println("You got a Razorback worth 5 point");
				tempScore = tempScore +5;
				break;
			}
			case "2|0":{
				System.out.println("You got a Pig Out and lose your points for the turn");
				tempScore = 0;
				if (i == 0) {
					i++;
					break;
				}
				else {
					i--;
					break;
				}
			}
			case "2|1":{
				System.out.println("You got a Razorback worth 5 point");
				tempScore = tempScore +5;
				break;
			}
			case "2|2":{
				System.out.println("You got a Double Razorback worth 20 point");
				tempScore = tempScore + 20;
				break;
			}
			default:{
				System.out.println("You got a Sider worth 1 point");
				tempScore++;
				break;
			}
		}
	}
	static void scoreOptionFinal() {
		Random random = new Random();
		int firstPig = random.nextInt(3);
		int secondPig = random.nextInt(3);
		if (firstPig == 0 && secondPig == 0 ) {
			System.out.println("You got a Sider worth 1 point");
			tempScore++;
		}
		else if (firstPig == 0 && secondPig == 1 ) {
			System.out.println("You got a Razorback worth 5 point");
			tempScore = tempScore +5;
		}
		else if (firstPig == 0 && secondPig == 2) {
			System.out.println("You got a Pig Out and lose your points for the turn");
			tempScore = 0;
			finalCount = 1;
			if (i == 0) {
				i++;
			}
			else {
				i--;
			}
		}
		else if (firstPig == 1 && secondPig == 0 ) {
			System.out.println("You got a Razorback worth 5 point");
			tempScore = tempScore +5;
		}
		else if (firstPig == 1 && secondPig == 1 ) {
			System.out.println("You got a Double Razorback worth 20 point");
			tempScore = tempScore + 20;
		}
		else if (firstPig == 1 && secondPig == 2 ) {
			System.out.println("You got a Razorback worth 5 point");
			tempScore = tempScore +5;
		}
		else if (firstPig == 2 && secondPig == 0) {
			System.out.println("You got a Pig Out and lose your points for the turn");
			tempScore = 0;
			finalCount = 1;
			if (i == 0) {
				i++;
			}
			else {
				i--;
			}
		}
		else if (firstPig == 2 && secondPig == 1 ) {
			System.out.println("You got a Razorback worth 5 point");
			tempScore = tempScore +5;
		}
		else if (firstPig == 2 && secondPig == 2 ) {
			System.out.println("You got a Double Razorback worth 20 point");
			tempScore = tempScore + 20;
		}
		else {
				System.out.println("You got a Sider worth 1 point");
				tempScore++;
			}
		} 
	static void passThePigs() {
		Scanner scanner = new Scanner(System.in);
		if (playerOneScore >= 100 && finalCount == 1 || playerTwoScore >= 100 && finalCount == 1 ) {
			if (playerOneScore > playerTwoScore) {
				System.out.println("Congrats Player 1 won with a score of " + playerOneScore);
				System.out.println("To play again type reset, anything else will terminiate the program!");
				String reset = scanner.nextLine();
				reset = reset.toLowerCase();
				if (reset.equals("reset")){
					reset();
				}
				else {
					System.exit(0);
				}
			}
			else {
				System.out.println("Congrats Player 2 won with a score of " + playerTwoScore);
				System.out.println("To play again type reset, anything else will terminiate the program!");
				String reset = scanner.nextLine();
				reset = reset.toLowerCase();
				if (reset.equals("reset")){
					reset();
				}
				else {
					System.exit(0);
				}
			}
		}
		if (playerOneScore >= 100 && finalCount == 0 || playerTwoScore >= 100 && finalCount == 0 ) {
			if (i == 0) {
				System.out.println("Player 1, you currently have a total of "+ playerOneScore +" points. With a turn score of " + tempScore + " points.\nThis is your final turn, enter 1 to keep rolling and anything else to stop. You have to beat " + playerTwoScore);
				int playerOneOption = scanner.nextInt();
				scanner.nextLine();
				if (playerOneOption == 1) {
					scoreOptionFinal();
					passThePigs();
				}
				else {
					playerOneScore = playerOneScore + tempScore;
					finalCount = 1;
					tempScore = 0;
					i++;
					passThePigs();
				}
			}
			else {
				System.out.println("Player 2, you currently have a total of "+ playerTwoScore +" points. With a turn score of " + tempScore + " points.\nThis is your final turn, enter 1 to keep rolling and anything else to stop. You have to beat " + playerOneScore);
				int playerTwoOption = scanner.nextInt();
				scanner.nextLine();
				if (playerTwoOption == 1) {
					scoreOptionFinal();
					passThePigs();
				}
				else {
					playerTwoScore = playerTwoScore + tempScore;
					finalCount = 1;
					tempScore = 0;
					i--;
					passThePigs();
				}
			}
		}
		if (i == 0) {
			System.out.println("Player 1, you currently have a total of "+ playerOneScore +" points. With a turn score of " + tempScore + " points. Would you like to continue? Type 1 to continue or anything else to pass");
			int playerOneOption = scanner.nextInt();
			scanner.nextLine();
			if (playerOneOption == 1) {
				scoreOption();
				passThePigs();
			}
			else {
				playerOneScore = playerOneScore + tempScore;
				tempScore = 0;
				i++;
				passThePigs();
			}
		}
		else {
			System.out.println("Player 2, you currently have a total of "+ playerTwoScore +" points. With a turn score of " + tempScore + " points. Would you like to continue? Type 1 to continue or anything else to pass");
			int playerTwoOption = scanner.nextInt();
			scanner.nextLine();
			if (playerTwoOption == 1) {
				scoreOption();
				passThePigs();
			}
			else {
				playerTwoScore = playerTwoScore + tempScore;
				tempScore = 0;
				i--;
				passThePigs();
			}
		}
	}

}
