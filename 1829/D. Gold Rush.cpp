#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;
const int MN = 1e7 + 1;

bool vis[MN];

void rec(int x) {
    if (vis[x]) return;
    vis[x] = true;
    if (x % 3 == 0) {
        int y = x / 3;
        rec(y);
        rec(y * 2);
    }
}

void solve() {
    int n, m;
    cin >> n >> m;
    fill(vis, vis + n + 1, false);
    rec(n);
    cout << (vis[m] ? "YES\n" : "NO\n");
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
