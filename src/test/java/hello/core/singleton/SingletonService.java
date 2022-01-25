package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    //static 메서드랑 static 클래스 언제 동작(생성) 되는지 ???
    //"자바 메모리 static 영역" 확인 !!!

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
