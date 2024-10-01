package com.example.issues_dashboard.events;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class GithubProject implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String orgName;

    @Column(unique = true)
    private String repoName;

    public GithubProject() {}

    public GithubProject(String orgName, String repoName) {
        this.orgName = orgName;
        this.repoName = repoName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    @Override
    public String toString() {
        return "GithubProject{" +
                "id=" + id +
                ", orgName='" + orgName + '\'' +
                ", repoName='" + repoName + '\'' +
                '}';
    }
}
