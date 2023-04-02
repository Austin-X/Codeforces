#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

void solve() {
    int n;
    string s;
    cin >> n >> s;

    char mn = *min_element(s.begin(), s.end());
    for (int i = n - 1; i >= 0; i --) {
        if (s[i] == mn) {
            s.erase(s.begin() + i);
            s.insert(s.begin(), mn);
            break;
        }
    }
    cout << s << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    int t;
    cin >> t;
    while (t-- > 0) solve();

    return 0;
}
