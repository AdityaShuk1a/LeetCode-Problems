class NumberContainers {
public:

    map<int, int>idx;
    map<int, set<int>>nums;

    NumberContainers() {
        
    }
    
    void change(int index, int number) {
        if(idx.count(index)){
            int old = idx[index];
            nums[old].erase(index);
        if (nums[old].empty()) {
                nums.erase(old);
            }
        }
        idx[index] = number;
        nums[number].insert(index);

    }
    
    int find(int number) {
        return nums.count(number) ? *nums[number].begin() : -1;
    }
};

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers* obj = new NumberContainers();
 * obj->change(index,number);
 * int param_2 = obj->find(number);
 */