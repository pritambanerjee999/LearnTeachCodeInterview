class Solution {
    
    private Set<List<Integer>> set = new HashSet<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result = permute(result, nums, 0, nums.length - 1);
        set = new HashSet<>(result);
        return new ArrayList<>(set);
    }
    
    
    private List<List<Integer>> permute(List<List<Integer>> result, int[] nums, int start, int end) {
        if(start == end) {
            result.add(convertArr(nums));
        }
        else {
            for(int i = start; i <= end; i++) {
                swap(nums, start, i);
                permute(result, nums, start + 1, end);
                swap(nums, start, i);
            }
        }
        return result;
    } 
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    private List<Integer> convertArr(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for(Integer n: nums) {
            list.add(n);
        }
        
        return list;
    }
}
