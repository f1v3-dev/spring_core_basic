package hello.core.singleton;

public class SingletonService {

    // 1. static 영역에 객체를 딱 1개만 생성한다.
    private static final SingletonService instance = new SingletonService();

    // 2. public으로 열어서 객체 인스턴스가 필요한 경우 static 메소드
    public static SingletonService getInstance(){
        return instance;
    }


    private SingletonService(){
        /**
         * 외부에서 호출하지 못하도록 private으로 생성자 선언
         * new SingletonService()로 생성 불가!
         */
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
