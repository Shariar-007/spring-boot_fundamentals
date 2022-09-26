package com.springpractisewithmyself.blog.payloads;

import lombok.Data;

import javax.persistence.Id;

@Data
public class RoleDto {
    @Id
    private int id;

    private String name;
}
