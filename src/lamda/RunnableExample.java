package lamda;

public class RunnableExample {

	public static void main(String[] args) {
		Thread th = new Thread(() -> System.out.print("Test"));
		th.start();
	}

}
