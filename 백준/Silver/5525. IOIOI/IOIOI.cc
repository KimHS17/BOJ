#include <iostream>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, m, cnt = 0;
    string s, c, t;

    cin >> n >> m >> s;
    for(int i = 0; i < n + n + 1; i++) {
        if(i % 2 == 0)
            c += 'I';
        else
            c += 'O';
    }
    for(int i = 0; i < m; i++) {
        t = s.substr(i, n + n + 1);
        if(t == c)
            cnt++;
    }
    cout << cnt;
}