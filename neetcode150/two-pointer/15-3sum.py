class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        triplets: set[tuple[int, int, int]] = set()
        nums.sort()

        for i in range(n - 2):
            target = 0 - nums[i]
            left = i + 1
            right = n - 1
            while (left < right):
                sum = nums[left] + nums[right]
                if target == sum:
                    triplet = (nums[i], nums[left], nums[right])
                    if not triplet in triplets:
                        triplets.add(triplet)
                    left += 1
                    right -= 1
                elif sum < target:
                    left += 1
                else:
                    right -= 1
        return [list(triplet) for triplet in triplets]
