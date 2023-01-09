public class BreakContinue {
  public static void windowPosSum(int[] a, int n) {
    for(int i = 0; i < a.length; i++){
      if(a[i] < 0) continue;
      int sum = 0;
      for(int j = 0; j <= n; j++){
        if(i + j >= a.length) break;
        sum += a[i + j];
      }
      a[i] = sum;
    }
  }

  /*
  Replace a[0] with a[0] + a[1] + a[2] + a[3].
  Replace a[1] with a[1] + a[2] + a[3] + a[4].
  Not do anything to a[2] because it’s negative.
  Replace a[3] with a[3] + a[4] + a[5].
  Replace a[4] with a[4] + a[5].
  Not do anything with a[5] because there are no values after a[5].
  */

  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}