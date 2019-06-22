lass Solution {
    
    private  List<List<Integer>> permList = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();   
        
        Integer[] numArray = new Integer[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            numArray[i] = nums[i];
        }
        
        permuteHelper(0,nums.length -1, numArray);
        
        result = new ArrayList<>(permList);
        
        return result;
    }
    
    private void permuteHelper(int start, int end, Integer[] nums) {
        List<Integer> l = new ArrayList<>();
        if(start >= end) {
            l = Arrays.asList(nums);
            permList.add(l);
        }
       
            for(int i = start; i <= end; i++) {
                swap(nums, start, i);
                permuteHelper(start+1,end, nums);
                swap(nums, start, i);
            }
        
        
    }
    
    // Use Collection.swap
    public List<Integer> swap(Integer[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        
        return new ArrayList<>(Arrays.asList(nums));
    }
}
