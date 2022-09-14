package com.springpractisewithmyself.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class FileResponse {

    private String fileName;
    private String message;

    public FileResponse(String fileName, String message) {
        this.fileName = fileName;
        this.message = message;
    }
}
