package com.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize
public class UserResponse {

   private String token;

   public String toString() {
      return this.token;
   }
}
