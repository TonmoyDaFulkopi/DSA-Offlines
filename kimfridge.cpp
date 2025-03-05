#include <iostream>
#include <vector>

using namespace std;

int T, N;

vector<pair<int, int>> locations;

vector<vector<int>> M;
vector<vector<int>> dp;

const int INF = 1e9;

int tsp(int mask, int pos)
{
    // if all visited return the value to get home
    if (mask == ((1 << (N + 2)) - 1))
        return M[pos][1];

    // if it has value then return it
    if (dp[mask][pos] != -1)
        return dp[mask][pos];

    int ans = INF;

    // travel to all cities
    for (int city = 0; city < N + 2; city++)
    {
        // if not visited
        if (!(mask & (1 << city)))
        {
            int tempAns = M[pos][city] + tsp(mask | (1 << city), city);
            ans = min(ans, tempAns);
        }
    }

    return dp[mask][pos] = ans;
}

int main()
{
    int T = 10;
    for (int t = 0; t < T; t++)
    {
        cin >> N;

        // resize locations
        locations.resize(N + 2);

        // resize M
        M.assign(N + 2, vector<int>(N + 2, 0));

        // resize dp
        dp.assign(1 << (N + 2), vector<int>(N + 2, -1));

        // get locations
        for (int i = 0; i < N + 2; i++)
            cin >> locations[i].first >> locations[i].second;

        // Fix the M matrix
        for (int i = 0; i < N + 2; i++)
        {
            for (int j = 0; j < N + 2; j++)
            {
                M[i][j] = abs(locations[i].first - locations[j].first) +
                          abs(locations[i].second - locations[j].second);
            }
        }

        // Start from Office
        int result = tsp(1, 0);

        cout << "# " << t + 1 << " " << result << endl;
    }
}