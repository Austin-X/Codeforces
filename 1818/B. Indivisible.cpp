#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;
    if (n == 1) cout << "1\n";
    else if (n % 2) cout << "-1\n";
    else {
        int a[n];
        iota(a, a + n, 1);
        for (int i = 0; i < n; i += 2) swap(a[i], a[i + 1]);
        for (int x: a) cout << x << ' ';
        cout << '\n';
    }
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
