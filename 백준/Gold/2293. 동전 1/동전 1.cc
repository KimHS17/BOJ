#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

	vector<int> c;
	int n, k, t;

	cin >> n >> k;
	vector<int> dp(k + 1);
	for(int i = 0; i < n; i++) {
		cin >> t;
		c.push_back(t);
	}
	dp[0] = 1;
	for(int i = 0; i < n; i++) {
		for(int j = c[i]; j <= k; j++) {
			dp[j] += dp[j - c[i]];
		}

	}
	cout << dp[k];
}