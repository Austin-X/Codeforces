#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;
const int N = 1e5 + 5;

ll n, m, a[N], sum[N], sz[N], parent[N];
bool vis[N];
vector<ll> adj[N];
set<tuple<ll, ll>> sons[N];

void dfs(int u) {
    vis[u] = true;
    sum[u] = a[u];
    sz[u] = 1;

    for (int v: adj[u]) {
        if (!vis[v]) {
            dfs(v);
            parent[v] = u;
            sum[u] += sum[v];
            sz[u] += sz[v];
            sons[u].insert(make_tuple(-sz[v], v));
        }
    }
}

void solve() {
    cin >> n >> m;
    rep(i, 1, n) {
        cin >> a[i];
        vis[i] = false;
    }
    for (int i = 0, u, v; i < n - 1; i ++) {
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    
    dfs(1);

    while (m-- > 0) {
        int t, x;
        cin >> t >> x;
        if (t == 1) cout << sum[x] << '\n';
        else {
            if (!sons[x].empty()) {
                tuple<ll, ll> tp = *sons[x].begin();
                ll idx = get<1>(tp);
                sons[parent[x]].erase(make_tuple(-sz[x], x));
                sons[x].erase(make_tuple(get<0>(tp), idx));
                sum[x] -= sum[idx];
                sum[idx] += sum[x];
                sz[x] -= sz[idx];
                sz[idx] += sz[x];
                sons[idx].insert(make_tuple(-sz[x], x));
                sons[parent[x]].insert(make_tuple(-sz[idx], idx));
                parent[idx] = parent[x];
                parent[x] = idx;
            }
        }
    }
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    solve();
    return 0;
}
