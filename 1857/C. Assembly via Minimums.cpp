#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;
    int m = n*(n-1)/2, b[m];
    for (int i = 0; i < m; i ++) cin >> b[i];
    sort(b, b + m);
    for (int i = 0; i < m; i += --n) cout << b[i] << ' ';
    cout << (int)1e9 << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
