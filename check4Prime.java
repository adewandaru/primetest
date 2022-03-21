
public class check4Prime {
    static final int max = 1000; // Set upper bounds.
    static final int min = 0; // Set lower bounds.
    static int input = 0; // Initialize input variable.

    public static void main(String[] args) {

        // Initialize class object to work with
        check4Prime check = new check4Prime();

        try {
            // Check arguments and assign value to input variable
            check.checkArgs(args);

            // Check for Exception and display help
        } catch (Exception e) {
            System.out.println("Usage: check4Prime x");
            System.out.println("       -- where 0<=x<=1000");
            System.exit(1);
        }

        // Check if input is a prime number
        if (check.primeCheck(input))
            System.out.println("Yippeee... " + input + " is a prime number!!");
        else
            System.out.println("Bummer... " + input + " is NOT a prime number!");

    } // End main

    // Calculates prime numbers and compares it to the input
    public boolean primeCheck(int num) {

        double sqroot = Math.sqrt(max); // Find square root of n

        // Initialize array to hold prime numbers
        boolean[] primeBucket = new boolean[max + 1];

        // Initialize all elements to true, then set non-primes to false
        for (int i = 2; i <= max; i++) {
            primeBucket[i] = true;
        }
        int j;
        for (j = 2; j <= sqroot; j++) { // do up to sqrt of n
            if (primeBucket[j] == true) { // only do if j is a prime
                for (int i = j + j; i <= max; i = i + j) { // start with 2j as j is prime
                    primeBucket[i] = false; // set all multiples to false
                }
            }
        }

        // Check input against prime array
        if (primeBucket[num] == true) {
            return true;
        } else {
            return false;
        }

    }// end primeCheck()

    // Method to validate input
    public void checkArgs(String[] args) throws Exception {
        // Check arguments for correct number of parameters
        if (args.length != 1) {
            throw new Exception();
        } else {
            // Get integer from character
            Integer num = Integer.valueOf(args[0]);
            input = num.intValue();

            // If less than zero
            if (input < 0) // If less than lower bounds
                throw new Exception();
            else if (input > max) // If greater than upper bounds
                throw new Exception();
        }
    }

}
