#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;

void compute(int n, int freq[]) {
    int p = 1, pv;
    cin >> pv;
    for (int i = 2, x; i <= n; i ++) {
        cin >> x;
        if (pv != x) {
            freq[pv] = max(freq[pv], i - p);
            p = i;
        }
        pv = x;
    }
    freq[pv] = max(freq[pv], n + 1 - p);
}

void solve() {
    int n, ans = 0;
    cin >> n;
    int freqA[2 * n + 1], freqB[2 * n + 1];
    fill(freqA, freqA + 2 * n + 1, 0);
    fill(freqB, freqB + 2 * n + 1, 0);
    compute(n, freqA);
    compute(n, freqB);
    rep(i, 1, 2 * n) ans = max(ans, freqA[i] + freqB[i]);
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
