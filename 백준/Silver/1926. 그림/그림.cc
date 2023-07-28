#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n, m, maxc = 0;

void bfs(int y, int x, vector<vector<int>> &b, vector<vector<int>> &ck) {
    int d[4][2] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int cnt = 1;

    maxc = maxc > cnt ? maxc : cnt;
    queue<pair<int, int>> coor;
    coor.push({y, x});

    while(!coor.empty()) {
        int y = coor.front().first;
        int x = coor.front().second;
        
        coor.pop();

        for(int i = 0; i < 4; i++) {
            int ny = y + d[i][0];
            int nx = x + d[i][1];

            if(ny >= n || ny < 0 || nx >= m || nx < 0 || ck[ny][nx] || b[ny][nx] == 0)
                continue;
            
            cnt++;
            coor.push({ny, nx});
            ck[ny][nx] = 1;
            maxc = maxc > cnt ? maxc : cnt;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int cnt = 0;

    cin >> n >> m;
    vector<vector<int>> b(n, vector<int>(m));
    vector<vector<int>> ck(n, vector<int>(m));
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++)
            cin >> b[i][j];
    }

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(!ck[i][j] && b[i][j] == 1) {
                ck[i][j] = 1;
                bfs(i, j, b, ck);
                cnt++;
            }
        }
    }

    cout << cnt << "\n" << maxc;
}