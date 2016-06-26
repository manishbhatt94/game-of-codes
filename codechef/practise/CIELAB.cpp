#include <iostream>
using namespace std;

int main()
{
	int a, b, diff, new_diff;
	cin >> a >> b;

	diff = a - b;
	new_diff = (diff % 10 == 9) ? diff - 1 : diff + 1;
	cout << new_diff;

	return 0;
}
