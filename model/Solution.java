package model;

public class Solution {
    private Integer id;
    private String created;
    private String updated;
    private String description;
    private Integer exercise_id;
    private Integer user_id;

    public Solution(){

    };

    public Solution(String created, String updated, String description, Integer exerciseId, Integer userId ){
            this.created = created;
            this.updated = updated;
            this.description = description;
            this.exercise_id= exerciseId;
            this.user_id= userId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Integer exerciseId) {
        this.exercise_id = exerciseId;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer userId) {
        this.user_id = userId;
    }
}
