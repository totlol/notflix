package hu.martontoth.content.content

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.FileSystemResource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/content")
class ContentController(
        @Value("\${content.path}")
        private val contentPath: String?
) {

    @GetMapping("{id}/thumbnail")
    fun thumbnail(@PathVariable("id") id: Long): ResponseEntity<Mono<FileSystemResource>> {
        val fileSystemResource = FileSystemResource("$contentPath/content/$id/thumbnail.jpg")
        return if (fileSystemResource.exists()) {
            ResponseEntity.ok()
                    .header("Content-Type", "image/jpeg")
                    .body(Mono.just(fileSystemResource))
        } else {
            ResponseEntity.notFound().build()
        }
    }
}