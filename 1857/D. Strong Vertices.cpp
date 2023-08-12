#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;
    int a[n + 1], b[n + 1];
    rep(i, 1, n) cin >> a[i];
    rep(i, 1, n) cin >> b[i];
    int mx = INT_MIN;
    rep(i, 1, n) mx = max(mx, a[i] - b[i]);
    vector<int> ans;
    rep(i, 1, n) if (a[i] - b[i] == mx) ans.push_back(i);
    cout << ans.size() << '\n';
    for (int x: ans) cout << x << ' ';
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
