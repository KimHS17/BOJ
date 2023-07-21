#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int n, s, a = 200000001;

    cin >> n;
    int m[n];
    for(int i = 0; i < n; i++)
        cin >> m[i];
    int l = 0, r = n - 1;
    while(l < r) {
        s = m[l] + m[r];
        if(abs(s) < abs(a))
            a = s;
        if(s == 0)
            break;
        else if(s < 0)
            l++;
        else
            r--;
    }
    cout << a << "\n";
}