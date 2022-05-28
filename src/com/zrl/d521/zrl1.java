
public class zrl1 {

	@Override
	protected void finalize()
	{

	}


	public static void main(String ...args) throws Exception
	{
		try {
			System.out.println(1 / 0);
		}catch (ArithmeticException e){
			System.out.println("0");
		}
	}
}
