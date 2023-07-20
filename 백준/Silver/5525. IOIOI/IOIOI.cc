#include <iostream>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, m, cnt = 0, cnt2 = 0;
    string s;
    char t = 'O';

    cin >> n >> m >> s;
    for(int i = 0; i < m; i++) {
        if(s[i] != t) {
            t = s[i];
            cnt++;
            if(cnt >= n + n + 1 && (cnt - (n + n + 1)) % 2 == 0)
                cnt2++;
        }
        else {
            t = 'O';
            cnt = 0;
            if(s[i] != t) {
                t = s[i];
                cnt++;
            }
        }
    }
    cout << cnt2;
}
