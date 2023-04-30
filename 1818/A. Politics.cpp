#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;

void solve() {
    int n, k, ans = 1;
    cin >> n >> k;
    string match, x;
    cin >> match;
    for (int i = 2; i <= n; i ++) {
        cin >> x;
        ans += match == x;
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
