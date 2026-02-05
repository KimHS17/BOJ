import java.io.*;
import java.util.*;

public class Main {
	static class Interval implements Comparable<Interval> {
		int start;
		int end;
		boolean hasChild = false;

		public Interval(int x1, int x2) {
			this.start = Math.min(x1, x2);
			this.end = Math.max(x1, x2);
		}

		@Override
		public int compareTo(Interval o) {
			return this.start - o.start;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> coorList = new ArrayList<>();
		ArrayList<Interval> intervals = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		boolean isPositive = false;
		boolean isStartYPositive = false;
		int firstX = 0;

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if(i == 0) {
				firstX = x;

				if(y > 0) {
					isPositive = true;
					isStartYPositive = true;
				}
			}

			if(y < 0 && isPositive) {
				coorList.add(x);
				isPositive = false;
			} else if(y > 0 && !isPositive) {
				coorList.add(x);
				isPositive = true;
			}
		}

		if (isPositive != isStartYPositive) {
            coorList.add(firstX); 
        }

		if(isStartYPositive) {
			coorList.add(coorList.remove(0));
		}

		for(int i = 0; i < coorList.size(); i += 2) {
			intervals.add(new Interval(coorList.get(i), coorList.get(i + 1)));
		}
		Collections.sort(intervals);

		int countInner = 0;
		int countOuter = 0;
		for(int i = 0; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);

			while(!stack.isEmpty()) {
				int topIdx = stack.peek();
				Interval topInterval = intervals.get(topIdx);

				if(topInterval.end < cur.start) {
					stack.pop();
					if(!topInterval.hasChild) {
						countInner++;
					}
				} else {
					break;
				}
			}

			if(!stack.isEmpty()) {
				int parentIdx = stack.peek();
				intervals.get(parentIdx).hasChild = true;
			} else {
				countOuter++;
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int idx = stack.pop();
			if (!intervals.get(idx).hasChild) {
				countInner++;
			}
		}

		bw.write(countOuter + " " + countInner);
		bw.flush();
	}
}
