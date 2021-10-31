package _12_proxy._01_before;

public class GameService {
    public void startGame() throws InterruptedException{
        System.out.println("게임 시작");
        Thread.sleep(1000L);
    }
}
