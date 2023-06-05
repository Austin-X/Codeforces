#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; i ++) {
        for (int j = 1; j <= m; j ++) cout << (i % 2 == 0 ? (n / 2 + i / 2) * m + j : i / 2 * m + j) << ' ';
        cout << '\n';
    }
    cout << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
