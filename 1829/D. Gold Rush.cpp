#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;

bool ok(int n, int m) {
    if (n == m) return true;
    if (n % 3 != 0) return false;
    return ok(n / 3, m) || ok(n / 3 * 2, m);
}

void solve() {
    int n, m;
    cin >> n >> m;
    cout << (ok(n, m) ? "YES" : "NO") << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
