#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n, p, cnt = 0;
    cin >> n;
    rep(i, 1, n) {
        cin >> p;
        cnt += p == i;
    }
    cout << (cnt + 1) / 2 << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
