#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
	
    int n, k;
    cin >> n >> k;
    vector<vector<int>> wv(n,vector<int>(2,0));
    vector<vector<int>> dp(n + 1,vector<int>(k + 1,0));

    for(int i = 0; i < n; i++)
        cin >> wv[i][0] >> wv[i][1];
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= k; j++) {
            if(j >= wv[i - 1][0])
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - wv[i - 1][0]] + wv[i - 1][1]);
            else
                dp[i][j] = dp[i - 1][j];
        }
    }
    cout << dp[n][k];
}