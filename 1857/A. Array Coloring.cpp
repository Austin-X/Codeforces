#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n, odd = 0;
    cin >> n;
    for (int i = 0, a; i < n; i ++) {
        cin >> a;
        odd += a & 1;
    }
    cout << (odd & 1 ? "NO" : "YES") << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
