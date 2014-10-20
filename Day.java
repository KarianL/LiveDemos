
public class Day {
	public final static int JANARY = 31;
	public final static int FEBRARY = 28;
	public final static int MARCH = 31;
	public final static int APRIL = 30;
	public final static int MAY = 31;
	public final static int JUNE = 30;
	public final static int JULY = 31;
	public final static int AUGUST = 31;
	public final static int SEPTEMBER = 30;
	public final static int OCTOBOR = 31;
	public final static int NOVEMBER = 30;
	public final static int DECEMBER = 31;
	public final static int[] moths = {JANARY, FEBRARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBOR, NOVEMBER, DECEMBER};
	
	
	private int month;
    private int day;
    private int year;
    public final int[][] days = {};
    public Day() {}
    
    public Day(int year, int month, int day) {
        this.month = month;
        this.day = day;
        this.year = year;
    }
    
    public static int computeYear(Day from, Day to) {
        int year_days = 0;
        for (int i = from.year; i < to.year; i++) {
        	if (isLeapYear(i)) {
        		year_days += 366;
        	} else {
        		year_days += 365;
        	}
        } 
        return year_days;
    }
    
    public static int computeMonth(int from, int to) {
    	int month_days = 0;
    	if (from < to) {
    		for (int i = from; i < to; i++) {
    			month_days += moths[i-1];
    		}
    	} else {
    		for (int i = from; i > to; i--) {
    			month_days -= moths[i-1];
    		}
    	}
    	return month_days;
    }
    
    public static int computeDay(int from, int to) {
    	return to - from + 1;
    }
    
    public static boolean isLeapYear(int year) {
    	return year % 100 == 0 ? year % 400 == 0 : year % 4 == 0;
    }
	
	public static void main(String[] args) {
		Day from = new Day(1951, 5, 26);
		Day to = new Day(2012, 7, 23);
		System.out.println(computeYear(from, to));
		System.out.println(computeMonth(from.month, to.month));
		System.out.println(computeDay(from.day, to.day));
		System.out.println(computeYear(from, to) + computeMonth(from.month, to.month) + computeDay(from.day, to.day));
	}
}