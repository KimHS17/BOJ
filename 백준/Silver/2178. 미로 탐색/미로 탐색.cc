#include <iostream>
#include <vector>
#include <string>
#include <queue>
using namespace std;

void bfs(vector<vector<int>> &arr, vector<vector<int>> &ck, int n, int m) {
    int dir[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    queue<pair<int, int>> q;

    q.push({0, 0});
    while(!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();

        for(int i = 0; i < 4; i++) {
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];

            if(ny >= n || ny < 0 || nx >= m || nx < 0 || !arr[ny][nx] || ck[ny][nx])
                continue;
            
            q.push({ny, nx});
            ck[ny][nx] = ck[y][x] + 1;

            if(ny == n && nx == m)
                return;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string t;
    int n, m;
    cin >> n >> m;
    vector<vector<int>> arr(n, vector<int>(m));
    vector<vector<int>> ck(n, vector<int>(m, 0));

    for(int i = 0; i < n; i++) {
        cin >> t;
        for(int j = 0; j < m; j++)
            arr[i][j] = t[j] - '0';
    }

    bfs(arr, ck, n, m);
    cout << ck[n - 1][m - 1] + 1;
}