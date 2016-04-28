
public class Le_215_Kth_Largest_Element_in_an_Array {
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    
    public int quickSelect(int[] nums, int start, int end, int k){
        if(start == end){
            return nums[start];
        }
        
        int position = partition(nums, start, end);
        if(position + 1 == k){
            return nums[position];
        } else if(position + 1 < k){
            return quickSelect(nums, position + 1, end, k);
        } else {
            return quickSelect(nums, start, position - 1, k);
        }
    }
    
    public int partition(int[] nums, int left, int right){
        if(left == right){
            return left;
        }
        
        int pivot = nums[right];
        int index = left;
        int temp = 0;
        
        for(int i = left; i < right; i++){
            if(nums[i] <= pivot){
                temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
        
        temp = nums[index];
        nums[index] = nums[right];
        nums[right] = temp;
        return index;
    }
}
