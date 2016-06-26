#include <iostream>
#include <algorithm>
#include <climits>
#include <cmath>
#define MAX 5000
using namespace std;

int main()
{
	int t, n, s[MAX], i, min_diff, diff;
	cin >> t;
	while (t--) {
		cin >> n;
		for (i = 0; i < n; ++i) {
			cin >> s[i];
		}
		sort(s, s + n);
		// for (i = 0; i < n; ++i)
		// 	cout << s[i] << " ";
		// cout << endl;
		min_diff = INT_MAX;
		for (i = 0; i < n-1; ++i) {
			diff = abs(s[i + 1] - s[i]);
			if (diff < min_diff) {
				min_diff = diff;
			}
		}
		cout << min_diff << endl;
	}

	return 0;
}
