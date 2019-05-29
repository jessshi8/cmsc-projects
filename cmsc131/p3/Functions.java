class Functions {
  /** Count number of unique values in parameters. */
  static int countUnique(int a, int b) {
    if (a == b) {
      return 1;
    } else {
      return 2;
    }
  }
  
  /** Count number of unique values in parameters. */
  static int countUnique(int a, int b, int c) {
    if (a == b) {
      if (a == c) {
        return 1;
      } else {
        return 2;
      }
    }
    else {
      if (a == c) {
        return 2;
      } else {
        return 3;
      }
    }
  }
  
  /** Return the largest value of the parameters. */
  static int max(int a, int b, int c) {
    int max = a;
    
    if (b > max) {
      max = b;
    }
    if (c < max) {
      max = c;
    }
    return max;
  }
  
  /** Counts the number of factors of the variable n that are less than n. */
  static int countFactors(int n) {
    int count = 0;
    
    for (int i = 1; i < n; i++) {
      if (n % i == 0) {
        count++;
      }
    }
    return count;
  }
  
  /** Given an array of integers, we want to count the number of adjacent pairs
      where the first number is less than the second element. */
  static int countAdjacentIncreasing(int[] a) {
    int count = 0;
    
    for (int i = 0; i < a.length-1; i++) {
      if (a[i+1] > a[i]) {
        count++;
      }
    }
    return count;
  }
}
