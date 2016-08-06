import java.util.Random;

public class Jar {
	
	private static String mItem;
	private static int mMaxQuantity;
	private static int mItemsInJar;
	
	public Jar(String item, int maxQuantity) {
		mItem = item;
		mMaxQuantity = maxQuantity;
	}
	
	public String getItem() {
		return mItem;
	}
	
	public void setItem(String item) {
		mItem = item;	
	}
	
	public int getMaxQuantity() {
		return mMaxQuantity;
	}
	
	public void setMaxQuantity(int maxQuantity) {
		mMaxQuantity = maxQuantity;	
	}
	
	public void fillJar() {
		Random random = new Random();
		// + 1 ensures the random number is no less than 1
		mItemsInJar = random.nextInt(mMaxQuantity) + 1;  
	}
	
	public int getItemsInJar() {
		return mItemsInJar;	
	}
	
}