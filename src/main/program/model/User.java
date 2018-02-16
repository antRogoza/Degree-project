package model;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int idAuthorization;

    private User(){
    }

    public int getIdUser() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getIdLogin() {
        return idAuthorization;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idLogin=" + idAuthorization +
                '}';
    }

    public static User.BuilderUser newBuilder() {
        return new User().new BuilderUser();
    }

    public class BuilderUser {

        private BuilderUser() {
        }

        public BuilderUser setId(int id) {
            User.this.id = id;
            return this;
        }

        public BuilderUser setFirstName(String firstName) {
            User.this.firstName = firstName;
            return this;
        }

        public BuilderUser setLastName(String lastName) {
            User.this.lastName = lastName;
            return this;
        }

        public BuilderUser setIdAuthorization(int idAuthorization) {
            User.this.idAuthorization = idAuthorization;
            return this;
        }

        public User build(){
            return User.this;
        }
    }
}
