#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

	string tmp;
	vector <vector <int>> g(8,vector <int>(8,0));
	int k, sc = 0;

	for(int i = 0; i < 4; i++) {
		cin >> tmp;
		for(int j = 0; j < 8; j++)
			g[i][j] = tmp[j] - '0';
	}
	cin >> k;
	while(k--) {
		int n, d, d2, s[4] = {0};

		cin >> n >> d;
		s[n - 1] = 1;
		if(d == 1)
			d2 = -1;
		else
		 	d2 = 1;

		for(int i = n - 1; i < 3; i++) {
			if(g[i][2] != g[i + 1][6])
				s[i + 1] = 1;
			else
				break;
		}
		for(int i = n - 1; i > 0; i--) {
			if(g[i][6] != g[i - 1][2])
				s[i - 1] = 1;
			else
				break;
		}

		for(int i = n - 1; i < 4; i++) {
			if(s[i]) {
				if(d == 1) {
					g[i].insert(g[i].begin(), g[i][7]);
					g[i].erase(g[i].end() - 1);
					d = -1;
				}
				else if(d == -1) {
					g[i].insert(g[i].end(), g[i][0]);
					g[i].erase(g[i].begin());
					d = 1;
				}
			}
		}
		for(int i = n - 2; i > -1; i--) {
			if(s[i]) {
				if(d2 == 1) {
					g[i].insert(g[i].begin(), g[i][7]);
					g[i].erase(g[i].end() - 1);
					d2 = -1;
				}
				else if(d2 == -1) {
					g[i].insert(g[i].end(), g[i][0]);
					g[i].erase(g[i].begin());
					d2 = 1;
				}
			}
		}
	}

	if(g[0][0])
		sc += 1;
	if(g[1][0])
		sc += 2;
	if(g[2][0])
		sc += 4;
	if(g[3][0])
		sc += 8;

	cout << sc;
}