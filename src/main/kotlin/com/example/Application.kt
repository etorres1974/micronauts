package com.example

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	val application = build()
	    .args(*args)
		.packages("com.example")
		.start()
	System.out.println("Application environment contains :\n${application.environment.activeNames}")
}


