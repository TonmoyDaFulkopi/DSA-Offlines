#include <iostream>
#include <vector>
#include <map>

using namespace std;

int countZeroes(vector<int> row)
{
    int ans = 0;

    int length = row.size();

    for (int i = 0; i < length; i++)
    {
        if (row[i] == 0)
            ans++;
    }
    return ans;
}

int maxRowNum(vector<vector<int>> &M, int n, int m, int k)
{
    // distinct row count
    map<vector<int>, int> patternCount;

    // count how many each row pattern appears
    for (int i = 0; i < n; i++)
    {
        vector<int> pattern;

        for (int j = 0; j < m; j++)
        {
            pattern.push_back(M[i][j]);
        }
        patternCount[pattern]++;
    }

    int maxRows = 0;

    // Check each unique row pattern;

    for (auto p : patternCount)
    {
        vector<int> rowPattern = p.first;

        // count of the pattern in matrix
        int count = p.second;

        // count zeroes
        int zeroes = countZeroes(rowPattern);

        // check if its convertible: x <= k && x, k has same parity
        if (zeroes <= k && zeroes % 2 == k % 2)
        {
            maxRows = max(maxRows, count);
        }
    }
    return maxRows;
}

int main()
{
    int n, m, k;
    cin >> n >> m >> k;

    vector<vector<int>> M(n, vector<int>(m));

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
            cin >> M[i][j];
    }

    cout << maxRowNum(M, n, m, k);
}