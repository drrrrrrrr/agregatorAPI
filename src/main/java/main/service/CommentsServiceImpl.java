package main.service;

import lombok.extern.slf4j.Slf4j;
import main.model.Comments;
import main.repository.CommentsRepository;
import main.repository.KindOfSportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    CommentsRepository commentsRepository;
    @Override
    public void addComment(Comments comment) {
        commentsRepository.save(comment);
    }
}
