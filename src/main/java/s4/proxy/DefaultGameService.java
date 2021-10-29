package s4.proxy;

public class DefaultGameService implements GameService{

    @Override
    public void startGame() {
        System.out.println("게임 시작 인터페이스 변형");
    }
}
