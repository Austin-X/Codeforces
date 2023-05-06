#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;

const int MN = 1002;
int n, m;
int a[MN][MN];
int dir[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
bool vis[MN][MN];

int dfs(int r, int c, int cnt) {
    if (r < 1 || r > n || c < 1 || c > m || vis[r][c] || !a[r][c]) return 0;
    cnt += a[r][c];
    vis[r][c] = true;
    rep(i, 0, 3) {
        int nr = r + dir[i][0], nc = c + dir[i][1];
        cnt += dfs(nr, nc, 0);
    }
    return cnt;
}

void solve() {
    cin >> n >> m;
    int res = 0;
    rep(i, 1, n) rep(j, 1, m) { a[i][j] = 0; vis[i][j] = false; }
    rep(i, 1, n) rep(j, 1, m) cin >> a[i][j];
    rep(i, 1, n) rep(j, 1, m) if (!vis[i][j]) res = max(res, dfs(i, j, 0));
    cout << res << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
