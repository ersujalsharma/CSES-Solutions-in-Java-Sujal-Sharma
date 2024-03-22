#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
using namespace std;
using namespace __gnu_pbds;

// SOURCES: https://codeforces.com/blog/entry/5631
//          https://www.geeksforgeeks.org/ordered-set-gnu-c-pbds/
template <typename T> using indexed_set =  tree<T,\
            null_type, less<T>, rb_tree_tag,\
            tree_order_statistics_node_update>;

int main () {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k;
    cin >> n >> k;

    indexed_set<int> children;
    for (int i = 1; i <= n; i++) children.insert(i);

    int index = k + 1;
    while (children.size() > 1) {
        index %= children.size();
        if (index == 0) index = children.size();

        auto it = children.find_by_order(index - 1);
        cout << *it << " ";
        children.erase(it);

        index += k;
    }

    cout << *children.begin() << endl;
}