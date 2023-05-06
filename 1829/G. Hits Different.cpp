#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;
const int MAX_R = 1415, MN = 1e6 + 1;

int n;
ll psa[MAX_R][MAX_R];
int row[MN], col[MN];

void solve() {
    cin >> n;
    cout << psa[row[n]][col[n]] << '\n';
}

void precompute() {
    ll val = 1;
    for (int i = 1; i <= MAX_R - 1; i ++) {
        for (int j = 1; j <= i; j ++) {
            if (val > 1e6) return;
            psa[i - j + 1][j] = psa[i - j][j] + psa[i - j + 1][j - 1] - psa[i - j][j - 1] + (val * val);
            row[val] = i - j + 1;
            col[val] = j;
            val ++;
        }
    }
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    precompute();

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
