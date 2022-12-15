import random
import time

def bubble(arr):
    for i in range(len(arr)):
        for j in range(len(arr) - i -1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]

def selection(arr):
    def find_min_index(arr):
        min_ = 0
        for i in range(1, len(arr)):
            if (arr[min_] > arr[i]):
                min_ = i
        return min_
    
    for i in range(len(arr) - 1):
        index = find_min_index(arr[i:]) + i
        if (i != index):
            arr[i], arr[index] = arr[index], arr[i]

def merge(arr):
    def combine(arr1, arr2):
        arr3 = []
        p1 = 0
        p2 = 0
        while (p1 < len(arr1) and p2 < len(arr2)):
            if (arr1[p1] > arr2[p2]):
                arr3.append(arr2[p2])
                p2 += 1
            else:
                arr3.append(arr1[p1])
                p1 += 1

        if (p1 != len(arr1)):
            arr3 += arr1[p1:]

        elif (p2 != len(arr2)):
            arr3 += arr2[p2:]

        return arr3
    
    size = len(arr)

    if (size > 1):
        part = int(size/2)

        left = merge(arr[:part])
        right = merge(arr[part:])

        return combine(left, right)

    else:
        return arr

def insertion(arr):

    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        
        # keep moving elements till spot is found
        while j >= 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j = j - 1
        
        # Place key at after the element just smaller than it.
        arr[j + 1] = key


def test_algorithm(algorithm, name):
    size = 2000
    arr = [random.randint(1, 400) for _ in range(size)]
    worst_case = list(reversed(sorted(arr)))
    sorted_arr = sorted(arr)

    times = []

    times.append(time.perf_counter())
    return_val1 = algorithm(arr)
    times.append(time.perf_counter())
    return_val2 = algorithm(worst_case)
    times.append(time.perf_counter())

    if (return_val1 is not None):
        arr = return_val1
    if (return_val2 is not None):
        worst_case = return_val2

    print(f"{name} took {times[1] - times[0]} for random case")
    print(f"{name} took {times[2] - times[1]} for worst_case case")
    print()

    if arr != sorted_arr:
        print(f"{name} failed random case")
        print(f"Expected: {sorted_arr}")
        print(f"Output: {arr}")
        print()
    else:
        print(f"{name} succeed for random case");
    
    if worst_case != sorted_arr:
        print(f"{name} failed worst case")
        print(f"Expected: {sorted_arr}")
        print(f"Output: {worst_case}")
        print()
    else:
        print(f"{name} succeed for worst case");

    print()


def main():
    test_algorithm(bubble, "bubble")
    test_algorithm(selection, "selection")
    test_algorithm(insertion, "insertion")
    test_algorithm(merge, "merge")

if __name__ == "__main__":
    main()
