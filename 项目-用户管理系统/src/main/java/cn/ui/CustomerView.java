package cn.ui;

import cn.bean.Customer;
import cn.server.CustomerList;
import cn.util.CMUtility;

/**
 * CustomerView为主模块，负责菜单的显示和用户的处理
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView(){
        Customer customer = new Customer("叶博",'男',23,
                "13195921218","yebo_1218@163.com");
        customerList.addCustomer(customer);
    }

    public void enterMainView(){
        /**
         * ---------客户信息管理软件---------
         * 1添加客户
         * 2修改客户
         * 3删除客户
         * 4客户列表
         * 5退出
         * 请选择(1-5):
         */
        boolean isFlag = true;
        while (isFlag){
            System.out.println("--------------------客户信息管理软件--------------------");
            System.out.println("                       1添加客户                    ");
            System.out.println("                       2修改客户                    ");
            System.out.println("                       3删除客户                    ");
            System.out.println("                       4客户列表                    ");
            System.out.println("                       5退   出                    ");
            System.out.print("请选择(1-5)：");

            char selection = CMUtility.readMenuSelection();
            switch (selection){
                case '1':
                    addCustomer();
                    break;
                case '2':
                    replaceCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出（Y/N）：");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y'){
                        isFlag = false;
                    }
                    break;
            }
        }


    }

    public void addCustomer(){
        System.out.print("客户姓名: ");
        String name = CMUtility.readString(10);
        System.out.print("客户性别: ");
        char gender = CMUtility.readChar();
        System.out.print("客户年龄: ");
        int age = CMUtility.readInt();
        System.out.print("客户电话: ");
        String phone = CMUtility.readString(11);
        System.out.print("客户邮箱: ");
        String email = CMUtility.readString(20);

        Customer customer = new Customer(name, gender, age, phone, email);
        boolean flag = customerList.addCustomer(customer);
        if (flag){
            System.out.println("------------------------添加完成---------------------");
        }else {
            System.out.println("----------------------记录已满,无法添加--------------");
        }

    }

    public void replaceCustomer(){
        System.out.println("------------------------修改客户信息------------------------");
        int number = 0;
        for (;;) {
            System.out.print("请选择待修改客户编号(-1退出)：");
            number = CMUtility.readInt();
            if (number == -1) {
                return;
            }
            int sum = customerList.getTotal();
            if (number <= 0 || number > sum) {
                System.out.println("无法找到指定客户！");
            } else {
                break;
            }
        }
        Customer cust = customerList.getCustomer(number - 1);
        System.out.print("姓名：(" + cust.getName() + "):");
        String name = CMUtility.readString(10,cust.getName());
        System.out.print("性别：(" + cust.getGender() + "):");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.print("年龄：(" + cust.getAge() + "):");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("电话：(" + cust.getPhone() + "):");
        String phone = CMUtility.readString(11,cust.getPhone());
        System.out.print("邮箱：(" + cust.getEmail() + "):");
        String email = CMUtility.readString(20,cust.getEmail());
        cust = new Customer(name, gender, age, phone, email);

        boolean result = customerList.replaceCustomer(number - 1, cust);
        if (result) {
            System.out.println("---------------------修改完成---------------------");
        } else {
            System.out.println("---------无法找到指定客户,修改失败-------------------");
        }
    }

    public void deleteCustomer(){
        int index;
        for (;;){
            System.out.print("请选择要删除的客户(-1退出)：");
            index = CMUtility.readInt();
            if (index == -1){
                return;
            }
            int number = customerList.getTotal();
            if (index <= 0 || index > number){
                System.out.println("找不到客户信息！！！");
            }else {
                break;
            }
        }
        System.out.print("确认是否删除（Y/N）：");
        char isDelete = CMUtility.readConfirmSelection();

        if (isDelete == 'Y'){
            boolean result = customerList.deleteCustomer(index);
            if (result){
                System.out.println("---------------------删除成功---------------------");
            }else {
                System.out.println("---------------------删除失败---------------------");
            }
        }else {
            return;
        }
    }

    public void listAllCustomers(){
        System.out.println("--------------------客户列表--------------------");
        int total = customerList.getTotal();
        if (total == 0 ){
            System.out.println("没有客户记录！！！");
        }else {
            System.out.println("编号\t\t客户姓名\t\t性别\t\t年龄\t\t电话号码\t\t\t电子邮箱");
            Customer[] custs = customerList.getAllCustomer();
            for (int i = 0 ;i < custs.length;i++){
                Customer cust = custs[i];
                System.out.println((i+1) + "\t\t" + cust.getName() +
                        "\t\t\t" + cust.getGender() + "\t\t" + cust.getAge() +
                        "\t\t" + cust.getPhone() + "\t\t" + cust.getEmail());
            }
        }

    }

    public void getTotal(){
        int total = customerList.getTotal();
        System.out.println(total);
    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainView();
        view.getTotal();
    }
}
