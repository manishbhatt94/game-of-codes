#include <iostream>
using namespace std;

int main()
{
	int n, arr[1000], x, hash[100000] = {0}, i, pair_found;

	cin >> n;
	for (i = 0; i < n; ++i) {
		cin >> arr[i];
		hash[arr[i]] = 1;
	}
	cin >> x;

	pair_found = 0;
	for (i = 0; i < n; ++i) {
		if (hash[x-arr[i]]) {
			pair_found = 1;
			cout << "Found! (" << arr[i] << "," << x - arr[i] << ")" << endl;
			break;
		}
	}
	if (!pair_found) {
		cout << "Not Found!" << endl;
	}

	return 0;
}
