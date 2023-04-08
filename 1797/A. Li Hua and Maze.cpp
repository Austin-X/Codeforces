#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

void solve() {
    int n, m, x1, y1, x2, y2;
    cin >> n >> m >> x1 >> y1 >> x2 >> y2;
    int f1 = 4, f2 = 4;
    if (x1 == 1 || x1 == n) f1 --;
    if (y1 == 1 || y1 == m) f1 --;
    if (x2 == 1 || x2 == n) f2 --;
    if (y2 == 1 || y2 == m) f2 --;
    cout << min(f1, f2) << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    int t;
    cin >> t;
    while (t-- > 0) solve();

    return 0;
}
