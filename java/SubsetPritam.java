class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        //start with first element and empty list
        backtrack(0,new ArrayList<>(), results, nums);
        
        return results;
    }
    
    private void backtrack(int start, List<Integer> currList, List<List<Integer>> results, int[] nums) {
        //add to our results
        results.add(new ArrayList<>(currList));
        //loop through
        for(int i = start; i < nums.length; i++) {
            
            currList.add(nums[i]);
            
            //call recursively starting with next element
            //adds all subsets with our current set 
            backtrack(i+1, currList, results, nums);
            //reset state for next iteration
            //remove last element that was added earlier
            currList.remove(currList.size() - 1);
        }
        
    }
}
