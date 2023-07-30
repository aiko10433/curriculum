package check;


import constants.Constants;

public class Check {
	//課題①
	//【Check.java】にてフィールド変数firstNameとlastNameを宣言し、
	//firstName →　自分の名字　lastName →　自分の名前で初期化しなさい。
	//なお、変数のアクセス修飾子は「private」とする。
	private String firstName = "鈴木";
	private String lastName = "愛子";
	
	protected String getFirstName() {
        return firstName;
    }

    protected String getLastName() {
        return lastName;
    }
	
	private void printName(String firstName,String lastName) {
		 System.out.println("printNameメッソド　→　"+firstName+lastName);
	}
	
	//課題②
	//【Check.java】にてfirstNameとlastNameを引数で受け取って、
	//連結して表示させるメソッド「printName」を作成しなさい。
	//作成した関数のアクセス修飾子は「private」とする。
	
	//課題③
	//【Check.java】にてPetクラスとRobotPetクラスをインスタンス化して、下記の完成イメージを出力させなさい。
public static void main(String[] args) {
	String name = Constants.CHECK_CLASS_JAVA;
	String masterName = Constants.CHECK_CLASS_HOGE;
	String getName = Constants.CHECK_CLASS_R2D2;
	String getMasterName = Constants.CHECK_CLASS_LUKE;
	
	Pet pet = new Pet(name,masterName);
	RobotPet robotPet = new RobotPet(getName,getMasterName);
	
	Check check = new Check();
	String sei = check.getFirstName();
	String mei = check.getLastName();
	check.printName(sei,mei);
	pet.introduce();
	robotPet.introduce();
    }
}