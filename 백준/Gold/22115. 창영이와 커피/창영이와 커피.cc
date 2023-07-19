#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
	
    int n, k;
    cin >> n >> k;
    vector<int> num(n + 1);
    vector<vector<int>> dp(n + 1, vector<int>(k + 1, 0));
    for(int i = 1; i <= n; i++) {
        cin >> num[i];
    }
    for(int i = 1; i <= k; i++)
        dp[0][i] = 101;
    
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= k; j++) {
            if(num[i] <= j)
                dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - num[i]] + 1);
            else
                dp[i][j] = dp[i - 1][j];
        }
    }

    if(dp[n][k] == 101)
        cout << "-1";
    else
        cout << dp[n][k];
}