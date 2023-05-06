#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;

void solve() {
    string s, cf = "codeforces";
    cin >> s;
    int ans = 0;
    for (int i = 0; i < 10; i ++) ans += cf[i] != s[i];
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
