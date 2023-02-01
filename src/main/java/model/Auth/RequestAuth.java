package model.Auth;

import static util.DataReader.getData;

public class RequestAuth{
	private String password;
	private String username;

	public String getPassword(){
		return password;
	}

	public String getUsername(){
		return username;
	}

	public static class Builder {

		private String passwordBuild;
		private String usernameBuild;

		public RequestAuth build() {
			RequestAuth data = new RequestAuth();
			data.password = getData("token.password");
			data.username = getData("token.user");
			return data;
		}
	}
}
