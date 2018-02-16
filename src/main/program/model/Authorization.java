package model;

public class Authorization {
    private int id;
    private String nickname;
    private String password;

    private Authorization() {
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static Authorization.BuilderAuthorization newBuilder() {
        return new Authorization().new BuilderAuthorization();
    }

    public class BuilderAuthorization {

        private BuilderAuthorization() {
        }

        public BuilderAuthorization setId(int id) {
            Authorization.this.id = id;
            return this;
        }

        public BuilderAuthorization setNickname(String nickname) {
            Authorization.this.nickname = nickname;
            return this;
        }

        public BuilderAuthorization setPassword(String password) {
            Authorization.this.password = password;
            return this;
        }

        public Authorization build() {
            return Authorization.this;
        }
    }
}
