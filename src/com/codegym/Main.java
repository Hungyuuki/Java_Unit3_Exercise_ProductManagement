package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Product[] cars = new Product[3];
        cars[0] = new Product(0, "Toyota", 130000, "brand new");
        cars[1] = new Product(1, "Kia", 100000, "brand new");
        cars[2] = new Product(2, "Hyundai", 100000, "like new");
        //Bài 1
        System.out.println("Original product list:");
        display(cars);
        System.out.println();
        //Bài 2
        Product carsAdd = new Product(3, "VinFast", 99999, "brand new");
        System.out.println("Thêm xe VinFast vào mảng cars vị trí thứ 2");
        Product[] newListCarAdd = addProduct(carsAdd, cars, 2);
        display(newListCarAdd);
        System.out.println();
        //Bài 3
        System.out.println("Bớt xe Kia ra khỏi mảng ban đầu:");
        Product[] newListCarRem = removeProduct(cars, 1);
        display(newListCarRem);
        System.out.println();
        //bài 4
        System.out.println("Product list after sort alphabet:");
        display(cars);
        System.out.println();
        //Bài 5
        System.out.println("Product list after sort alphabet:");
        display(cars);
        System.out.println();
        //bài 6
        Scanner inputNewID = new Scanner(System.in);
        Scanner inputNewName = new Scanner(System.in);
        Scanner inputNewPrice = new Scanner(System.in);
        Scanner inputNewDescription = new Scanner(System.in);
        System.out.println("Cập nhật loại xe mới:");
        System.out.println("Nhập ID mới: ");
        int newID = inputNewID.nextInt();
        System.out.println("Nhập tên mới: ");
        String newName = inputNewName.nextLine();
        System.out.println("Nhập giá: ");
        float newPrice = inputNewPrice.nextFloat();
        System.out.println("Nhập tình trạng: ");
        String newDescription = inputNewDescription.nextLine();
        Product productn = new Product(newID, newName, newPrice, newDescription);
        Product newCars[] = new Product[4];
        for (int j = 0; j < cars.length; j++) {
            newCars[j] = cars[j];
        }
        newCars[3] = productn;
        System.out.println("New car list:");
        display(newCars);
    }

    //    Hàm DisPlay hiển thị sản phẩm
    public static void display(Product[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //    Hàm thêm 1 sản phẩm
    public static Product[] addProduct(Product value, Product[] array, int index) {
        Product[] newAddCar = new Product[array.length + 1];
        for (int i = 0; i < newAddCar.length; i++) {
            if (i < index) {
                newAddCar[i] = array[i];
            } else if (i == index) {
                newAddCar[i] = value;
            } else {
                newAddCar[i] = array[i - 1];
            }
        }
        return newAddCar;
    }

    public static Product[] removeProduct(Product[] array, int index) {
        Product[] newRemCar = new Product[array.length - 1];
        for (int i = 0; i < newRemCar.length; i++) {
            if (i < index) {
                newRemCar[i] = array[i];
            } else {
                newRemCar[i] = array[i + 1];
            }
        }
        return newRemCar;
    }

    public static int findProductName(Product[] array, String name) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getName() == name) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void sort(Product[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].getName().compareTo(array[j].getName()) > 0) {
                    Product temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

//    public static void update(Product[] array, int index, int id, String name, long price, String description) {
//        array[index].setId(id);
//        array[index].setName(name);
//        array[index].setPrice(price);
//        array[index].setDescription(description);
//    }

}
