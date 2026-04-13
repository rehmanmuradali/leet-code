package amazon;

public class OOP {

////    Write a program that allows the user to calculate the price of a pizza. A pizza has:
////
////            * a base
////* a size
////* toppings
////
////    Assume the system stores everything in-memory, no storage required.
////
//
//
//
//// Small, medium, large, -> size\
//// base -> Regular , nutrients free
//// topping -> tomatoes , olives,
//    // 100%, 150%
//
//
//    public enum ToppingType {
//        TOMATOE,
//        OLIVE
//    }
//
//
//    public abstract class PizzaBase {
//        SIZE size;
//
//        private PizzaBase(size, perUnitPrice){
//            this.size = size;
//            this.perUnitPrice = perUnitPrice;
//        }
//
//        double calculatePrice();
//    }
//
//    public class Regular extends PizzaBase {
//
//        public Regular (size, perUnitPrice) {
//            super(size, perUnitPrice)
//        }
//        double calculatePrice() {
//            return size * perUnitPrice;
//        }
//    }
//
//
//    public enum SIZE {
//        SMALL,
//        MEDIUM,
//        LARGE
//    }
//
//
//    public class Pizza {
//        PizzaBase base
//        SIZE size,
//        List<Topping> toppings;
//
//        pulic Pizza (PizzaBase base, Size size) {
//            this.base = base;
//            this.size = size;
//        }
//
//        pulic Pizza (PizzaBase base, Size size, List<Topping> toppings) {
//            this(base, size);
//            this.toppings = toppings;
//        }
//
//        double calculatePrice() {
//            double totalPrice = 0;
//            foreach(Toppping topping : toppings) {
//                totalPrice += topping.calculatePrice();
//            }
//            totalPrice += base.calculatePrice()
//            return totalPrice;
//        }
//
//    }
//
//    public class Topping {
//        SIZE size,
//        ToppingType toppingType;
//        double perUnitPrice;
//
//
//        public Topping(ToppingType toppingType, SIZE size, double perUnitPrice){
//            this.size = size;
//            this.toppingType = toppingType;
//            this.perUnitPrice = perUnitPrice;
//        }
//
//        public double calculatePrice() {
//            return size * perUnitPrice;
//        }
//    }
//

}
