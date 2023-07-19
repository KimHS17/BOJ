#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, m, q, r, o, t, k, s;

    cin >> n >> m >> q;
    vector<vector<int>> a(n, vector <int>(m));
    vector<int> row(n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++)
            cin >> a[i][j];
        row[i] = i;
    }
    for(int i = 0; i < q; i ++) {
        cin >> r >> o >> t;
        if(r) {
            s = row[o];
            row[o] = row[t];
            row[t] = s;
        }
        else {
            cin >> k;
            a[row[o]][t] = k;
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++)
            cout << a[row[i]][j] << " ";
        cout << "\n";
    }
}