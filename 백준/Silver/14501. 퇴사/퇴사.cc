#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    
    cin >> n;
    vector<vector<int>> tp(n, vector<int>(2));
    vector<int> dp(n);

    for(int i = 0; i < n; i++) {
        cin >> tp[i][0] >> tp[i][1];
    }

    for(int i = 0; i < n; i++) {
        if(tp[i][0] + i <= n)
            dp[tp[i][0] + i - 1] = dp[tp[i][0] + i - 1] > tp[i][1] + dp[i - 1] ? dp[tp[i][0] + i - 1] : tp[i][1] + dp[i - 1];
        dp[i] = dp[i] > dp[i - 1] ? dp[i] : dp[i - 1];
    }

    int max = *max_element(dp.begin(), dp.end());
    cout << max << "\n";
}