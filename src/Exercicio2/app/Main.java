package Exercicio2.app;

import Exercicio2.entities.Comment;
import Exercicio2.entities.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Comment c1 = new Comment("Have a nice trip");
        Comment c2 = new Comment("Wow that's awesome");
        Post p1 = new Post(
                LocalDateTime.parse("21/06/2018 13:05:44", dtf),
                12,
                "I'm going to visit this wonderful country!",
                "Traveling to New Zealand");

        p1.addComment(c1);
        p1.addComment(c2);

        System.out.println(p1);
    }
}
