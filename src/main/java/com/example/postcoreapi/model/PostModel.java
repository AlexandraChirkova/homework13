package com.example.postcoreapi.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostModel {
    private String postId;
    @NotNull(message = "Client can not be null")
    private String clientId;
    @NotNull(message = "Recipient can not be null")
    private String postRecipientId;
    @NotNull(message = "Post Name can not be null")
    private String  postItem;
    private String status;
}
