
public class check4Prime {
    static final int max = 1000; // Set upper bounds.
    static final int min = 0; // Set lower bounds, must be nonnegative
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
            System.out.println("       -- where " + min + "<=x<=" + max);
            System.exit(1);
        }

        // Check if input is a prime number
        if (check.primeCheck(input)) {
            System.out.println("Yippeee... " + input + " is a prime number!!");
        } else {
            System.out.println("Bummer... " + input + " is NOT a prime number!");
        }
    }

    // Calculates prime numbers and compares it to the input
    // todo: replace algorityhm with better complexity
    public boolean primeCheck(int num) {

        double sqroot = Math.sqrt(max); // Find square root of n

        // Initialize array to hold prime numbers
        boolean[] primeBucket = new boolean[max + 1];

        // Initialize all elements to true, then set non-primes to false
        // Start with index 2 since we know both 0 and 1 are non prime
        for (int i = 2; i <= max; i++) {
            primeBucket[i] = true;
        }

        for (int j = 2; j <= sqroot; j++) { // do up to sqrt of n
            if (primeBucket[j]) { // only do if j is a prime
                for (int i = j + j; i <= max; i = i + j) { // start with 2j as j is prime
                    primeBucket[i] = false; // set all multiples to false
                }
            }
        }

        // Check input against prime array
        return primeBucket[num];
    }

    // Method to validate input
    public void checkArgs(String[] args) throws Exception {
        // Check arguments for correct number of parameters
        if (args.length != 1) {
            throw new Exception();
        }

        // Get integer from character
        input = Integer.parseInt(args[0]);

        // If less than lower bounds or greater than upper bounds
        if (input < min || input > max) {
            throw new Exception();
        }
    }

}
