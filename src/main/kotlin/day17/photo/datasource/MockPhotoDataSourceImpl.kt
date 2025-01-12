package org.hyunjung.day17.photo.datasource

import kotlinx.serialization.json.Json
import org.hyunjung.day17.photo.dto.PhotoDto

class MockPhotoDataSourceImpl : PhotoDataSource {
    override fun getPhotos(): List<PhotoDto> {
        val response = """
            [
              {
                "id": 1,
                "type": "article",
                "title": "This is an article",
                "content": "This is the content of the article.",
                "created_at": "2020-01-01"
              },
              {
                "id": 2,
                "type": "image",
                "url": "https://example.com/image.jpg",
                "caption": "This is an image.",
                "created_at": "2020-02-02"
              },
              {
                "id": 3,
                "type": "video",
                "url": "https://example.com/video.mp4",
                "caption": "This is a video.",
                "created_at": "2020-03-03"
              },        
              {
                "id": "1",
                "type": "article",
                "title": "This is an article",
                "content": "This is the content of the article.",
                "created_at": "2020-01-01"
              },
              {
                "id": 2,
                "type": null,
                "url": "https://example.com/image.jpg",
                "caption": "This is an image.",
                "created_at": "2020-02-02"
              },
              {
                "id": 3,
                "url": "https://example.com/video.mp4",
                "caption": "This is a video.",
                "created_at": "2020-03-03"
              }
            ]
        """.trimIndent()
        return Json.decodeFromString<List<PhotoDto>>(response)
    }
}