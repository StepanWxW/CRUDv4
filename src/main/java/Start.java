import repository.implementation.PostRepositoryImpl;

public class Start {
    public static void main(String[] args) {

        PostRepositoryImpl postRepository = new PostRepositoryImpl();
//        postRepository.create(new Post("Postec", PostStatus.ACTIVE));
//        System.out.println(postRepository.getAll());
//        System.out.println(postRepository.getById(5L));
//        postRepository.update(new Post(5L,"NEw", PostStatus.DELETED));
//        System.out.println(postRepository.getById(5L));
        System.out.println(postRepository.getAll());
        postRepository.remove(5L);
        System.out.println(postRepository.getAll());
    }
}
