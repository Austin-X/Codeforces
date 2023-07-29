#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n, idxOfFirstPos = 0, idxOfFirstNeg = 0, negCnt = 0, maxAbs = -1, maxAbsIdx = -1;
    cin >> n;
    int a[n + 1];
    rep(i, 1, n) {
        cin >> a[i];
        if (a[i] > 0 && !idxOfFirstPos) idxOfFirstPos = i;
        if (a[i] < 0 && !idxOfFirstNeg) idxOfFirstNeg = i;
        if (abs(a[i]) > maxAbs) {
            maxAbs = abs(a[i]);
            maxAbsIdx = i;
        }
        negCnt += a[i] < 0;
    }

    vector<pii> moves;
    if (negCnt >= 13) {
        rep(i, 1, 5) moves.push_back({idxOfFirstNeg, idxOfFirstNeg});
        rep(i, 1, n) if (a[i] > 0) moves.push_back({i, idxOfFirstNeg});
        for (int i = n - 1; i >= 1; i --) moves.push_back({i, i + 1});
    } else if (negCnt <= 7) {
        if (idxOfFirstNeg || idxOfFirstPos) {
            if (!idxOfFirstPos) { 
                for (int i = n - 1; i >= 1; i --) moves.push_back({i, i + 1});
            } else {
                rep(i, 1, 5) moves.push_back({idxOfFirstPos, idxOfFirstPos});
                rep(i, 1, n) if (a[i] < 0) moves.push_back({i, idxOfFirstPos});
                rep(i, 1, n - 1) moves.push_back({i + 1, i});
            }
        }
    } else {
        if (a[maxAbsIdx] < 0) {
            rep(i, 1, n) if (a[i] > 0) moves.push_back({i, maxAbsIdx});
            for (int i = n - 1; i >= 1; i --) moves.push_back({i, i + 1});
        } else {
            rep(i, 1, n) if (a[i] < 0) moves.push_back({i, maxAbsIdx});
            rep(i, 1, n - 1) moves.push_back({i + 1, i});
        }
    }

    cout << moves.size() << '\n';
    for (pii p: moves) cout << p.first << ' ' << p.second << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
