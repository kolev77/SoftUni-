package kolev.exam.terminal;

import kolev.exam.dto.comments.CommentImportXmlDto;
import kolev.exam.dto.comments.CommentWrapperImportXmlDto;
import kolev.exam.dto.pictures.PictureImportJsonDto;
import kolev.exam.dto.posts.PostExportJsonDto;
import kolev.exam.dto.posts.PostImportXmlDto;
import kolev.exam.dto.posts.PostsWrapperXmlDto;
import kolev.exam.dto.users.UserExportJsonDto;
import kolev.exam.dto.users.UserFollowersImportJsonDto;
import kolev.exam.dto.users.UserImportJsonDto;
import kolev.exam.entities.Picture;
import kolev.exam.entities.Post;
import kolev.exam.entities.User;
import kolev.exam.io.ConsoleWriter;
import kolev.exam.serialize.api.Serializer;
import kolev.exam.services.api.CommentService;
import kolev.exam.services.api.PictureService;
import kolev.exam.services.api.PostService;
import kolev.exam.services.api.UserService;
import kolev.exam.utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import static kolev.exam.constants.Paths.*;


@Controller
public class Terminal implements CommandLineRunner {
    // services
    @Autowired
    private PictureService pictureService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;
    
    @Autowired
    private CommentService commentService;


    // serializers
    @Autowired
    @Qualifier("JsonSerializer")
    private Serializer jsonSerializer;

    @Autowired
    @Qualifier("XmlSerializer")
    private Serializer xmlSerializer;

    // writer
    @Autowired
    private ConsoleWriter consoleWriter;


    @Override
    public void run(String... strings) throws Exception {
        //imports
        importPicturesJson();
        importUsersJson();
        importUsersFollowersJson();
        importPostsXml();
        importCommentsXml();

        //exports
        exportPostsWithoutComment();
        exportPopularUsers();

    }

    private void exportPopularUsers() {
        List<User> users = this.userService.findWithCommentsByFollowers();
        List<UserExportJsonDto> usersForExport = new ArrayList<>();

        for (User u : users) {
            UserExportJsonDto userDto = DTOConverter.convert(u,UserExportJsonDto.class);
            userDto.setFollowersNumber(u.getFollowers().size());
            usersForExport.add(userDto);
        }
        this.jsonSerializer.serialize(usersForExport,POPULAR_USERS_OUTPUT_JSON);
    }

    private void exportPostsWithoutComment() {
        List<Post> postsWithoutComment = this.postService.findAllByCommentsIsNullOrderByIdAsc();
        List<PostExportJsonDto> postDtos = new ArrayList<>();

        for (Post post : postsWithoutComment) {
            PostExportJsonDto exportDto = DTOConverter.convert(post,PostExportJsonDto.class);
            postDtos.add(exportDto);
        }
        this.jsonSerializer.serialize(postDtos,POSTS_WITHOUT_COMMENT_OUTPUT_JSON);

    }

    private void importCommentsXml() {
        CommentWrapperImportXmlDto commentWrapperImportXmlDto = this.xmlSerializer.deserialize(CommentWrapperImportXmlDto.class,COMMENTS_INPUT_XML);
        for (CommentImportXmlDto commentDto : commentWrapperImportXmlDto.getComments()) {
            String result = this.commentService.add(commentDto);
            this.consoleWriter.writeLine(result);
        }
    }

    private void importPostsXml() {
        PostsWrapperXmlDto postsWrapperDto = this.xmlSerializer.deserialize(PostsWrapperXmlDto.class, POSTS_INPUT_XML);
        for (PostImportXmlDto postDto : postsWrapperDto.getPosts()) {
            String result = this.postService.add(postDto);
            this.consoleWriter.writeLine(result);

        }
    }

    private void importUsersFollowersJson() {
        UserFollowersImportJsonDto[] usersDtos = this.jsonSerializer.deserialize(UserFollowersImportJsonDto[].class, USERS_FOLLOWERS_INPUT_JSON);

        for (UserFollowersImportJsonDto userDto : usersDtos) {
            String result = this.userService.addFollowers(userDto);
            this.consoleWriter.writeLine(result);
        }
    }

    private void importUsersJson() {
        UserImportJsonDto[] usersDtos = this.jsonSerializer.deserialize(UserImportJsonDto[].class, USERS_INPUT_JSON);

        for (UserImportJsonDto userDto : usersDtos) {
            String result = this.userService.add(userDto);
            this.consoleWriter.writeLine(result);
        }
    }

    private void importPicturesJson() {
        PictureImportJsonDto[] pictureDtos = this.jsonSerializer.deserialize(PictureImportJsonDto[].class, PICTURES_INPUT_JSON);

        for (PictureImportJsonDto pictureDto : pictureDtos) {
            Picture picture = DTOConverter.convert(pictureDto, Picture.class);
            String result = this.pictureService.add(picture);
            this.consoleWriter.writeLine(result);
        }
    }
}
