#include <iostream>
#include <vector>
using namespace std;

int w = 0, b = 0;

void rec(vector<vector<int>> &p, int y, int x, int n) {
    bool cut = false;
    int firstColor = p[y][x];

    for(int i = y; i < y + n; i++) {
        for(int j = x; j < x + n; j++) {
            if(p[i][j] != firstColor) {
                cut = true;
                break;
            }
        }
    }

    if(cut) {
        rec(p, y, x, n / 2);
        rec(p, y, x + n / 2, n / 2);
        rec(p, y + n / 2, x, n / 2);
        rec(p, y + n / 2, x + n / 2, n / 2);
    }
    else {
        if(firstColor)
            b++;
        else
            w++;
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;

    cin >> n;
    vector<vector<int>> p(n, vector<int>(n));

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> p[i][j];
        }
    }

    rec(p, 0, 0, n);
    cout << w << "\n" << b;
}