#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string st;
    string bomb;
    vector<char> s;

    cin >> st >> bomb;
    for(int i = 0; i < st.size(); i++) {
        bool flag = true;

        s.push_back(st[i]);
        if(s.size() >= bomb.size()) {
            if(s[s.size() - 1] == bomb[bomb.size() - 1]) {
                for(int j = 0; j < bomb.size(); j++) {
                    if(s[j + s.size() - bomb.size()] != bomb[j]) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    for(int k = 0; k < bomb.size(); k++)
                        s.pop_back();
                }
            }
        }
    }

    if(s.size() == 0)
        cout << "FRULA";
    else {
        for(int i = 0; i < s.size(); i++)
            cout << s[i];
    }
}