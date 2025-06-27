//Time Complexity : O(Nlogn) where n is length of bigger array
//Space Complexity : O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2= nums2.length;

        if(n1>n2){
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int low =0; int high = n2-1;
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n1; i++){
            int target = nums1[i];
            int bsIndex = binarySearch(nums2, low, high, target);
            if(bsIndex != -1){
                result.add(target);
            low = bsIndex +1;
        }
        }

        int[] resArray = new int[result.size()];
        for(int k=0; k < result.size(); k++){
            resArray[k] = result.get(k);
        }
        return resArray;
    }
    private int binarySearch(int [] arr,  int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                if(mid == low || arr[mid] > arr[mid - 1]){
                    return mid;
                } else {
                    high = mid -1;
                }
            } else if(arr[mid] > target){
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
