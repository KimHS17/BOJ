#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    vector<vector<int>> board(2, vector<int>(3));
    vector<vector<int>> max(2, vector<int>(3, 0));
    vector<vector<int>> min(2, vector<int>(3, 1000000));

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < 3; j++) {
            cin >> board[i % 2][j];
        }
        if(!i) {
            max[0] = board[0];
            min[0] = board[0];
        }
        else {
            int i2, i3;
            i2 = (i - 1) % 2;
            i3 = i % 2;

            for(int j = 0; j < 3; j++) {
                if(max[i2][j] + board[i % 2][j] > max[i3][j])
                    max[i3][j] = max[i2][j] + board[i % 2][j];
                if(j > 0 && max[i2][j] + board[i % 2][j - 1] > max[i3][j - 1])
                    max[i3][j - 1] = max[i2][j] + board[i % 2][j - 1];
                if(j < 2 && max[i2][j] + board[i % 2][j + 1] > max[i3][j + 1])
                    max[i3][j + 1] = max[i2][j] + board[i % 2][j + 1];

                if(min[i2][j] + board[i % 2][j] < min[i3][j])
                    min[i3][j] = min[i2][j] + board[i % 2][j];
                if(j > 0 && min[i2][j] + board[i % 2][j - 1] < min[i3][j - 1])
                    min[i3][j - 1] = min[i2][j] + board[i % 2][j - 1];
                if(j < 2 && min[i2][j] + board[i % 2][j + 1] < min[i3][j + 1])
                    min[i3][j + 1] = min[i2][j] + board[i % 2][j + 1];
            }
            for(int k = 0; k < 3; k++)
                min[i2][k] = 1000000;
        }
    }

    sort(max[(n + 1) % 2].begin(), max[(n + 1) % 2].end());
    sort(min[(n + 1) % 2].begin(), min[(n + 1) % 2].end());
    cout << max[(n + 1) % 2][2] << " " << min[(n + 1) % 2][0];
}