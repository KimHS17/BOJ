#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, end = -1, cnt = 0;

    cin >> n;
    vector<vector<int>> a(n, vector<int>(2));
    for(int i = 0; i < n; i++)
        cin >> a[i][1] >> a[i][0];

    sort(a.begin(), a.end());
    for(int i = 0; i < n; i++) {
        if(end <= a[i][1]) {
            end = a[i][0];
            cnt++;
        }
    }
    
    cout << cnt;
}