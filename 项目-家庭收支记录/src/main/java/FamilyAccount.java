public class FamilyAccount {
    public static void main(String[] args) {
        boolean isFlag = true;
        String details = "收    支\t\t账户余额\t\t收支金额\t\t说    明\n";
        int balance = 1000;
        while (isFlag){
            System.out.println("-----------------------------家庭收支记账软件----------------------------");
            System.out.println("                              1 收支明细");
            System.out.println("                              2 登记收入");
            System.out.println("                              3 登记支出");
            System.out.println("                              4 退   出");
            System.out.print("请选择（1-4）：");

            char selection = Utility.readMenuSelection();
            switch (selection){
                case '1':
                    System.out.println("-----------------------------当前收支明细记录-----------------------------");
                    System.out.println(details);
                    break;
                case '2':
                    System.out.print("本次收入金额：");
                    int money = Utility.readNumber();
                    System.out.print("本次收入说明：");
                    String info = Utility.readString();
                    System.out.print("登记成功\n");
                    balance += money;
                    details += ("收    支" + "\t\t" + balance + "\t\t"+ money + "\t\t\t" + info + "\n");
                    break;
                case '3':
                    System.out.print("本次支出金额：");
                    int money1 = Utility.readNumber();
                    System.out.print("本次支出说明：");
                    String info1 = Utility.readString();
                    if (balance >= money1){
                        balance -= money1;
                        details += ("支    出" + "\t\t" + balance + "\t\t\t"+ money1 + "\t\t\t" + info1 + "\n");
                        System.out.print("登记成功\n");
                    } else {
                        System.out.println("没钱了！！！");
                    }
                    break;
                case '4':
                    System.out.println("4 退    出");
                    System.out.println("确认是否退出（Y/N）：");
                    char isExit = Utility.readConfirmSelection();
                    if (isExit == 'Y'){
                        isFlag = false;
                    }
                    break;
            }


        }
    }
}
