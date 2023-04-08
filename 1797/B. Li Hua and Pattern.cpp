#include <bits/stdc++.h>
#define rep(x,y,z) for(int x=(y);x<=(z);x++)
using namespace std;
typedef long long ll;

void solve() {
    int n, k;
    cin >> n >> k;
    int a[n + 1][n + 1];
    rep(i, 1, n) rep (j, 1, n) cin >> a[i][j];
    int diff = 0;
    rep (i, 1, n) rep(j, 1, n) if (a[i][j] != a[n + 1 - i][n + 1 - j]) diff++;
    diff >>= 1;
    cout << ((k >= diff && (n & 1 || !((k - diff) & 1))) ? "YES" : "NO") << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    int t;
    cin >> t;
    while (t-- > 0) solve();

    return 0;
}
