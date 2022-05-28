public class zrl7
{
    public static void main(String[] args)
    {
        int i = 0;
        int j = 2;
        if (i++ > 0 & ++j > 1)//证明java是用e000 00e0表示false，00880001表示true
            System.out.println("zsls");
        if (i != 0) {//java有boolean类型，不能使用(!i）表示真假，必须是boolean类型或表达式结果
            System.out.printf("if %d ,%d\n", i, j);
        } else {
            System.out.printf("else %d , %d\n", i, j);
        }
    }
}