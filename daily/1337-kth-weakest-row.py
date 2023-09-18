import heapq
from typing import List


class Solution:
    def binarySearch(self, arr: List[int]) -> int:
        left, right = 0, len(arr) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if arr[mid] == 1:
                left = mid
            else:
                right = mid - 1
        return left

    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        strengths = [(self.binarySearch(row), index) for index, row in enumerate(mat)]
        heapq.heapify(strengths)
        return [index for _, index in heapq.nsmallest(k, strengths)]
