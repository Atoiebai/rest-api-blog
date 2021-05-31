package net.sublime.rest.mapper;


import net.sublime.rest.dto.post.PostDTO;
import net.sublime.rest.model.post.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDTO toDTO(Post post);

    Post toEntity(PostDTO postDTO);
}
