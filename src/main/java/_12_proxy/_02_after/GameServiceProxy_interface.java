package _12_proxy._02_after;

public class GameServiceProxy_interface implements GameService{

    private GameService gameService;

    public GameServiceProxy_interface(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void startGame() {
        long before = System.currentTimeMillis();
        gameService.startGame();
        System.out.println(System.currentTimeMillis() - before);
    }
}
