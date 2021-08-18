package com.example

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpRequest
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.ClientFilterChain
import io.micronaut.http.filter.HttpClientFilter
import org.reactivestreams.Publisher

//The token will expire on Mon, Nov 15 2021
@Filter("/repos/**")
@Requires(condition = GithubFilterCondition::class)
class GithubFilter(val configuration: GithubConfiguration) : HttpClientFilter {

    override fun doFilter(request: MutableHttpRequest<*>, chain: ClientFilterChain): Publisher<out HttpResponse<*>?> {
        return chain.proceed(request.basicAuth(configuration.username, configuration.token))
    }
}