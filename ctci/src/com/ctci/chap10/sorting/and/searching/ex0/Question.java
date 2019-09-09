package com.ctci.chap10.sorting.and.searching.ex0;

/**
 * @author : Michael M
 */
public class Question {

    /*Let's write a quick sort with a single pivot (#^.^#)*/
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }

        quicksort(nums, 0, nums.length - 1);

        /*quicksort is a in-place sort*/
        return nums;
    }

    private void quicksort(int[] nums, int start, int end) { //all index is inclusive
        int index = partition(nums, start, end);  //the element at index is in the correct position
        if (start < index - 1) {
            quicksort(nums, start, index - 1);
        }
        if (index + 1 < end) {
            quicksort(nums, index + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) { //first element as pivot
        int pivot = nums[start];
        int left = start + 1;
        int right = end;
        while (left < right) {
            if (nums[right] > pivot) {
                right--;
            } else { //swap left and right
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
        //when exit, left == right, do a final check swap
        if (nums[right] > pivot) {
            right--;
        }
        int temp = nums[right];
        nums[right] = nums[start];
        nums[start] = temp;
        return right;

    }
}
