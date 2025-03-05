#include <iostream>
#include <climits>

using namespace std;

int n;
int gate[3];
int people[3];
int sum = 0;
int ans = INT_MAX;

// count is how many fisherman assigned
void solve(int index, int val, int count)
{
    // all assigned
    if (count == sum)
    {
        ans = min(ans, val);
        return;
    }

    // all spot considered
    if (index == n + 1)
    {
        return;
    }

    // assign one man of each gate
    for (int i = 0; i < 3; i++)
    {
        // if theres people at the gate
        if (people[i] > 0)
        {
            people[i]--;

            solve(index + 1, val + abs(gate[i] - index) + 1, count + 1);

            // restore!!!!!!!!!!
            people[i]++;
        }
    }

    solve(index + 1, val, count);
}

int main()
{
    // spots
    cin >> n;
    for (int i = 0; i < 3; i++)
        cin >> gate[i];

    for (int i = 0; i < 3; i++)
    {
        cin >> people[i];
        sum += people[i];
    }

    solve(1, 0, 0);

    cout << ans << endl;
}