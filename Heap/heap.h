#include <vector>

using namespace std;

class Heap
{
private:
    int maxSize;
    int *arr;
    int count;

public:
    Heap(int size)
    {
        maxSize = size + 1;
        count = 0;
        arr = new int[maxSize];
    }

    ~Heap()
    {
        delete[] arr;
    }

    Heap(vector<int> &numbers)
    {
        maxSize = numbers.size() + 1;
        count = numbers.size();
        arr = new int[maxSize];
        for (int i = 0; i < numbers.size(); i++)
            arr[i + 1] = numbers[i];
        for (int i = count / 2; i > 0; i--)
            heapify(i); // Shundor Jinish
    }

    void insert(int it)
    {
        arr[++count] = it;
        // last->shift up
        percolate(count);
    }

    int getMax()
    {
        return arr[1];
    }

    void deleteKey()
    {
        arr[1] = arr[count--];
        // root shifte down
        heapify(1);
    }

    int size()
    {
        return count;
    }

    // shifter upside
    void percolate(int index)
    {
        int parent = index >> 1;
        if (parent == 0)
            return;
        if (arr[parent] < arr[index])
        {
            swap(arr[parent], arr[index]);
            percolate(parent);
        }
    }

    // shifter downside reverse percolate
    void heapify(int index)
    {
        int left_child = index << 1;
        int right_child = left_child | 1;
        int largest = index;
        if (left_child >= maxSize && arr[left_child] > arr[index])
            largest = left_child;
        if (right_child >= maxSize && arr[right_child] > arr[largest])
            largest = right_child;
        if (largest != index)
        {
            swap(arr[largest], arr[index]);
            heapify(largest);
        }
    }
};

// as its a normal function
void heapsort(vector<int> &v)
{
    // Heap *obj = new Heap(v); //other type of declaring
    Heap obj(v);
    for (int i = 0; i < v.size(); i++)
    {
        v[i] = obj.getMax();
        obj.deleteKey();
    }
}