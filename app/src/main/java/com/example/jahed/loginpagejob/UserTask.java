package com.example.jahed.loginpagejob;

public class UserTask {

    private int userTaskId;
    private String usertask;



    public UserTask() {
    }

    public UserTask(int userTaskId, String usertask) {
        this.userTaskId = userTaskId;
        this.usertask = usertask;
    }

    public UserTask(String usertask) {
        this.usertask = usertask;
    }

    public int getUserTaskId() {
        return userTaskId;
    }

    public void setUserTaskId(int userTaskId) {
        this.userTaskId = userTaskId;
    }

    public String getUsertask() {
        return usertask;
    }

    public void setUsertask(String usertask) {
        this.usertask = usertask;
    }
}
