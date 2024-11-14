package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public abstract class BaseEntity {
    private UUID id;
}
