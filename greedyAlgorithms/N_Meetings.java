/*Maximum meetings
Difficulty: EASY
Contributed By
Anish De
|
Level 1
Avg. time to solve
10 min
Success Rate
90%
Problem Statement
You are given the schedule of N meetings with their start time Start[i] and end time End[i]. But you have only 1 meeting room. So, you need to tell the meeting numbers you can organize in the given room, such that the number of meetings organized is maximum.
Note:
The start time of one chosen meeting can’t be equal to the end time of the other chosen meeting. Also for the same end time, a meeting with a smaller index is preferred. 
Input Format:
The first line contains an integer 'T' denoting the number of test cases or queries to be run. 

The first line of each test case or query contains a single integers 'N' denoting the number of meetings. 

The second line of each test case contains N single space-separated integers denoting the start time of N meetings respectively.

The third line of each test case contains N single space-separated integers denoting the end time of N meetings respectively.
Output Format:
For each test case, print the meeting numbers (Consider 1 based indexing) you organized in the given room, in the order in which you organized them such that the number of meetings is maximum.
Note:
You do not need to print anything, it has already been taken care of. Just implement the given function.
Constraints:
1 <= T <= 5
1 <= N <= 10^5
0 <= Start[i] < End[i] <= 10^9

Time Limit: 1 sec
Sample Input 1:
2
6
1 3 0 5 8 5
2 4 6 7 9 9
3
1 1 1
4 5 9
Sample Output 1:
1 2 4 5
1
Explanation For Sample Input 1:
For test case 1: 
You can organize a maximum of 4 meetings. Meeting number 1 from 1 to 2, Meeting number 2 from 3 to 4, Meeting number 4 from 5 to 7, and Meeting number 5 from 8 to 9.

For test case 2:
As all meetings have the same start time, you can organize only 1 meeting in the room.
Sample Input 2:
2
5
0 7 1 4 8
2 9 5 9 10
3
1 2 3
4 4 4
Sample Output 2:
1 2 
1
*/
import java.util.*;
public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
        //Write your code here
		ArrayList<meetings> arr =new ArrayList<>();
        for(int i=0;i<start.length;i++){
            arr.add(new meetings(start[i],end[i],i+1));
        }
        ArrayList<Integer> ans=new ArrayList<>();
        Collections.sort(arr,new meetingComparator());
        int prevEnd=-1; 
        int count=0;
        for(int i=0;i<start.length;i++){
            meetings m=arr.get(i);
           // System.out.println(m.startTime+" "+m.endTime);
            if(m.startTime>prevEnd){
                count++;
                prevEnd=m.endTime;
				ans.add(m.serialNum);
            }
        }
        return ans;
    }
}
class meetings{
    int startTime;
    int endTime;
    int serialNum;
    public meetings(int startTime,int endTime, int serialNum){
        this.startTime=startTime;
        this.endTime=endTime;
        this.serialNum=serialNum;
    }
}

class meetingComparator implements Comparator<meetings>{
    public int compare(meetings p1,meetings p2){
        if(p1.endTime<p2.startTime)
			return -1;
		if(p1.endTime<p2.endTime)
			return -1;
		if(p1.endTime==p2.startTime)
			return -1;
		return 1;
    }
}
