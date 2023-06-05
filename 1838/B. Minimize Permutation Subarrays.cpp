#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;
    int idx[n + 1];
    for (int i = 1, x; i <= n; i ++) {
        cin >> x;
        idx[x] = i;
    }
    cout << idx[n] << ' ';
    int mn = min(idx[1], idx[2]), mx = max(idx[1], idx[2]);
    if (idx[n] > mn && idx[n] < mx) cout << idx[n] << ' ';
    else cout << (idx[n] < mn ? mn : mx);
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
