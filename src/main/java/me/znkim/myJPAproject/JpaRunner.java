package me.znkim.myJPAproject;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*Post post = new Post();
        post.setTitle("샘플 타이틀");

        Comment comment = new Comment();
        comment.setComment("ㄹㅇ");
        post.addComment(comment);

        Comment comment2 = new Comment();
        comment2.setComment("ㅇㄱㄹㅇ 2222");
        post.addComment(comment2);
        */
        Session session = entityManager.unwrap(Session.class);
        //session.save(post);
        Post post1 = session.get(Post.class, 1);
        session.delete(post1);

    }

    private void studyAndAcount() {
        Account account = new Account();
        account.setUsername("howto");
        account.setPassword("moon");

        Study study = new Study();
        study.setName("JPA STUDY");
        study.setOwner(account);

        account.addStudy(study); // custom

        // persistant 상태의 객체
        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);

        Account znkim = session.load(Account.class, account.getId());

        System.out.println("===========END CODE==========");

        //entityManager.persist(account);
        //dirtychecking 상황변화를 감지한다. SQL이
    }
}
