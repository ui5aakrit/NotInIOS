
public class abcd {
	
	
	static int a;
	//static int[] rand ={0,0,0,0,1,9,8,4,0,00,0,0,0,0,2,0,0,7,0,6,0};
	static int[] rand ={0,1,0,0,0,5};
	
	public static void main(String[] args) {
		
		a = rand.length;
		abcd ab = new abcd();
		ab.print("Input is: ");
		int b= a/3;
		for(int i = 0;i<=b;i++) {
			ab.loop();
		}
		System.out.println();
		ab.print("Output is: ");
		
	}
	
	void print(String input) {
		System.out.print(input);
		for(int i=0;i<=a-1;i++) {
			System.out.print(rand[i]+ " ");
		}
	}
	
	void loop() {
		try {
			for(int i=a-1;i>=0;i--) {
				if(i-1<0) continue;
				
				else if(rand[i]==0 && rand[i-1]==0) {
					continue;
				}
				else if(rand[i]==0 && rand[i-1]!=0) {
					continue;
				}
				else if(rand[i]!=0 && rand[i-1]==0 ) {
					rand[i-1]=rand[i];
					rand[i]=0;
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
