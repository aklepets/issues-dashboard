package com.example.issues_dashboard.events;

import com.example.issues_dashboard.github.GithubClient;
import com.example.issues_dashboard.github.RepositoryEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EventsController {

    private final GithubProjectRepository repository;

    private final GithubClient githubClient;

    public EventsController(GithubProjectRepository repository, GithubClient githubClient) {
        this.repository = repository;
        this.githubClient = githubClient;
    }

    @GetMapping("/events/{reponame}")
    @ResponseBody
    public RepositoryEvent[] fetchEvents(@PathVariable String reponame){
        GithubProject project = this.repository.findByRepoName(reponame);

        return this.githubClient.fetchEvents(project.getOrgName(), project.getRepoName()).getBody();

    }
}
