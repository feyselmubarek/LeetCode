class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        positions = {}
        
        for idx in range(len(nums)):
            second_num = target - nums[idx]
            if second_num in positions:
                return [positions[second_num], idx]
            
            positions[nums[idx]] = idx
            
        return []