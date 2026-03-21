class MedianFinder {
    PriorityQueue<Integer> maxH = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> minH = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        maxH.add(num);
        minH.add(maxH.poll());
        if(maxH.size() < minH.size()) maxH.add(minH.poll());
        
    }
    
    public double findMedian() {
        if(maxH.size() > minH.size()) return (double)maxH.peek();
        else return (double)((double)(maxH.peek() + minH.peek()) / 2.0);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */