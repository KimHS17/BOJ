#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;

    cin >> n;
    vector<int> h(n);

    for(int i = 0; i < n; i++)
        cin >> h[i];
    
    sort(h.begin(), h.end());

    cout << h[(n - 1) / 2];
}