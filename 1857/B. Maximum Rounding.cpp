#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    string x;
    cin >> x;
    
    x = "0" + x;
    int l = x.length(), roundIdx = l - 1;
    for (int i = l - 1; i >= 1; i --) {
        if (x[i] >= '5') {
            x[i - 1] ++;
            roundIdx = i - 1;
        }
    }
    
    rep(i, x[0] == '0', l - 1) cout << (i <= roundIdx ? x[i] : '0');
    cout << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
