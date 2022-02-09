class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        i = 0
        j = len(nums) - 1
        # self.quick_sort(nums, i, j)
        
        while i < j:
            s = nums[i] + nums[j]
            if s < target:
                i += 1
            elif s > target:
                j -= 1
            else:
                return [i + 1, j + 1]
        return []
    
    def partition(self, array, start_idx, end_idx):
        pivot = array[end_idx]
        index = start_idx
        smaller_idx = start_idx

        while index < end_idx:
            if array[index] <= pivot:
                array[index], array[smaller_idx] = array[smaller_idx], array[index]
                smaller_idx += 1
            index += 1

        array[end_idx], array[smaller_idx] = array[smaller_idx], array[end_idx]
        return smaller_idx

    def quick_sort(self, array, start_idx, end_idx):
        if start_idx > end_idx:
            return

        partition_idx = self.partition(array, start_idx, end_idx)
        self.quick_sort(array, start_idx, partition_idx - 1)
        self.quick_sort(array, partition_idx + 1, end_idx)
