#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
using namespace std;

int l, r, c;

void bfs(vector<vector<vector<int>>> b, queue<tuple<int, int, int>> q) {
    int d[6][3] = { {0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {-1, 0, 0}, {1, 0, 0} };

    while(!q.empty()) {
        int z = get<0>(q.front());
        int y = get<1>(q.front());
        int x = get<2>(q.front());

        q.pop();

        for(int i = 0; i < 6; i++) {
            int nz = z + d[i][0];
            int ny = y + d[i][1];
            int nx = x + d[i][2];
            
            if(nz < 0 || ny < 0 || nx < 0 || nz >= l || ny >= r || nx >= c || b[nz][ny][nx] == -1 || b[nz][ny][nx] > 0)
                continue;
            
            if(b[nz][ny][nx] == -2) {
                cout << "Escaped in " << b[z][y][x] + 1 << " minute(s)." << "\n";
                return;
            }

            b[nz][ny][nx] = b[z][y][x] + 1;
            q.push({nz, ny, nx});
        }
    }
    cout << "Trapped!" << "\n";
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    while(1) {
        cin >> l >> r >> c;

        if(l == 0 && r == 0 && c == 0)
            break;

        vector<vector<vector<int>>> b(l, vector<vector<int>>(r, vector<int>(c, 0)));
        queue<tuple<int, int, int>> q;

        for(int i = 0; i < l; i++) {
            char tmp;
            for(int j = 0; j < r; j++) {
                for(int k = 0; k < c; k++) {
                    cin >> tmp;
                    if(tmp == 'S')
                        q.push({i, j, k});
                    else if(tmp == '#')
                        b[i][j][k] = -1;
                    else if(tmp == 'E')
                        b[i][j][k] = -2;
                }
            }
        }

        bfs(b, q);
    }
}