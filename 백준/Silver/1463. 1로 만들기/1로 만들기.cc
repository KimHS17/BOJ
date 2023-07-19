#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    
    cin >> n;
    vector<int> dp(n + 1, 0);
    dp[1] = 0;
    dp[2] = 1;
    dp[3] = 1;
    for (int i = 4; i < n + 1; i++) {
        dp[i] = dp[i - 1] + 1;
        if(i % 3 == 0)
            dp[i] = min((dp[i / 3] + 1), dp[i]);
        if(i % 2 == 0)
            dp[i] = min((dp[i / 2] + 1), dp[i]);
    }

    cout << dp[n] << "\n";
}
