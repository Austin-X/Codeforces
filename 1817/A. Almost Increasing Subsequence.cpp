#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;
const int N = 2e5 + 5;

int n;
int a[N], psa[N];

void solve() {
    int q;
    cin >> n >> q;
    rep(i, 1, n) cin >> a[i];
    rep(i, 1, n - 2) psa[i] = psa[i - 1] + (a[i] >= a[i + 1] && a[i + 1] >= a[i + 2]);

    while (q-- > 0) {
        int l, r;
        cin >> l >> r;
        if (l == r) cout << "1\n";
        else cout << (r - l + 1) - (psa[r - 2] - psa[l - 1]) << '\n';
    }
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    solve();
    return 0;
}
