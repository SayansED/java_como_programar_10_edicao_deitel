package Cap_23_Page_752_ImplementingInterfaceRunnable;

// Classe PrintTask dorme por um tempo aleat�rio de 0 a 5 segundos
import java.security.SecureRandom;

import com.sun.source.tree.CatchTree;
import com.sun.source.tree.TryTree;

public class PrintTask implements Runnable{
	
	private static final SecureRandom generator = new SecureRandom();
	private final int sleepTime; // Tempo de adormecimento aleat�rio para a thread
	private final String taskName;
	
	public PrintTask(String taskName) {
		this.taskName = taskName;
		
		// Seleciona o tempo de adormecimento aleat�rio entre 0 e 5 segundos
		sleepTime = generator.nextInt(5000); // milessegundos
	}
	
	// M�todo run cont�m o c�digo que uma thread executar�
	@Override
	public void run() {
		// try catch necess�rio porque o m�todo sleep pode lan�ar uma exce��o verificada do tipo InterruptedException
		try { // Colcoa a thread para dormir pela quantidade de tempo sleepTime
			System.out.printf("%s going to sleep for %d milleseconds.%n",
					taskName, sleepTime);
			Thread.sleep(sleepTime);
		}
		catch (InterruptedException exception) {
			exception.printStackTrace();
			// currentThread ot�m uma refer�ncia � Thread em execu��o
			Thread.currentThread().interrupt(); // Reinterrompe a thread
		}
		
		// Impreme o nome da tarefa
		System.out.printf("%s done sleeping%n", taskName);
		
	}
} // End class
