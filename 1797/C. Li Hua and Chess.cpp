#include <bits/stdc++.h>
using namespace std;

int T, n, m;

int ask(int x, int y) {
    cout << "? " << x << " " << y << '\n';
    cout.flush();
    int dis = 0;
    cin >> dis;
    return dis;
}

void give(int x, int y) {
    cout << "! " << x << " " << y << '\n';
    cout.flush();
}

void solve() {
    cin >> n >> m;
    int layer = ask(1, 1) + 1;
    if (layer > n) {
        int res = ask(1, layer) + 1;
        give(res, layer);
    } else if (layer > m) {
        int res = ask(layer, 1) + 1;
        give(layer, res);
    } else {
        int res1 = ask(1, layer) + 1, res2 = ask(layer, 1) + 1;
        res1 <= res2 ? give(res1, layer) : give(layer, res2);
    }
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    cin >> T;
    while (T-- > 0) solve();

    return 0;
}
