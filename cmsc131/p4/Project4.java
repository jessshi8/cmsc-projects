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
  
  
}
