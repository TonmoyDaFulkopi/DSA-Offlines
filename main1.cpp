#include <iostream>
using namespace std;

int n, m, map[10][10], visited[10][10], minDifficulty = 11;

// Function to perform the climbing search
void climbRock(int i, int j, int maxClimbTillNow)
{
    // Boundary check for the position, if it's out of the grid, stop
    if (i >= n || i < 0)
        return;
    else if (j >= m || j < 0)
        return;

    // If destination is reached (value 3 in map), compare current climb with the minimum difficulty
    else if (map[i][j] == 3)
    {
        // If the current difficulty is less than the minimum found so far, update it
        if (maxClimbTillNow < minDifficulty)
            minDifficulty = maxClimbTillNow;
    }
    // If the current spot is a '0' (blocked area), stop the search
    else if (map[i][j] == 0)
        return;
    // If the current spot has already been visited, stop the search
    else if (visited[i][j] != 0)
        return;
    else
    {
        // Mark the current spot as visited
        visited[i][j] = 1;

        // Check the vertical move upwards
        int up = i + 1, t1 = 0, down = i - 1;

        // Move upwards until a valid spot (non-blocked) is found or out of bounds
        while (up != n && map[up][j] == 0)
            up++;

        // If a valid upward move is found, calculate the climb difficulty and explore further
        if (up != n && visited[up][j] == 0 && map[up][j] != 0)
        {
            t1 = up - i; // Calculate the difference in height for the climb
            if (maxClimbTillNow > t1)
                t1 = maxClimbTillNow; // Update the maximum climb difficulty encountered
            climbRock(up, j, t1);     // Recursively explore the upward direction
        }

        // Check the vertical move downwards
        while (down != -1 && map[down][j] == 0)
            down--;

        // If a valid downward move is found, calculate the climb difficulty and explore further
        if (down != -1 && visited[down][j] == 0 && map[down][j] != 0)
        {
            t1 = i - down; // Calculate the difference in height for the climb
            if (maxClimbTillNow > t1)
                t1 = maxClimbTillNow; // Update the maximum climb difficulty encountered
            climbRock(down, j, t1);   // Recursively explore the downward direction
        }

        // Horizontal move to the right
        if ((j >= 0 && j < m) && (map[i][j + 1] == 1 || map[i][j + 1] == 3) && (visited[i][j + 1] == 0))
        {
            climbRock(i, j + 1, maxClimbTillNow); // Explore rightward
        }

        // Horizontal move to the left
        if ((j >= 0 && j < m) && (map[i][j - 1] == 1 || map[i][j - 1] == 3) && (visited[i][j - 1] == 0))
        {
            climbRock(i, j - 1, maxClimbTillNow); // Explore leftward
        }

        // Unmark the current spot as visited to explore other paths
        visited[i][j] = 0;
    }
}

int main()
{
    int i, j;

    // Read the size of the grid
    cin >> n >> m;

    // Initialize the map and visited arrays to zero
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < m; j++)
            map[i][j] = visited[i][j] = 0;
    }

    // Read the map values (0 = blocked, 1 = walkable, 3 = destination)
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < m; j++)
            cin >> map[i][j];
    }

    // Start climbing from the bottom-left corner (n-1, 0) with an initial maximum climb difficulty of 0
    climbRock(n - 1, 0, 0);

    // Output the minimum climbing difficulty found
    cout << minDifficulty << endl;

    return 0;
}
