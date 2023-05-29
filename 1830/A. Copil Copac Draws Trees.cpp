#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;

    vector<int> adj[n + 1];
    map<pii, int> id;
    for (int i = 1, u, v; i <= n - 1; i ++) {
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
        id[{u, v}] = i;
        id[{v, u}] = i;
    }

    bool vis[n + 1];
    int dp[n + 1];
    fill(vis, vis + n + 1, false);
    dp[1] = 0;

    queue<pii> q;
    q.push({1, n});

    while (!q.empty()) {
        int u = q.front().first, uId = q.front().second;
        q.pop();
        vis[u] = true;
        for (int v: adj[u]) {
            if (!vis[v]) {
                if (id[{u, v}] < uId) dp[v] = dp[u] + 1;
                else dp[v] = dp[u];
                q.push({v, id[{u, v}]});
            }
        }
    }

    int ans = 0;
    rep(i, 1, n) ans = max(ans, dp[i]);
    cout << ans << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
