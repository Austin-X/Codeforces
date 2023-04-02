#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

void solve() {
    int n, x, res = 0;
    cin >> n;
    for (int i = 0; i < n; i ++) {
        cin >> x;
        res ^= x;
    }
    cout << (n % 2 == 0 ? (res == 0 ? 1 : -1) : res) << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    int t;
    cin >> t;
    while (t-- > 0) solve();

    return 0;
}
