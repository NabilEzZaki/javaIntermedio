package esercizi;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

        public static int[] twoSum(int[] nums, int target) {
            // Create a Map to store the complement of each number and its index
            Map<Integer, Integer> numMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                // Calculate the complement for the current number
                int complement = target - nums[i];

                // Check if the complement is already in the Map
                if (numMap.containsKey(complement)) {
                    // If found, return the indices of the two numbers
                    return new int[]{numMap.get(complement), i};
                }

                // If not found, add the current number and its index to the Map
                numMap.put(nums[i], i);
            }

            // If no solution is found
            return null;
        }
}
