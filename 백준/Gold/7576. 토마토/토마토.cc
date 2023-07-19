#include <iostream>
#include <queue>
#include <utility>
#include <vector>
using namespace std;

void bfs(vector<vector<int>> &box, int n, int m, queue<pair<int, int>> &q2, int size, int &cnt, int &cnt2) {
    cnt++;
    for (int c = 0; c < size; c++) {
        pair<int, int> tmp;
        tmp = q2.front();
        q2.pop();
        if (tmp.first != 0 && box[tmp.first - 1][tmp.second] == 0) {
            q2.push({tmp.first - 1, tmp.second});
            box[tmp.first - 1][tmp.second] = 1;
            cnt2++;
        }
        if (tmp.second != m - 1 && box[tmp.first][tmp.second + 1] == 0) {
            q2.push({tmp.first, tmp.second + 1});
            box[tmp.first][tmp.second + 1] = 1;
            cnt2++;
        }
        if (tmp.first != n - 1 && box[tmp.first + 1][tmp.second] == 0) {
            q2.push({tmp.first + 1, tmp.second});
            box[tmp.first + 1][tmp.second] = 1;
            cnt2++;
        }
        if (tmp.second != 0 && box[tmp.first][tmp.second - 1] == 0) {
            q2.push({tmp.first, tmp.second - 1});
            box[tmp.first][tmp.second - 1] = 1;
            cnt2++;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int m, n, cnt = 0, cnt2 = 0, dcnt = 0;

    cin >> m >> n;
    vector<vector<int>> box(n, vector<int>(m, 0));
    // vector<pair<int, int>> pos;
    queue<pair<int, int>> q1;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> box[i][j];
            if (box[i][j] == 1) {
                q1.push({i, j});
                cnt2++;
            }
            else if (box[i][j] == -1)
                dcnt++;
        }
    }
    while (!q1.empty())
		bfs(box, n, m, q1, q1.size(), cnt, cnt2);

    if (cnt2 == (m * n - dcnt))
        cout << --cnt;
    else
        cout << "-1";
}