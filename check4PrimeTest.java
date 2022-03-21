import junit.framework.*;

public class check4PrimeTest extends TestCase {

    // Initialize a class to work with.
    private check4Prime check4prime = new check4Prime();

    // constructor
    public check4PrimeTest(String name) {
        super(name);
    }

    // Main entry point
    public static void main(String[] args) {
        System.out.println("Starting test...");
        junit.textui.TestRunner.run(suite());
        System.out.println("Test finished...");
    } // end main()

    // Test case 1
    public void testCheckPrime_true() {
        int[] arrPrime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        for(int val: arrPrime){
            if (val >= check4Prime.min && val <= check4Prime.max) {
                assertTrue(check4prime.primeCheck(val));
            }
        }
    }

    // Test cases 2,3
    public void testCheckPrime_false() {
        int[] arrNonPrime = { 0, 1, 4, 6, 8 ,9, 10 ,12, 14 ,15, 16 ,18, 20, 21, 22, 24, 25, 26, 27, 28 , 30, 32, 33, 34, 35, 36, 38};
        for(int val: arrNonPrime){
            if (val >= check4Prime.min && val <= check4Prime.max) {
                assertFalse(check4prime.primeCheck(val));
            }
        }
    }

    // Test case 7
    public void testCheck4Prime_checkArgs_char_input() {
        try {
            String[] args = new String[1];
            args[0] = "r";
            check4prime.checkArgs(args);
            fail("Should raise an Exception.");
        } catch (Exception success) {
            // successful test
            assertNotNull(success);
        }
    } // end testCheck4Prime_checkArgs_char_input()

    // Test case 5
    public void testCheck4Prime_checkArgs_above_upper_bound() {
        try {
            String[] args = new String[1];
            args[0] = String.valueOf(check4Prime.max + 1);
            check4prime.checkArgs(args);
            fail("Should raise an Exception.");
        } catch (Exception success) {
            // successful test
            assertNotNull(success);
        }
    } // end testCheck4Prime_checkArgs_upper_bound()

    // Test case 4
    public void testCheck4Prime_checkArgs_neg_input() {
        try {
            String[] args = new String[1];
            args[0] = "-1";
            check4prime.checkArgs(args);
            fail("Should raise an Exception.");
        } catch (Exception success) {
            // successful test
            assertNotNull(success);
        }
    }// end testCheck4Prime_checkArgs_neg_input()

    // Test case 6
    public void testCheck4Prime_checkArgs_2_inputs() {
        try {
            String[] args = new String[2];
            args[0] = "5";
            args[1] = "99";
            check4prime.checkArgs(args);
            fail("Should raise an Exception.");
        } catch (Exception success) {
            // successful test
            assertNotNull(success);
        }
    } // end testCheck4Prime_checkArgs_2_inputs

    // Test case 8
    public void testCheck4Prime_checkArgs_0_inputs() {
        try {
            String[] args = new String[0];
            check4prime.checkArgs(args);
            fail("Should raise an Exception.");
        } catch (Exception success) {
            // successful test
            assertNotNull(success);
        }
    } // end testCheck4Prime_checkArgs_0_inputs

    // JUnit required method.
    public static TestSuite suite() {
        return new TestSuite(check4PrimeTest.class);
    }// end suite()

}
