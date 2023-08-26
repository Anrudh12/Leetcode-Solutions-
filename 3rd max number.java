/**
 * Third Maximum Number: Given an integer array nums, return the third distinct maximum number in
 * this array. If the third maximum does not exist, return the maximum number.
 * 
 * Constraints: 
 * 1 <= nums.length <= 10^4 
 * -2^31 <= nums[i] <= (2^31) - 1
 */
public class Solution {
  public int thirdMax(final int[] n) {
    // When size is 1, n[0] is max and is the sole max found so far.
    // When size is 2, two maxes have been found and are stored in n[0] and n[1], where n[0] < n[1].
    // When size is 3, three maxes are stored in n[0], n[1], and n[1], where n[0] < n[1] < n[2].
    int size = 1; // init, given n.length >= 1. One max found so far, n[0]

    // finds second max
    int i = 1;
    for (; size == 1 && i < n.length; i++) { // exits when second max has been found, or exhausted input
      // invariants: i >= 1, size == 1
      if (n[0] < n[i]) { // detects new max
        n[1] = n[i]; // insert new max
        size++; // increment size, as there are now 2 maxes found
      } else if (n[i] < n[0]) { // detects new 2nd max
        final int tmp = n[i]; // needed since i could be 1
        n[1] = n[0]; // bump up
        n[0] = tmp; // insert the new 2nd max
        size++; // increment size, as there are now 2 maxes found
      } // else n[i] is equal to n[0], which means no new max, so do nothing.
    }

    // finds 3rd max
    for (; size == 2 && i < n.length; i++) { // exits when third max has been found, or exhausted input
      // invariants: i >= 2, size == 2
      if (n[1] < n[i]) { // detects new max
        n[2] = n[i]; // insert new max
        size++; // increment size, as there are now 3 maxes found
      } else if (n[0] < n[i] && n[i] < n[1]) { // detects new 2nd max
        final int tmp = n[i]; // needed since i could be 2
        n[2] = n[1];  // bump up
        n[1] = tmp; // insert new 2nd max
        size++; // increment size, as there are now 3 maxes found
      } else if (n[i] < n[0]) { // detects 3rd max
        final int tmp = n[i]; // needed since i could be 2
        n[2] = n[1]; // bump up
        n[1] = n[0]; // bump up
        n[0] = tmp; // insert third
        size++; // increment size, as there are now 3 maxes found
      } // else n[i] is equal to one of the maxes, which means no new max, so do nothing.
    }

    // finds higher 3rd max
    for (; i < n.length; i++) {
      // invariants: i >= 3, size == 3
      if (n[2] < n[i]) { // detects new max
        n[0] = n[1]; // bump down
        n[1] = n[2];  // bump down
        n[2] = n[i]; // inserts new max
      } else if (n[1] < n[i] && n[i] < n[2]) { // detects new 2nd max
        n[0] = n[1]; // bump down
        n[1] = n[i]; // insert new 2nd max
      } else if (n[0] < n[i] && n[i] < n[1]) { // detects new 3rd max
        n[0] = n[i]; // replace 3rd max
      } // else n[i] equals one of the maxes, or is less than the 3rd max, so do nothing
    }

    // Returns the third maximum number. If third maximum does not exist, return the maximum number.
    //   When size equals 3, 3 maxes were found, n[0] < n[1] < n[2]. Return the 3rd maxium, n[0]
    //   When size equals 2, 2 maxes were found. n[0] < n[1]. No 3rd max found, so return the max, n[1].
    //   When size equals 1, 1 max was found, n[0]. Return the max, n[0].
    return size == 2 ? n[1] : n[0];
  }
}
