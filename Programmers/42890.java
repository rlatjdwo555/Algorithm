import java.util.*;

// Arrays.asList는 새 배열을 리턴하는게 아니라 기존의 배열 주소를 리스트 형식으로 바꿔준다.
// set 요소, map key는 일반적으로 hashcode() 및 equals()를 사용하므로 배열은 적합하지 않다. 리스트로 바꿔써라 
/* 
 A, B, C, D, E 가 있을 때 

(D) 가 후보키가 아니고 
(B, D)가 후보키 라면
(B,C,D)도 가능해야 한다. 

*/

class Solution {
	static int R, N, M, ans;
	static Integer combi[];
	static ArrayList<List<Integer>> candidate = new ArrayList<>();

	public int solution(String[][] relation) {
		N = relation[0].length;
		R = relation.length;

		for (int i = 1; i <= N; i++) {
			combi = new Integer[i];
			M = i;
			combination(0, 0, relation);
		}

		return ans;
	}

	private static void combination(int idx, int start, String[][] relation) {
		if (idx == M) {
			for (List<Integer> key : candidate) {
				int cnt = 0;

				for (int n : combi) {
					if (key.contains(n))
						cnt++;
				}

				if (cnt == key.size()) {
					return;
				}
			}

			if (compare(relation)) {
				candidate.add(Arrays.asList(Arrays.copyOf(combi, M)));
				ans++;
			}
			return;
		}

		for (int i = start; i < N; i++) {
			combi[idx] = i;
			combination(idx + 1, i + 1, relation);
		}
	}

	private static boolean compare(String[][] relation) {
		HashSet<String> hs = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		for (int row = 0; row < R; row++) {
			for (int col : combi) {
				sb.append(relation[row][col]).append(":");
			}

			String key = sb.toString();

			if (hs.contains(key)) {
				return false;
			}

			hs.add(key);
			sb.delete(0, sb.length());
		}

		return true;
	}
}
