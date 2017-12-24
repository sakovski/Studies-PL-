import java.awt.EventQueue;


public class Application {

	public static void main(String[] args) {

		EventQueue.invokeLater(() ->
		{
			Model model = new Model();
			View view = new View();
			Controller controller = new Controller(view, model);
			
			
			view.setVisible(true);
		});

	}

}
