package com.example

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.reactivestreams.Publisher
import io.micronaut.core.async.annotation.SingleResult

@Controller("/github")
class GithubController(private val githubLowLevelClient: GithubLowLevelClient,
                       private val githubApiClient: GithubApiClient) {

    @Get("/releases-lowlevel")
    @SingleResult
    fun releasesWithLowLevelClient(): Publisher<List<GithubRelease>> {
        return githubLowLevelClient.fetchReleases()
    }

    @Get(uri = "/releases", produces = [MediaType.APPLICATION_JSON_STREAM])
    fun fetchReleases(): Publisher<GithubRelease?>? {
        return githubApiClient.fetchReleases()
    }
}