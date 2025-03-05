#include <iostream>
#include <vector>

using namespace std;

int INF = 1e9;
int N;

vector<vector<int>> M;
vector<vector<int>> dp;

int tsp(int mask, int pos)
{
    // if all cities visited, return cost to go back to 0
    if (mask == (1 << N) - 1)
        return M[pos][0]; // has to be 0 and use the M!!!!!!

    // if already computed return it
    if (dp[mask][pos] != -1)
        return dp[mask][pos];

    int ans = INF;

    // visit all cities
    for (int city = 0; city < N; city++)
    {
        // if city not visited
        if (!(mask & (1 << city)))
        {
            // making that city look visited
            int newAns = M[pos][city] + tsp(mask | (1 << city), city);
            ans = min(ans, newAns);
        }
    }
    return dp[mask][pos] = ans;
}

int main()
{
    int T;
    cin >> T;

    while (T--)
    {
        cin >> N;

        M.assign(N, vector<int>(N));

        dp.assign(1 << N, vector<int>(N, -1));

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                cin >> M[i][j];
            }
        }

        cout << tsp(1, 0) << endl;
    }
}