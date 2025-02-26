public class Utility {

	/**
	 * Test whether a specific number is a prime number.
	 * 
	 * @param num
	 *            the number
	 * @return <code>true</code> if <code>num</code> is a prime number.
	 */
	public static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i < (int)Math.sqrt(num) + 1; i++) {
			if (num % i == 0){
				return false;
			}
		}
		return true;
	}

	/**
	 * Test whether a specific number is a square number.
	 * 
	 * @param num
	 *            the number
	 * @return <code>true</code> if <code>num</code> is a square number.
	 */
	public static boolean isSquare(int num) {
		int x = (int) Math.sqrt(num);
		return x*x == num;
	}

	public static int getFibonacciIndex(int n) {
        // Với dãy Fibonacci định nghĩa như trên, chỉ xét n >= 1
        if (n < 1) return -1;
        // Vì 1 xuất hiện ở vị trí F1 và F2, ta chọn trả về vị trí đầu tiên (F1)
        if (n == 1) return 1;
        
        int index = 2; // b là F2
        int a = 1, b = 1;
        
        // Tính các số Fibonacci tiếp theo cho đến khi b >= n
        while (b < n) {
            int c = a + b;
            a = b;
            b = c;
            index++;
            if (b == n) {
                return index;
            }
        }
        
        return -1;
    }
}
