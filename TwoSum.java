/**
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target. You may assume that each input would have exactly one 
 * solution, and you may not use the same element twice. You can return the answer in any order.
 * @author Rahul S Koimattur
 * Intuition : Create a mapping between the element and its index in a HashMap. loop through the array
 *             to search for the element which add up to the target value and once found return the
 *             respective indices using HashMap.
 */
 
 class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
           hm.put(nums[i],i);
        }
        for(int j=0;j<nums.length;j++){
          int tot=target-nums[j];
          if(hm.containsKey(tot) && hm.get(tot)!=j){
              return new int[]{j,hm.get(tot)};
          }     
        }
        return new int[]{-1,-1};
     }
}
