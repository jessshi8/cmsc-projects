import java.util.Arrays;
import java.util.stream.IntStream;

public class Project4 {
  static int largestPowerOfTwoLessThan(int n) {
    int base = 2;
    
    while (base < n) {
      base *= 2;
    }
    return base / 2;
  }
  
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
