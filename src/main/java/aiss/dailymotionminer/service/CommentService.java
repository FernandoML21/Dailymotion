package aiss.dailymotionminer.service;

import aiss.dailymotionminer.model.dailymotion.Comment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    // No necesitamos RestTemplate ni BaseUri porque no vamos a hacer peticiones reales

    public List<Comment> getComments(String videoId, int maxComments) {
        // Devolvemos siempre una lista vacía.
        // Los comentarios reales se fabricarán a partir de los tags en el Transformer.
        return new ArrayList<>();
    }
}