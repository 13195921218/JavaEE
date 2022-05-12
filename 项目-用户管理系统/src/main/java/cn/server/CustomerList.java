package cn.server;

import cn.bean.Customer;

/**
 * CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，
 * 并提供相应的添加、修改、删除和遍历方法，供CustomerView调用
 */
public class CustomerList {

    private  Customer[] customers;
    private int total = 0;

    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * 添加功能实现
     */
    public  boolean addCustomer(Customer customer){
        if (total >= customers.length){
            return false;
        }
        customers[total++] = customer;
        return true;
    }

    /**
     *
     * @return false true
     */
    public boolean replaceCustomer(int index,Customer cust){

        if (index >= 0 && index < total) {
            customers[index] = cust;
            return true;
        } else {// 替换成功返回true；false表示索引无效，无法替换
            return false;
        }
    }

    /**
     * 删除
     */
    public boolean deleteCustomer(int index){

        if (index >= 0 && index < total) {
            for(int i = index;i < total - 1 ;i++){
                customers[i] = customers[i + 1];
            }
            //最后有数据的元素需要置空
            customers[--total] = null;
//			total--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取所有信息
     */
    public Customer[] getAllCustomer(){
        Customer[] custs = new Customer[total];
        for(int i = 0;i < custs.length;i++){
            custs[i] = customers[i];
        }
        return custs;
    }

    public  Customer getCustomer(int index){
        if (index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    public int getTotal(){
        return total;
    }
}
