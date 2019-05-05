package simple_pos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

public class Inventory {

	private int count = 0;
	private Item[] inventory = new Item[25];
	BufferedReader br = null;
	String line = "";
	
	Inventory(){
		try{
			br = new BufferedReader(new FileReader("Inventory.csv"));

			while ((line = br.readLine()) != null) {
				String item[] = line.split(",");
				inventory[count] = new Item(item[0], Double.parseDouble(item[1]), Integer.parseInt(item[2]), item[3], Integer.parseInt(item[4]));
				count++;
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(br !=null) {
				try {
					br.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void addToInventory(Item newItem) {
		for (int i = 0; i < inventory.length; i++) {
			if (newItem.getName().equals(inventory[i].getName())) {
				inventory[i].setQuantity(newItem.getQuantity()+inventory[i].getQuantity());
			}
			else
				System.out.println("Item doesn't exist");
		}
	}
	
	public void removeFromInventory(Item oldItem) {
		for (int i = 0; i < inventory.length; i++) {
			if(oldItem.getName().contentEquals(inventory[i].getName())) {
				int stockleft = inventory[i].getQuantity()-oldItem.getQuantity();
				if(stockleft < 0) {
					System.out.println("Only have " + inventory[i].getQuantity() + " " + inventory[i].getName());
				}
				else {
					inventory[i].setQuantity(stockleft);
					//run threshold check here?
				}
			}
			else {
				System.out.println("Item doesn't exist");
			}
		}
	}
}
