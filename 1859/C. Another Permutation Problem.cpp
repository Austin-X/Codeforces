#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n, ans = 0;
    cin >> n;
    for (int i = 1; i <= n; i ++) {
        for (int j = 1; j <= n; j ++) {
            int mx = i * j, temp = 0;

            vector<vector<int>> a;
            a.assign(n + 1, vector<int>());
            for (int k = n; k >= 1; k --) {
                if (k == j) continue;
                if (mx / k == 0) { temp = -1; break; }
                a[min(mx / k, n)].push_back(k);
            }
            if (temp == -1) continue;

            stack<int> s;
            for (int k = 1; k <= n; k ++) {
                if (k == i) continue;
                s.push(k);
                for (int p: a[k]) {
                    if (s.empty()) {
                        temp = -1;
                        break;
                    }
                    temp += p * s.top();
                    s.pop();
                }
                if (temp == -1) break;
            }

            ans = max(ans, temp);
        }
    }

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
