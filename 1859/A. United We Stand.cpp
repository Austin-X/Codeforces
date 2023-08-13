#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;
    int a[n];
    for (int i = 0; i < n; i ++) cin >> a[i];
    sort(a, a + n);
    int idx = -1;
    for (int i = 0; i < n - 1; i ++) if (a[i] != a[i + 1]) { idx = i; break; }
    
    if (idx != -1) {
        cout << (idx + 1) << ' ' << (n - idx - 1) << '\n';
        rep(i, 0, idx) cout << a[i] << ' ';
        cout << '\n';
        rep(i, idx + 1, n - 1) cout << a[i] << ' ';
        cout << '\n';
    } else cout << "-1\n";
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
