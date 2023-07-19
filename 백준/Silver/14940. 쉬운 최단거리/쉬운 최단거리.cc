#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    int goal[2];
    int d[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    queue<pair<int, int>> cd;

    cin >> n >> m;
    vector<vector<int>> g(n, vector<int>(m));
    vector<vector<int>> ck(n, vector<int>(m));

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> g[i][j];
            if(g[i][j] == 2) {
                goal[0] = i;
                goal[1] = j;
            }
        }
    }

    cd.push({goal[0], goal[1]});
    while(!cd.empty()) {
        int y = cd.front().first;
        int x = cd.front().second;
        cd.pop();

        for(int i = 0; i < 4; i++) {
            int ny = y + d[i][0];
            int nx = x + d[i][1];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m || ck[ny][nx] || g[ny][nx] == 0)
                continue;
            
            cd.push({ny, nx});
            ck[ny][nx] = ck[y][x] + 1;
        }
    }

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(i == goal[0] && j == goal[1])
                cout << "0 ";
            
            else if(!ck[i][j] && !g[i][j])
                cout << "0 ";

            else if(!ck[i][j])
                cout << "-1 ";
            
            else
                cout << ck[i][j] << " ";
        }
        cout << "\n";
    }
}