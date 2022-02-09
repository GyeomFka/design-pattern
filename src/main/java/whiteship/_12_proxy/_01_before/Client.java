package whiteship._12_proxy._01_before;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        //GameService gameService = new GameService();
//        GameService gameService = new GameServiceProxy();
        GameService gameService = new GameService();
        gameService.startGame();
        /*
        * 조건 1. 게임 서비스를 시작-끝 시간 확인 하고싶지만, 해당 객체를 건들 수가 없다.
        * gameservice가 gameservice관련 로직만 실행시키고 시간측정을 하고싶다.
        * client코드도 수정 불가능
        * 프록시 패턴을 사용하면 도메인 로직들을 둔 상태로 시간을 측정할 수 있다.
        * */
    }
}
