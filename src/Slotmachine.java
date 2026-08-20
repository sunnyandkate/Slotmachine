
import javax.swing.*;



import java.awt.*;
import java.awt.event.*;


public class Slotmachine {

	
	
	JPanel panel;
	JFrame frame;
	
	public JLabel label, slotOne, slotTwo, slotThree, textLabel, textContent;
	ImageIcon slotOneIcon, slotTwoIcon, slotThreeIcon;
	
	JLabel handle;
	MouseClick mouseClick;
	
	private int imgIndex1, imgIndex2, imgIndex3;
	
	float amount = 100;
	
	
	public Slotmachine() {
		
		
		init();
		initBackground();
		initText();
		
		
		frame.setVisible(true);
	}
	class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.repaint();
			
		}
		
	}
	class MouseClick implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			 startGame();
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			 handle.setBounds(387,190,50,30);
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			handle.setBounds(387,180,50,50);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
		
	public void init() {
		//Listeners
		Listener listener = new Listener();
		mouseClick = new MouseClick();
			
		//Frame
		frame = new JFrame("Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setLocationRelativeTo(null);
		frame.setSize(600, 600);
		frame.setResizable(false);
		frame.setLayout(null);
		
		
		//Background Panel
		//Panel
		panel = new JPanel();
		panel.setBounds(0, 0, 600, 600);
		panel.setBackground(new Color(153, 204, 255));
		panel.setLayout(null);
		frame.add(panel);
		
		
	}
	public void initText() {
		textContent = new JLabel("Your budget: ");
		textContent.setBounds(100, 450, 100, 50);
		textLabel = new JLabel();
		textLabel.setBounds(200, 450, 50, 50);
		textLabel.setText(Float.toString(amount));
		
		panel.add(textContent);
		panel.add(textLabel);
	}
	public void initBackground() {
		//Slotmachine
		//Label
		label = new JLabel();
		label.setBounds(103, 50, 400, 400);
		
		
		//Image
		//ImageIcon bgIcon = new ImageIcon("res/slotmachine.png");
		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("slotmachine.png"));
		label.setIcon(bgIcon);
		
		
		initSlots();
	
		
		panel.add(label);
	}
	public void initSlots() {
		
				
		//Slots
		//slot one
		slotOne = new JLabel();
		slotOne.setBounds(175,205,50,50);
				
		panel.add(slotOne);
		
		
		//slot two
		slotTwo = new JLabel();
		slotTwo.setBounds(240,205,50,50);
			
		panel.add(slotTwo);
		
		//slot three
		slotThree = new JLabel();
		slotThree.setBounds(300,205,50,50);
			
		panel.add(slotThree);
		
		
		showImages();
		//handle
		handle = new JLabel();
		handle.setBounds(387,180,50,50);
		
		//ImageIcon handleIcon = new ImageIcon("res/handle.png");
		ImageIcon handleIcon = new ImageIcon(getClass().getClassLoader().getResource("handle.png"));
		
		handle.setIcon(handleIcon);
		
		handle.addMouseListener(mouseClick);
		
		panel.add(handle);
	}
	public void showImages() {
		String [] images = {"Chichen Itza 12.jpg", "Misol Ha.jpg", "ocean.jpg", "Sumidero Canyon 4.jpg", "Thailand.jpg", "Xpu-Ha8.jpg"};
		
		imgIndex1 = (int) Math.floor(Math.random() * (images.length));
		imgIndex2 = (int) Math.floor(Math.random() * (images.length));
		imgIndex3 = (int) Math.floor(Math.random() * (images.length));
		
		slotOneIcon = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(images[imgIndex1])).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		slotOne.setIcon(slotOneIcon);
		
		slotTwoIcon = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(images[imgIndex2])).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		slotTwo.setIcon(slotTwoIcon);
		
		slotThreeIcon = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(images[imgIndex3])).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		slotThree.setIcon(slotThreeIcon);
	
		
	}
	public void startGame() {
		
		showImages();
			
		amount = amount - 10;
		
		textLabel.setText(Float.toString(amount));
				
		compareImages();
				
		if(amount < 10) {
			endGame();
		}
	}
	public void compareImages() {
		
		
		
		if(imgIndex1 == imgIndex2 && imgIndex2 == imgIndex3 && imgIndex1 == imgIndex3) {
			amount= amount + 100;			
			JOptionPane.showMessageDialog(null, "You have 3 matches. You win $ 100");
		}
		
		
		textLabel.setText(Float.toString(amount));
		
		
	}
	public void endGame() {
		
		 JOptionPane.showMessageDialog(null, "You have no money left.Game over!");
		 System.exit(0);
	}

	
	
}
