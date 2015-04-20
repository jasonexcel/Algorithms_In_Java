/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
 */
package LeetCode;

public class GasStation {

	public GasStation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null) {
            return -1;
        }
        if(gas.length != cost.length) {
            return -1;
        }
        int gasInTank = 0;
        int stationCount = 0;
        int len = gas.length;
        int i = 0;
        while(i < len) {
            int carPos = i;
            gasInTank = 0;
            stationCount = 0;
            while(stationCount < len) {
                int position = carPos % len;
                gasInTank = gasInTank + gas[position] - cost[position];
                if(gasInTank < 0) {
                    break;
                }
                stationCount++;
                carPos++;
            }
            if(stationCount == len) {
                return i;
            }
            // !!! i can not be assign as "carPos%len+1", infinte loop
            // if carPos >= len-1, then terminate the loops, return -1
            i =  carPos + 1;
        }
        return -1;
    }
}
