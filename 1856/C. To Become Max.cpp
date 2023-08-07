#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

int n, k;
bool works(int a[], int val) {
    for (int i = 1; i < n; i ++) {
        ll ops = k, cur = val, j = i;
        for (; j <= n; j ++) {
            if (a[j] >= cur) break;
            ops -= (cur - a[j]);
            cur --;
        }
        if (j != n + 1 && ops >= 0) return true;
    }
    return false;
}

void solve() {
    cin >> n >> k;
    int a[n + 1];
    rep(i, 1, n) cin >> a[i];

    int l = *max_element(a + 1, a + n + 1) + 1, r = 2e8;
    while (l <= r) {
        int mid = (l + r) / 2;
        works(a, mid) ? l = mid + 1 : r = mid - 1;
    }
    
    cout << r << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
