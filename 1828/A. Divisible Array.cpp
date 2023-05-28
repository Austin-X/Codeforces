#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;
    rep(i, 1, n) cout << i * 2 << ' ';
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
