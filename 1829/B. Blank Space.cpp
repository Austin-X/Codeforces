#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;

void solve() {
    int n, mx = 0, cur = 0;
    cin >> n;
    for (int i = 0, x; i < n; i ++) {
        cin >> x;
        if (x == 0) {
            cur ++;
        } else {
            mx = max(mx, cur);
            cur = 0;
        }
    }
    mx = max(mx, cur);
    cout << mx << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
