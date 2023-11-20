package com.project.workshopmongo.config;

import com.project.workshopmongo.domain.Post;
import com.project.workshopmongo.domain.User;
import com.project.workshopmongo.dto.AuthorDTO;
import com.project.workshopmongo.dto.CommentDTO;
import com.project.workshopmongo.repository.PostRepository;
import com.project.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User user1 = new User(null, "Maria", "maria@mail.com");
        User user2 = new User(null, "Davi", "davi@mail.com");
        User user3 = new User(null, "Lucas", "lucas@mail.com");
        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Post post1 = new Post(null, simpleDateFormat.parse("21/03/2023"), "Hello", "Hello everyone", new AuthorDTO(user1));
        Post post2 = new Post(null, simpleDateFormat.parse("20/11/2023"), "Bye", "Bye everyone", new AuthorDTO(user2));
        postRepository.deleteAll();
        postRepository.saveAll(Arrays.asList(post1, post2));
        user1.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(user1);

        CommentDTO commentDTO1 = new CommentDTO("Good morning!",  simpleDateFormat.parse("21/03/2023"), new AuthorDTO(user3));
        CommentDTO commentDTO2 = new CommentDTO("Good afternoon!",  simpleDateFormat.parse("22/03/2023"), new AuthorDTO(user2));
        CommentDTO commentDTO3 = new CommentDTO("Good night!",  simpleDateFormat.parse("23/03/2023"), new AuthorDTO(user3));
        post1.getComments().addAll(Arrays.asList(commentDTO1, commentDTO2));
        post2.getComments().add(commentDTO3);
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
