def merge(arr, l, r, mid):
    n1 = mid - l + 1
    n2 = r - mid
    L = [arr[i] for i in range(l, mid + 1)]
    R = [arr[i] for i in range(mid + 1, r + 1)]
    i = j = 0
    k = l
    inv_count = 0
    while i < n1 and j < n2:
        if L[i] <= R[j]:
            arr[k] = L[i]
            i += 1
        else:
            arr[k] = R[j]
            inv_count += (mid - i - l + 1)
            j += 1
        k += 1
    while i < n1:
        arr[k] = L[i]
        i += 1
        k += 1
    while j < n2:
        arr[k] = R[j]
        j += 1
        k += 1
    return inv_count


def mergesort(arr, l, r):
    inv_count = 0
    if l < r:
        mid = (l + r) // 2
        inv_count += mergesort(arr, l, mid)
        inv_count += mergesort(arr, mid + 1, r)
        inv_count += merge(arr, l, r, mid)
    return inv_count


def count_inversions(arr):
    return mergesort(arr, 0, len(arr) - 1)


def main():
    """Program to count number of inversions in an array"""
    t = int(input())
    for i in range(t):
        n = int(input())
        arr = list(map(int, input().split()))
        inversions_count = count_inversions(arr)
        print(inversions_count)


if __name__ == "__main__":
    main()
