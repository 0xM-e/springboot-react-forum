package com.forum.Api.business.concretes;

import com.forum.Api.business.abstracts.PostService;
import com.forum.Api.business.requests.CreatePostRequest;
import com.forum.Api.business.requests.DeletePostRequest;
import com.forum.Api.business.requests.UpdatePostRequest;
import com.forum.Api.business.responses.GetAllPostResponse;
import com.forum.Api.business.responses.GetPostsByCategoryResponse;
import com.forum.Api.dataAccess.abstracts.PostRepository;
import com.forum.Api.entities.concretes.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PostManager implements PostService {
    private final PostRepository postRepository;

    public PostManager(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<GetAllPostResponse> getAll() {
        List<GetAllPostResponse> getAllPostResponse = new ArrayList<>();
        List<Post> posts =  postRepository.findAll();

        for(Post post : posts){
            GetAllPostResponse asd = new GetAllPostResponse();
            asd.setId(post.getId());
            asd.setTitle(post.getTitle());
            asd.setContent(post.getContent());
            getAllPostResponse.add(asd);
        }
        return getAllPostResponse;
    }

    @Override
    public List<GetPostsByCategoryResponse> getPostsByCategoryId(int id) {
        List<GetPostsByCategoryResponse> getPostsByCategoryResponse = new ArrayList<>();
        List<Post> posts = postRepository.getPostsByCategoryId(id);

        for (Post post : posts){
            GetPostsByCategoryResponse temp = new GetPostsByCategoryResponse();
            temp.setId(post.getId());
            temp.setTitle(post.getTitle());
            temp.setContent(post.getContent());
            temp.setUpdatedAt(post.getCreatedAt());
            temp.setCreatedAt(post.getCreatedAt());
            temp.setAuthor(post.getAuthor());
            getPostsByCategoryResponse.add(temp);
        }

        return getPostsByCategoryResponse;
    }

    @Override
    public Post getPostById(int id) {
        return postRepository.findById(id).orElseThrow();
    }

    @Override
    public void createPost(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setTitle(createPostRequest.getTitle());
        post.setContent(createPostRequest.getContent());
        postRepository.save(post);
    }

    @Override
    public void deletePost(DeletePostRequest deletePostRequest) {
        postRepository.deleteById(deletePostRequest.getId());
    }

    @Override
    public void updatePost(UpdatePostRequest updatePostRequest) {
        Post post = postRepository.findById(updatePostRequest.getId()).orElseThrow();;
        post.setTitle(updatePostRequest.getTitle());
        post.setContent(updatePostRequest.getContent());
        postRepository.save(post);
    }
}
