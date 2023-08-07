#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n;
    ll sum = 0, oneCnt = 0;
    cin >> n;
    for (int i = 0, a; i < n; i ++) {
        cin >> a;
        oneCnt += a == 1;
        sum += a;
    }
    cout << (n > 1 && sum >= n + oneCnt ? "YES" : "NO") << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
