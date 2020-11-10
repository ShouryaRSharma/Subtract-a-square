import java.util.Arrays;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        int number = 0;
        int count = 1;
        int player = 1;
        boolean isInteger = false;
        int input = 0;
        try (Scanner sc = new Scanner(System.in)) {
            number = 39;
            while (number > 0) {
                int numberArray[] = generatePerfectSquare(1, number);
                System.out.println("Coins remaining: " + number);
                System.out.println("===================");
                System.out.println("perfect square numbers");
                for (int i : numberArray) {
                    System.out.print(i);
                    System.out.print("   ");
                }
                System.out.println("");
                System.out.println("===================");
    
                player = ((count % 2 == 0) ? 2 : 1);
                System.out.println("Round : " + count + "   Player : " + player);
                System.out.println("Please Enter your prefered perfect square number");
                
                if (sc.hasNextInt()) {
                    input = sc.nextInt();
                    isInteger = true;
                } else if (!sc.hasNextInt()) {
                    System.out.println("===================");
                    System.out.println("PLEASE ENTER AN INTEGER");
                    System.out.println("Coins left: " + number);
                    System.out.println("===================");
                    sc.next();
                    continue;
                }

                if (isPerfectSquare(input) && input > 0 && input < number) {
                    number = number - input;
                } else if (!isPerfectSquare(input)){
                    if (input <= 0) {
                        System.out.println("===================");
                        System.out.println("PLEASE ENTER AN INTEGER GREATER THAN 0");
                        System.out.println("===================");
                        sc.next();
                        continue;
                    } else if (input > number) {
                        System.out.println("===================");
                        System.out.println("PLEASE ENTER AN INTEGER GREATER THAN 0");
                        System.out.println("===================");
                        sc.next();
                        continue;
                    } else {
                        System.out.println("===================");
                        System.out.println("PLEASE ENTER A SQUARE NUMBER");
                        System.out.println("===================");
                        sc.next();
                        continue;
                    }
                } else if (input <= 0) {
                    System.out.println("===================");
                    System.out.println("PLEASE ENTER AN INTEGER GREATER THAN 0");
                    System.out.println("===================");
                    sc.next();
                    continue;
                } else if (input > number) {
                    System.out.println("===================");
                    System.out.println("PLEASE ENTER AN INTEGER LOWER THAN " + number);
                    System.out.println("===================");
                    sc.next();
                    continue;
                }

                if (number <= 0) {
                    System.out.println("****************");
                    System.out.println("You won the game");
                    System.out.println("===================");
                } else if (number > 0) {
                    System.out.println("===================");
                    System.out.println("===================");
                }
                count++;
            }
        } catch (Exception e) {
            System.out.println("Please ensure you enter integers");
        }
    
    }
    
    private static int[] generatePerfectSquare(int start, int end) {
    
        if (start > end || start < 0) {
            throw new IllegalArgumentException();
        }
        int[] perfectSquares = new int[end - start];
        int n = 0;
        int candidate = (int) Math.ceil(Math.sqrt(start));
        int square;
        while ((square = candidate * candidate) < end) {
            perfectSquares[n++] = square;
            candidate++;
        }
        return Arrays.copyOf(perfectSquares, n);
    }

    private static boolean isPerfectSquare(int n) {
        double sr = Math.sqrt(n);
        return((sr - Math.floor(sr)) == 0);
    }

}