package com.example.microtask.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {
    private Long id;
    private String title;
    private String description;
    private String status;
    private Long userId;
}
