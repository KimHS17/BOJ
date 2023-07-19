#include <iostream>
#include <queue>
#include <tuple>
#include <vector>
using namespace std;

void bfs(vector<vector<vector<int>>> &box, int n, int m, int h, queue<tuple<int, int, int>> &q2, int size, int &cnt, int &cnt2) {
    cnt++;
    for (int c = 0; c < size; c++) {
        tuple<int, int, int> tmp;
        tmp = q2.front();
        q2.pop();
        if (get<1>(tmp) != 0 && box[get<0>(tmp)][get<1>(tmp) - 1][get<2>(tmp)] == 0) {
            q2.push({get<0>(tmp), get<1>(tmp) - 1, get<2>(tmp)});
            box[get<0>(tmp)][get<1>(tmp) - 1][get<2>(tmp)] = 1;
            cnt2++;
        }
        if (get<2>(tmp) != m - 1 && box[get<0>(tmp)][get<1>(tmp)][get<2>(tmp) + 1] == 0) {
            q2.push({get<0>(tmp), get<1>(tmp), get<2>(tmp) + 1});
            box[get<0>(tmp)][get<1>(tmp)][get<2>(tmp) + 1] = 1;
            cnt2++;
        }
        if (get<1>(tmp) != n - 1 && box[get<0>(tmp)][get<1>(tmp) + 1][get<2>(tmp)] == 0) {
            q2.push({get<0>(tmp), get<1>(tmp) + 1, get<2>(tmp)});
            box[get<0>(tmp)][get<1>(tmp) + 1][get<2>(tmp)] = 1;
            cnt2++;
        }
        if (get<2>(tmp) != 0 && box[get<0>(tmp)][get<1>(tmp)][get<2>(tmp) - 1] == 0) {
            q2.push({get<0>(tmp), get<1>(tmp), get<2>(tmp) - 1});
            box[get<0>(tmp)][get<1>(tmp)][get<2>(tmp) - 1] = 1;
            cnt2++;
        }
        if(get<0>(tmp) != 0 && box[get<0>(tmp) - 1][get<1>(tmp)][get<2>(tmp)] == 0) {
            q2.push({get<0>(tmp) - 1, get<1>(tmp), get<2>(tmp)});
            box[get<0>(tmp) - 1][get<1>(tmp)][get<2>(tmp)] = 1;
            cnt2++;
        }
        if(get<0>(tmp) != h - 1 && box[get<0>(tmp) + 1][get<1>(tmp)][get<2>(tmp)] == 0) {
            q2.push({get<0>(tmp) + 1, get<1>(tmp), get<2>(tmp)});
            box[get<0>(tmp) + 1][get<1>(tmp)][get<2>(tmp)] = 1;
            cnt2++;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int m, n, h, cnt = 0, cnt2 = 0, dcnt = 0;

    cin >> m >> n >> h;
    vector<vector<vector<int>>> box(h, vector<vector<int>>(n, vector<int>(m, 0)));
    queue<tuple<int, int, int>> q1;

    for (int i = 0; i < h; i++) {
        for (int j = 0; j < n; j++) {
            for(int k = 0; k < m; k++) {
                cin >> box[i][j][k];
                if (box[i][j][k] == 1) {
                    q1.push({i, j, k});
                    cnt2++;
                }
                else if (box[i][j][k] == -1)
                    dcnt++;
            }
        }
    }
    while (!q1.empty())
		bfs(box, n, m, h, q1, q1.size(), cnt, cnt2);

    if (cnt2 == (m * n * h - dcnt))
        cout << --cnt;
    else
        cout << "-1";
}