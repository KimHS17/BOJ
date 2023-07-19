#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int bfs(int n, int size, vector<vector<int>> &s, vector<int> &bshark) {
    int d[4][2] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    vector<vector<int>> ck(n, vector<int>(n));
    vector<pair<int, int>> fish;
    int fx = 500, fy = 500;
    int cnt = 1000;
    bool find = false;
    queue<pair<int, int>> coor;
    
    coor.push({bshark[0], bshark[1]});

    while(!coor.empty()) {
        int y = coor.front().first;
        int x = coor.front().second;
        
        coor.pop();

        for(int i = 0; i < 4; i++) {
            int ny = y + d[i][0];
            int nx = x + d[i][1];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n || ck[ny][nx] || s[ny][nx] > size || s[ny][nx] == 9)
                continue;
            coor.push({ny, nx});
            ck[ny][nx] = ck[y][x] + 1;
            if(ck[ny][nx] > cnt)
                break;
            if(s[ny][nx] != 0 && s[ny][nx] < size) {
                cnt = ck[ny][nx];
                if(fy == ny) {
                    if(fx > nx)
                        fx = nx;
                }
                else if(fy > ny) {
                    fy = ny;
                    fx = nx;
                }
                find = true;
            }
        }
    }
    if(find) {
        s[bshark[0]][bshark[1]] = 0;
        s[fy][fx] = 9;
        bshark[0] = fy;
        bshark[1] = fx;
        return ck[fy][fx];
    }
    return 0;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, size = 2, dis[2] = {0, 500}, sec = 0, cnt = 0;

    cin >> n;
    vector<vector<int>> s(n, vector<int>(n));
    vector<int> bshark(2);

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> s[i][j];
            if(s[i][j] == 9) {
                bshark[0] = i;
                bshark[1] = j;
            }
        }
    }

    while(1) {
        int d = bfs(n, size, s, bshark);
        if(d == 0)
            break;
        else {
            sec += d;
            cnt++;
            if(cnt == size) {
                size++;
                cnt = 0;
            }
        }
    }

    cout << sec << "\n";
}