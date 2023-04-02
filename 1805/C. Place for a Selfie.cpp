#include <bits/stdc++.h>
using namespace std;

#define int long long

void solve() {
    int n, m;
    cin >> n >> m;
    
    vector<int> lines(n);
    for (int i = 0; i < n; i ++) cin >> lines[i];
    sort(lines.begin(), lines.end());

    while (m-- > 0) {
        int a, b, c;
        cin >> a >> b >> c;

        if (c < 0) {
            cout << "NO\n";
            continue;
        }
        
        int idx = lower_bound(lines.begin(), lines.end(), b) - lines.begin();
        if (idx < n && (b - lines[idx]) * (b - lines[idx]) < 4 * a * c) cout << "YES\n" << lines[idx] << '\n';
        else if (idx > 0 && (b - lines[idx - 1]) * (b - lines[idx - 1]) < 4 * a * c) cout << "YES\n" << lines[idx - 1] << '\n';
        else cout << "NO\n";
    }
}

signed main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    int t;
    cin >> t;
    while (t-- > 0) solve();

    return 0;
}
