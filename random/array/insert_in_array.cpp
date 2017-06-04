#include <iostream>
using namespace std;

void insert(int arr[], int size, int index, int el) {
  int a = arr[index];
  int b = arr[index + 1];
  for (int i = index + 1; i < size; ++i) {
    arr[i] = a;
    a = b;
    b = arr[i + 1];
  }
  arr[size] = a;
  arr[index] = el;
}

void printArray(int arr[], int size) {
  for (int i = 0; i < size; ++i) {
    cout << arr[i] << " ";
  }
  cout << endl;
}

int main() {

  int A[1000] = { 0 };
  int initial_length = 5;
  for (int i = 0; i < initial_length; ++i) {
    A[i] = i + 1;
  }
  printArray(A, initial_length);
  insert(A, initial_length, 2, 19);
  printArray(A, initial_length + 1);

  return 0;
}
