import java.util.Arrays;
import java.util.stream.IntStream;

public class Project4 {
  /** Compute the largest power of two less than n. */
  static int largestPowerOfTwoLessThan(int n) {
    int base = 2;
    
    while (base < n) {
      base *= 2;
    }
    return base / 2;
  }
  
  /** The Collatz conjecture concerns the following process for generating a sequence of integers. 
      Start the sequence with any positive integer n. Then each term is obtained from the previous
      term as follows: 
      If the previous term is even, the next term is one half the previous term.
      Otherwise, the next term is 3 times the previous term plus 1. 
      The conjecture is that no matter what value of n, the sequence will always reach 1. 
      
      The Collatz stopping time for a number n is the steps needed before you reach 1. */
  static int collatzStoppingTime(int n) {
    int count = 0;
    
    if (n == 1) {
      return 0;
    }
    
    while (n > 1) {
      if (n % 2 == 0) {
        n /= 2;
        count++;
      }
      else {
        n = 3 * n + 1;
        count++;
      }
    }
     return count;
  }
  
  /** Determine if n is a perfect number. */
  static boolean isPerfect(int n) {
    int factors = 0, sum = 0;
    
    for (int i = 0; i < n; i++) {
      if (n % i == 0) {
        factors++;
      }
    }
    
    int[] factorsArray = new int[factors];
    int arrayPos = 0;
    for (int i = 1; i < n; i++) {
      if (n % i == 0) {
        factorsArray[arrayPos] = i;
        arrayPos++;
      }
    }
    
    for (int i = 0; i < factorsArray.length; i++) {
      sum += factorsArray[i];
      if (sum == n) {
        return true;
      }
    }
    return false;
  }
  
  /** Determine if n is a prime number. */
  static boolean isPrime(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      } 
      return true;
  }
    
  /** Compute the number of primes less than n. */
  static int primesSmallerThan(int n) {
    int primes = 0, i = 2;
    
    while (i < n) {
      if (isPrime(i)) {
        primes++;
      }
      i++;
    }
    return primes;
  }
  
  /** Compute the check digit for a number using the Luhn algorithm.
      This is the algorithm used to determine the last digit of credit cards
      and other identification numbers. It is inteded to protect against
      accidental errors, not to provide security. 
      
      We want to be able to compute check digits for 16 digit credit card numbers. */  
  static long lunhCheckDigit(long n) {
    long idx = 0, sum = 0; result;
    
    while (n > 0) {
      long dig = n % 10;
      
      if (idx % 2 == 1) {
        sum += dig;
      } else {
        dig *= 2;
        
        if (dig > 9) {
          dig -= 9;
        }
        sum += dig;
      }
      n /= 10;
      idx++;
    }
    sum *= 9;
    result = sum % 10;
    return result;
  }
  
  /** Given two arrays, the first with a collection of grades and the second with the array of grade cutoffs,
      return an array that give the number of grades that get each letter grade. Note that the number of 
      possible grades is one more than the length of the gradeCutOffs array. */
  static int[] gradeDistribution(int[] grades, int[] gradeCutOffs) {
    int[] possibleGrades = new int[gradeCutOffs.length + 1];
    
    for (int i = 0; i < grades.length; i++) {
      for (int j = 0; j < gradeCutOffs.length; j++) {
        if (grades[i] >= gradeCutOffs[j]) {
          possibleGrades[j] += 1;
          break;
        } else if (grades[i] < gradeCutOffs[gradeCutOffs.length-1]) {
          possiibleGrades[gradeCutOffs.length] += 1;
          break;
        }
      }
    }
    return possibleGrades;
  }
}
