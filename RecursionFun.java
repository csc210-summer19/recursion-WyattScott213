/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Wyatt Scott
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1)
			return n;
		else if (n == 1)
			return 1;
		else if (n > k && k > 1)
			return (combinations(n - 1, k - 1) + combinations(n - 1, k));
		return 1;
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		// TODO: Implement this method using recursion. Do not use a loop
		String value = intWithCommasHelper(n);
		return value;
	}

	public String intWithCommasHelper(int n) {
		String value = "";
		if (n >= 1000) {
			value = value + intWithCommas(n / 1000);
			value = value + ",";
			if ((n % 1000) < 10)
				value = value + "0";
			if ((n % 1000) < 100)
				value = value + "0";
			value = value + Integer.toString(n % 1000);
		} else {
			return Integer.toString(n);
		}
		return value;
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public int[] reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		int[] reversed = new int[x.length];
		reverseArray(x, 0, x.length - 1, reversed);
		x = reversed;
		return x;
	}

	private void reverseArray(int[] x, int index, int len, int[] reversed) {
		if (len == 0)
			reversed[index] = x[len];
		else {
			reversed[index] = x[len];
			reverseArray(x, index + 1, len - 1, reversed);
		}

		// TODO: Complete this method with a recursive algorithm.
		// Do NOT use a loop.
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int[] Value = new int[2];
		Value[0] = a[0];
		Value[1] = a[0];
		Value = arrayRangeH(a, Value, 0);
		return Value[1] - Value[0];
	}

	public int[] arrayRangeH(int[] a, int[] Value, int index) {
		if (index == a.length)
			return Value;
		else {
			if (a[index] > Value[1])
				Value[1] = a[index];
			if (a[index] < Value[0])
				Value[0] = a[index];
			arrayRangeH(a, Value, index + 1);
		}
		return Value;
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		int index = 0;
		boolean Variable;
		Variable = isSortedH(nums, index);
		// Need to send down 0 to keep track of the index
		return Variable;
	}

	public boolean isSortedH(int[] nums, int index) {
		if (index == nums.length - 1 || nums.length < 1) {
			return true;
		} else {
			if (nums[index] > nums[index + 1]) {
				return false;
			} else
				return isSortedH(nums, index + 1);
		}
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		int index = 0;
		boolean Value;
		Value = foundHelper(search, strs, index);
		return Value;
	}

	public boolean foundHelper(String search, String[] strs, int index) {
		if (index == strs.length)
			return false;
		else {
			if (strs[index].contentEquals(search))
				return true;
			else
				return foundHelper(search, strs, index + 1);
		}

	}
}
