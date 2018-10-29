"""
Find duplicate numbers in an array with numbers from 0 to n-1

Do in 
Time: O(n)
Space: O(1)
"""

def find_duplicates(arr):
    """
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    for i in range(len(arr)):
        if arr[abs(arr[i])] > 0:
            arr[abs(arr[i])] = -arr[abs(arr[i])]
        else:
            print(abs(arr[i]), end=' ')


arr = [1, 2, 1, 3, 3, 4, 5, 6, 6]
find_duplicates(arr)
