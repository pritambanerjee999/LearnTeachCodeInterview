class Solution {
        /*
        Impl:
        - Permutation can be expressed recursively
        - loop through items and call permutations recrusively
        
        input: (1,2,3)
         - 1 => (2,3)
             - 2 => (3) => ADD(1,2,3)
             - 3 => (2) ADD(1,3,2
         - 2 => (1,3)
             - 1 => (3) => ADD(2,1,3)
         **and so on...** 
        */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsAsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
      
        backtrack(0, numsAsList, result);
        return result;
    }
    
    private void backtrack(int start, List<Integer> nums, List<List<Integer>> result) {
        //base case:
        //we're on the last element, nothing else to do
        if(start == nums.size() - 1)  {
            result.add(new ArrayList<>(nums));
        }
        //do a permuatation for i...nums.size-1
        for(int i=start; i < nums.size(); i++) {
            Collections.swap(nums, start,i);
            
            //System.out.println(nums.toString());
            //generate permutations for i+1...nums.size
            backtrack(start + 1, nums, result);
            //reset original state of nums for next iteration 
            Collections.swap(nums,start,i);
        }
        
    }
}
