#include <iostream>
#include <vector>
using namespace std;

int n, cnt = 0;

void chess(vector<int> &d, vector<int> &ru, vector<int> &rd, int y) {
    if(y == n) {
        cnt++;
        return;
    }
    for(int x = 0; x < n; x++) {
        if(!d[x] && !ru[x + y] && !rd[x - y + n - 1]) {
            d[x] = 1;
            ru[x + y] = 1;
            rd[x - y + n - 1] = 1;
            chess(d, ru, rd, y + 1);
            d[x] = 0;
            ru[x + y] = 0;
            rd[x - y + n - 1] = 0;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
	
    cin >> n;
    vector<int> d(n, 0);
    vector<int> ru(n * 2 - 1, 0);
    vector<int> rd(n * 2 - 1, 0);

    chess(d, ru, rd, 0);
    cout << cnt;
}