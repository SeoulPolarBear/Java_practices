public class LottoMain {
    public static void main(String[] args) {
        Lotto lotto1 = new Lotto();
        lotto1.setNum();
        lotto1.Answer();
        lotto1.printScore(lotto1.Score());
    }
}
