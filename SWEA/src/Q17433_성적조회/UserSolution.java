package Q17433_성적조회;

import java.util.HashMap;
import java.util.TreeSet;

class UserSolution {
	private HashMap<Integer, Student> s;
	private HashMap<String, SetByGG> ss;

	public void init() {
		s = new HashMap<>();
		ss = new HashMap<>();
		ss.put("1male", new SetByGG());
		ss.put("1female", new SetByGG());
		ss.put("2male", new SetByGG());
		ss.put("2female", new SetByGG());
		ss.put("3male", new SetByGG());
		ss.put("3female", new SetByGG());
	}

	public int add(int mId, int mGrade, char mGender[], int mScore) {
		String gender = charToString(mGender);
		Student student = new Student(mId, mGrade, gender, mScore);
		s.put(mId, student);
		SetByGG setByGG = ss.get(mGrade + gender);
		setByGG.push(student);
		return setByGG.max.mId;
	}


	public int remove(int mId) {
		Student student = s.getOrDefault(mId, null);
		if (student == null) return 0;

		SetByGG setByGG = ss.get(student.grade + student.gender);
		s.remove(mId);
		Student ret = setByGG.delete(student);
		return ret == null ? 0 : ret.mId;
	}

	public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
		Student min = null;
		for (int i = 0; i < mGenderCnt; i++) {
			for (int j = 0; j < mGradeCnt; j++) {
				String key = mGrade[j] + charToString(mGender[i]);
				SetByGG setByGG = ss.get(key);
				Student student = setByGG.find(mScore);

				if (student == null) continue;

				if (min == null || min.score > student.score || (min.score == student.score && min.mId > student.mId))
					min = student;
			}
		}

		return min == null ? 0 : min.mId;
	}


	//////////////////////////////////////
	//////////////////////////////////////
	//////////////////////////////////////

	private String charToString(char[] mGender) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mGender.length; i++) {
			if (mGender[i] == '\0') break;
			sb.append(mGender[i]);
		}
		return sb.toString();
	}

	private class Student {
		int mId;
		int grade;
		String gender;
		int score;

		Student(int mId, int grade, String gender, int score) {
			this.mId = mId;
			this.grade = grade;
			this.gender = gender;
			this.score = score;
		}

		Student(int score) {
			this.score = score;
		}
	}

	// set by grade+gender;
	private class SetByGG {
		Student max;
		Student min;
		TreeSet<Student> list = new TreeSet<>((n1, n2) -> {
			if (n1.score == n2.score) return n1.mId - n2.mId;
			return n1.score - n2.score;
		});

		// 학생 추가 및 max,min 설정
		void push(Student s) {
			list.add(s);
			min = list.first();
			max = list.last();
		}

		Student find(int mScore) {
			return list.ceiling(new Student(mScore));
		}

		Student delete(Student student) {
			list.remove(student);

			if (list.size() == 0) {
				max = null;
				min = null;
				return null;
			}

			min = list.first();
			max = list.last();

			return min;
		}
	}
}