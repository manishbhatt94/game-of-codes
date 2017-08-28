def mergesort(arr, l, r):
    if l < r:
        mid = (l + r) // 2
        mergesort(arr, l, mid)
        mergesort(arr, mid + 1, r)
        merge(arr, l, r, mid)


def merge(arr, l, r, mid):
    n1 = mid - l + 1
    n2 = r - mid
    L = [arr[i] for i in range(l, mid + 1)]
    R = [arr[i] for i in range(mid + 1, r + 1)]
    i = j = 0
    k = l
    while i < n1 and j < n2:
        if L[i] <= R[j]:
            arr[k] = L[i]
            i += 1
        else:
            arr[k] = R[j]
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


def main():
    """Code to demo simple implementation of merge sort.
    Declares an array, calls mergesort() on it and prints it thereafter.
    """
    arr = [38, 27, 43, 3, 9, 12, 10]
    print(arr)
    mergesort(arr, 0, len(arr) - 1)
    print(arr)


if __name__ == "__main__":
    main()
