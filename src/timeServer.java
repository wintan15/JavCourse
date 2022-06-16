import java.time.LocalDateTime;
import java.util.Arrays;
class testServer implements timeServer{	
	public int[] getCurrentTime() {
		return timeServer.currentTime();
	}
	public int[] getCurrentDate(){
		return timeServer.currentDate();
	}
}

interface timeServer {
	int[] getCurrentTime();
	int[] getCurrentDate();
	static int[] currentTime() {
		LocalDateTime now = LocalDateTime.now();
		int[] hms = {now.getHour(), now.getMinute(), now.getSecond()};
		return hms;
	}
	static int[] currentDate() {
		LocalDateTime now = LocalDateTime.now();
		int[] ymd = {now.getYear(), now.getMonthValue(), now.getDayOfMonth()};
		return ymd;
	}
	static void main(String[] args) {

		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.getYear());
		System.out.println(Arrays.toString(timeServer.currentDate()));
		
	}
}

