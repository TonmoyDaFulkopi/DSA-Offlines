#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

struct Edge
{
    int to, cost;
    Edge(int _to, int _cost) : to(_to), cost(_cost) {}
};

int dijkstra(int start, int end, vector<vector<Edge>> &graph)
{
    // PQ -> Cost and Node
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    // Distance vector initialized to INF
    vector<int> dist(graph.size(), INT_MAX);

    // Start with Source
    // Cost , Node
    pq.push({0, start});
    dist[start] = 0;

    // this shit is hard
    // process each node
    while (!pq.empty())
    {
        int currCost = pq.top().first;
        int node = pq.top().second;

        pq.pop();

        // Check cost if
        if (currCost > dist[node])
            continue;

        // Explore all Neighbors
        for (auto edge : graph[node])
        {
            // cost to reach neighbor
            int newCost = currCost + edge.cost;

            // if shorter path is found update distance and PUSH to queue
            if (newCost < dist[edge.to])
            {
                dist[edge.to] = newCost;
                pq.push({newCost, edge.to});
            }
        }
    }

    return dist[end];
}

int main()
{
    int T;
    cin >> T;

    while (T--)
    {
        int N;
        cin >> N;

        vector<pair<int, int>> points;

        int sx, sy, dx, dy;

        cin >> sx >> sy >> dx >> dy;

        points.push_back({sx, sy});
        points.push_back({dx, dy});

        vector<pair<int, int>> wormholes(2 * N);
        vector<int> wormhole_cost(N);

        for (int i = 0; i < N; i++)
        {
            int x1, y1, x2, y2, cost;
            cin >> x1 >> y1 >> x2 >> y2 >> cost;

            // THIS IS INTERESTING
            wormholes[2 * i] = {x1, y1};
            wormholes[2 * i + 1] = {x2, y2};

            wormhole_cost[i] = cost;
        }

        // ADDing to points
        points.insert(points.end(), wormholes.begin(), wormholes.end());

        int totalNodes = points.size();

        vector<vector<Edge>> graph(totalNodes);

        // Connect all nodes with manhattan
        for (int i = 0; i < totalNodes; i++)
        {
            for (int j = i + 1; j < totalNodes; j++)
            {
                int cost = abs(points[i].first - points[j].first) +
                           abs(points[i].second - points[j].second);

                // to and cost
                graph[i].push_back(Edge(j, cost));
                graph[j].push_back(Edge(i, cost));
            }
        }

        // Add wormhole edges THESE ARE DIFFERENT
        for (int i = 0; i < N; i++)
        {
            int u = 2 * i + 2; // ENTRY after first two
            int v = 2 * i + 3;

            int cost = wormhole_cost[i];

            // connect BOTH WAYS
            graph[u].push_back(Edge(v, cost));
            graph[v].push_back(Edge(u, cost));
        }

        cout << dijkstra(0, 1, graph) << endl;
    }
}