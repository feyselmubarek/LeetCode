class MyCalendar {
    TreeMap<Integer, Integer> events;
    
    public MyCalendar() {
        events = new TreeMap<>();    
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> ceil = events.ceilingEntry(start), 
            floor = events.floorEntry(start);
        if((ceil != null && end > ceil.getKey()) || (floor != null && start < floor.getValue())){
            return false;
        }
           
        events.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */