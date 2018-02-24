package model;

public class UserMessage {
    private int idGroup;
    private int idUser;
    private String text;
    private String time;

    private UserMessage() {
    }

    public int getIdGroup() {
        return idGroup;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    public static UserMessage.BuilderUserMessage newBuilder() {
        return new UserMessage().new BuilderUserMessage();
    }

    public class BuilderUserMessage {

        private BuilderUserMessage(){
        }

        public BuilderUserMessage setIdGroup(int idGroup){
            UserMessage.this.idGroup = idGroup;
            return this;
        }

        public BuilderUserMessage setIdUser(int idUser){
            UserMessage.this.idUser = idUser;
            return this;
        }

        public BuilderUserMessage setText(String text){
            UserMessage.this.text = text;
            return this;
        }

        public BuilderUserMessage setTime(String time){
            UserMessage.this.time = time;
            return this;
        }

        public UserMessage build(){
            return UserMessage.this;
        }
    }
}
