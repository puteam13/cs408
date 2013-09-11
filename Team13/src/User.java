
public class User {

	String username;
	String password;
	int score[] = new int[5];

	public User() {
		username = null;
		password = null;
		for (int i = 0; i < 5; i++)
			score[i] = 0;
	}

	public User(String n, String s) {
		this.username = n;
		this.password = s;

	}

	public String getUsername() {

		return username;
	}

	public String getUserpassword() {
		return password;

	}

	public String setUsername(String s) {

		this.username = s;
		return s;

	}

	public String setPassword(String s) {

		this.password = s;
		return s;
	}

	public void update_score(int a) {
		if (a <= score[4])
			return;
		else if (a > score[0]) {
			score[4] = score[3];
			score[3] = score[2];
			score[2] = score[1];
			score[1] = score[0];
			score[0] = a;
		} else if (a > score[1]) {
			score[4] = score[3];
			score[3] = score[2];
			score[2] = score[1];
			score[1] = a;

		} else if (a > score[2]) {
			score[4] = score[3];
			score[3] = score[2];
			score[2] = a;

		} else if (a > score[3]) {
			score[4] = score[3];

			score[3] = a;
		} else if (a > score[4]) {
			score[4] = a;

		}

	}

}
