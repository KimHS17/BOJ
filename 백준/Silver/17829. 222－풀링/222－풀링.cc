#include <iostream>
#include <vector>
using namespace std;

void cnn(vector <vector<int>> &arr, int n) {
    int idy = 0, idx = 0;

    if(n != 1) {
        for(int i = 0; i < n; i += 2) {
            for(int j = 0; j < n; j += 2) {
                int max = -20000, sec = -20000;

                for(int k = i; k < i + 2; k++) {
                    for(int l = j; l < j + 2; l++) {
                        if(arr[k][l] > max) {
                            sec = max;
                            max = arr[k][l];
                        }
                        else if(arr[k][l] > sec)
                            sec = arr[k][l];
                    }
                }
                arr[idy][idx++] = sec;
                if(idx == n / 2) {
                    idx = 0;
                    idy++;
                }
            }
        }
        cnn(arr, n / 2);
    }
    else
        return;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    vector <vector<int>> arr(n, vector<int>(n));
    
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }

    cnn(arr, n);
    cout << arr[0][0];
}