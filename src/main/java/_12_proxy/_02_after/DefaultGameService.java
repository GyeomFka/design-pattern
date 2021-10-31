package _12_proxy._02_after;

public class DefaultGameService implements GameService {

    @Override
    public void startGame() {
        System.out.println("게임서비스 -> 게임 시작");
    }
}
