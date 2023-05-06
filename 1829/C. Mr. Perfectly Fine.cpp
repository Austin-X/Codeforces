#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;

void solve() {
    int n, res = 1e6;
    cin >> n;
    int minFirst = 1e6, minSec = 1e6;
    for (int i = 0, m; i < n; i ++) {
        string s;
        cin >> m >> s;
        if (s[0] == '1') minFirst = min(minFirst, m);
        if (s[1] == '1') minSec = min(minSec, m);
        if (s == "11") res = min(res, m);
    }
    res = min(res, minFirst + minSec);
    cout << (res == 1e6 ? -1 : res) << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
