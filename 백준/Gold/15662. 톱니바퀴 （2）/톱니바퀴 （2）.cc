#include <iostream>
#include <vector>
#include <string>
using namespace std;

void ch(vector<vector<int>> &G, int &D, int I) {
	if(D == 1) {
		G[I].insert(G[I].begin(), G[I][7]);
		G[I].erase(G[I].end() - 1);
		D = -1;
	}
	else {
		G[I].insert(G[I].end(), G[I][0]);
		G[I].erase(G[I].begin());
		D = 1;
	}
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

	string tmp;
	int t, k, cnt = 0;
	cin >> t;
	vector <vector <int>> g(t,vector <int>(8,0));

	for(int i = 0; i < t; i++) {
		cin >> tmp;
		for(int j = 0; j < 8; j++)
			g[i][j] = tmp[j] - '0';
	}
	cin >> k;
	while(k--) {
		int n, d, d2;
		vector<int> s(t);

		cin >> n >> d;
		s[n - 1] = 1;
		if(d == 1)
			d2 = -1;
		else
		 	d2 = 1;
		
		for(int i = n - 1; i < t - 1; i++) {
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

		for(int i = n - 1; i < t; i++) {
			if(s[i])
				ch(g, d, i);
			else
				break;
		}
		for(int i = n - 2; i > -1; i--) {
			if(s[i])
				ch(g, d2, i);
			else
				break;
		}
	}

	for(int i = 0; i < t; i++) {
		if(g[i][0])
			cnt++;
	}
	cout << cnt;
}