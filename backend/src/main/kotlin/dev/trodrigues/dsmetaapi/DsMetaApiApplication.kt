package dev.trodrigues.dsmetaapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DsMetaApiApplication

fun main(args: Array<String>) {
    runApplication<DsMetaApiApplication>(*args)
}
