#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;

void solve() {
    int n, fix = 0;
    cin >> n;
    int p[n + 1], freq[n + 1];
    fill(freq, freq + n + 1, 0);
    rep(i, 1, n) cin >> p[i];

    rep(i, 1, n) {
        int diff = abs(i - p[i]);
        if (diff != 0) fix ++;
        for (int j = 1; j <= sqrt(diff); j ++) {
            if (diff % j == 0) {
                freq[j] ++;
                if (diff / j != j) freq[diff / j] ++;
            }
        }
    }

    int ans = 0;
    rep(i, 1, n) if (freq[i] == fix) ans = i;
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
