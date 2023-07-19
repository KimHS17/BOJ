#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
	
    int t;
    
    cin >> t;
    while(t--) {
        int n, m, coin[21] = {0}, dp[10001] = {0};
        dp[0] = 1;

        cin >> n;
        for(int i = 0; i < n; i++)
            cin >> coin[i];
        cin >> m;

        for(int i = 0; i < n; i ++) {
            for(int j = coin[i]; j <= m; j++)
                dp[j] += dp[j - coin[i]];
        }
        cout << dp[m] << "\n";
    }
}