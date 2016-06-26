#include <iostream>
#include <cstring>
#include <vector>
#define NMAX 1000
#define CHEF 0
#define ASSISTANT 1
using namespace std;

int main()
{
	int t, n, m, done[NMAX], tmp, turn;
	unsigned i;
	cin >> t;
	while (t--) {
		cin >> n >> m;
		memset(done, 0, (n + 1) * sizeof(done[0]));
		for (i = 0; i < m; ++i) {
			cin >> tmp;
			done[tmp] = 1;
		}
		// for (i = 1; i <= n; ++i)
		// 	cout << done[i] << " ";
		// cout << endl;
		turn = 0;
		vector<int> v_chef;
		vector<int> v_assis;
		for (i = 1; i <= n; ++i) {
			if (!done[i]) {
				if (turn == CHEF) {
					v_chef.push_back(i);
				} else {
					v_assis.push_back(i);
				}
				turn = 1 - turn;
			}
		}
		for (i = 0; i < v_chef.size(); ++i) {
			cout << v_chef[i] << " ";
		}
		cout << endl;
		for (i = 0; i < v_assis.size(); ++i) {
			cout << v_assis[i] << " ";
		}
		cout << endl;
	}

	return 0;
}
