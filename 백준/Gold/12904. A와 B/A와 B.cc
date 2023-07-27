#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);

    string s, t;
    int res = 0;
	
    cin >> s >> t;

	while (1) {
		if (s.size() == t.size()) {
			if (s == t)
				res = 1;
			break;
		}
		
		if (t[t.size() - 1] == 'A')
			t.pop_back();
		else {
			t.pop_back();
			reverse(t.begin(), t.end());
		}
	}

	cout << res << endl;
}