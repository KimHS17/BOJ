#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n, m;
queue<pair<int,int>> q;
vector<vector<int>> d = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

void bfs(vector<vector<int>> &check, vector<vector<int>> &ice) {
    while(!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        int scnt = 0;

        q.pop();

        for(int i = 0; i < 4; i++) {
            int ny = y + d[i][0];
            int nx = x + d[i][1];

            if(ny >= n || ny < 0 || nx >= m || nx < 0 || check[ny][nx])
                continue;
            
            if(!ice[ny][nx])
                scnt++;
            else {
                q.push({ny, nx});
                check[ny][nx] = 1;
            }
        }
        ice[y][x] -= ice[y][x] > scnt ? scnt : ice[y][x];
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int hcnt = 0;

    cin >> n >> m;
    vector<vector<int>> ice(n, vector<int>(m));
    
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> ice[i][j];
        }
    }

    while(1) {
        vector<vector<int>> check(n, vector<int>(m));
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(ice[i][j] && !check[i][j]) {
                    q.push({i, j});
                    check[i][j] = 1;
                    bfs(check, ice);
                    cnt++;
                    if(cnt >= 2) {
                        cout << hcnt;
                        return 0;
                    }
                }
            }
        }
        if(cnt == 0) {
            cout << "0";
            break;
        }
        hcnt++;
    }
}