public class Answer {
    public void printEvenNums() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
        Answer ans = new Answer();
        ans.printEvenNums();
    }
}