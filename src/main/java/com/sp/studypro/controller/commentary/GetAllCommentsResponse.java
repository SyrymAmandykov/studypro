package com.sp.studypro.controller.commentary;

import com.sp.studypro.mapper.dto.CommentaryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCommentsResponse {

    List<CommentaryDto> comments;
}
