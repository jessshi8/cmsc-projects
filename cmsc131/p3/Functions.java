class Functions {
  static int countUnique(int a, int b) {
    if (a == b) {
      return 1;
    } else {
      return 2;
    }
  }
  
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
  
  static int countFactors(int n) {
    int count = 0;
    
    for (int i = 1; i < n; i++) {
      if (n % i == 0) {
        count++;
      }
    }
    return count;
  }
  
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
