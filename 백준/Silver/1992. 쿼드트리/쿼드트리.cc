#include <iostream>
#include <string>
using namespace std;

string img[64], res;

void rec(int y, int x, int n) {
    char num = img[y][x];
    bool flag = false;

    for(int i = y; i < y + n; i++) {
        for(int j = x; j < x + n; j++) {
            if(num != img[i][j]) {
                flag = true;
                break;
            }
        }
        if(flag)
            break;
    }

    if(!flag)
        res.push_back(num);
    
    else {
        res.push_back('(');
        rec(y, x, n / 2);
        rec(y, x + n / 2, n / 2);
        rec(y + n / 2, x, n / 2);
        rec(y + n / 2, x + n / 2, n / 2);
        res.push_back(')');
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;

    cin >> n;
    for(int i = 0; i < n; i++)
        cin >> img[i];

    rec(0, 0, n);
    cout << res;
}