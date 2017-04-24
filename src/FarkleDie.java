import java.util.*;

public class FarkleDie {
	

	private int faceup;
	private boolean isKept;
	private boolean isScored;
	
	public FarkleDie(){
		isKept = false;
		roll();
	}
	
	public int getFaceup(){
		return faceup;
	}
	
	public void roll(){
		Random roller=new Random();
		faceup=roller.nextInt(6)+1;
	}
	
	public boolean getKept(){
		return isKept;
	}
	
	public void toggleKept(){
		isKept = !isKept;
	}
	
	public boolean getScored(){
		return isScored;
	}
	
	public void setScored(boolean s){
		isScored = s;
	}
	

}
