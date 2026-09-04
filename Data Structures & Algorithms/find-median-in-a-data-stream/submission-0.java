class MedianFinder {
    List<Integer> values;

    public MedianFinder() {
        this.values = new ArrayList<>();
    }
    
    public void addNum(int num) {
        if(values.size() == 0) values.add(0, num);  
        else{
            int i=0;
            while(values.get(i) <= num && i<values.size()-1) i++;
            //*****The reason why I didn't traversed till the last index was to escape from IndexOutOfBounds Error*****
            if(values.get(i) <= num) values.add(i+1, num);
            else values.add(i, num);
        }
    }
    
    public double findMedian() {
         int mid = values.size();
         if(mid == 0)
            return 0;
        else if(mid % 2 == 1){
            return values.get(mid / 2);
        }else{
            return (double)((values.get(mid / 2) + values.get(mid / 2 - 1))) / 2;
        }


    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */