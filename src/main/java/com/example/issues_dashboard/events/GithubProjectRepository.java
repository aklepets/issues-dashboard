package com.example.issues_dashboard.events;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface GithubProjectRepository extends PagingAndSortingRepository<GithubProject, Long> {

    GithubProject findByRepoName(String repoName);
}
