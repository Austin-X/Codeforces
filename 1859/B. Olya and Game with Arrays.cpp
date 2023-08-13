#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n, m;
    cin >> n;

    int mn = INT_MAX;
    vector<int> mn2;
    rep(i, 1, n) {
        cin >> m;
        vector<int> v(m);
        for (int &x: v) cin >> x;
        int minel = *min_element(v.begin(), v.end());
        mn = min(mn, minel);
        v.erase(find(v.begin(), v.end(), minel));
        mn2.push_back(*min_element(v.begin(), v.end()));
    }
   
    cout << mn + (ll) accumulate(mn2.begin(), mn2.end(), 0ll) - *min_element(mn2.begin(), mn2.end()) << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
