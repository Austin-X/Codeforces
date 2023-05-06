#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;

void solve() {
    int n, m;
    cin >> n >> m;
    int cnt[n + 1], freq[n + 1];
    fill(cnt, cnt + n + 1, 0);
    fill(freq, freq + n + 1, 0);
    for (int i = 0, u, v; i < m; i ++) {
        cin >> u >> v;
        cnt[u] ++;
        cnt[v] ++;
    }

    rep(i, 1, n) freq[cnt[i]] ++;
    vector<pair<int, int>> vec;
    rep(i, 1, n) if (freq[i]) vec.push_back({freq[i], i});
    sort(vec.begin(), vec.end());

    if (vec.size() == 3) cout << vec[0].second << ' ' << (vec[1].second - 1) << '\n';
    else cout << vec[0].second << ' ' << (vec[0].second - 1) << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
