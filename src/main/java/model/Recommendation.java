package model;

import java.util.ArrayList;

class Recommendation{
    private int idUser;
    private int idCriterion;
    private int priority;

    private Recommendation(){
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdCriterion() {
        return idCriterion;
    }

    public int getPriority() {
        return priority;
    }

    public static Recommendation.BuilderRecommendation newBuilder(){
        return new Recommendation().new BuilderRecommendation();
    }

    public class BuilderRecommendation{

        private BuilderRecommendation(){
        }

        public BuilderRecommendation setIdUser(int idUser){
            Recommendation.this.idUser = idUser;
            return this;
        }

        public BuilderRecommendation setIdCriterion(int idCriterion){
            Recommendation.this.idCriterion = idCriterion;
            return this;
        }

        public BuilderRecommendation setPriority(int priority){
            Recommendation.this.priority = priority;
            return this;
        }

        public Recommendation build(){
            return Recommendation.this;
        }
    }
}
