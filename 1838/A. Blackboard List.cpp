#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;
    int ans = 0;
    for (int i = 0, x; i < n; i ++) {
        cin >> x;
        if (x < 0) ans = x;
        else if (ans >= 0) ans = max(ans, x);
    }
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
